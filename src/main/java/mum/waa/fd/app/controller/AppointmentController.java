package mum.waa.fd.app.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mum.waa.fd.app.domain.Appointment;
import mum.waa.fd.app.domain.Specialization;
import mum.waa.fd.app.service.AppointmentService;
import mum.waa.fd.app.service.DoctorService;

/**
 * 
 * @author Toan Quach
 *
 */

@Controller
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;

	@Autowired
	private DoctorService doctorService;

	@RequestMapping(value = "/appointments/register", method = RequestMethod.GET)
	public String showRegistrationAppointment(@ModelAttribute("appointment") Appointment appointment, Model model) {

		model.addAttribute("specializations", appointmentService.getAllSpecialization());
		return "appointment-creation";
	}

	@RequestMapping(value = "/appointments", method = RequestMethod.POST)
	public String showRegistrationAppointment(@Valid @ModelAttribute("appointment") Appointment appointment,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "appointment-creation";
		}

		return "redirect:/patients/home";
	}

	@RequestMapping(value = "/specializations/{spec}", method = RequestMethod.GET, consumes = "application/json", produces = {
			"application/json" })
	public @ResponseBody Map<Integer, String> findDoctorBySpecialization(@PathVariable("spec") Specialization spec) {
		Map<Integer, String> doctorMap = doctorService.findDoctorBySpecialization(spec);
		return doctorMap;
	}
}
