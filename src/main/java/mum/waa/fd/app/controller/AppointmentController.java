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
		initData(appointment, model);
		return "appointment-creation";
	}

	@RequestMapping(value = "/appointments", method = RequestMethod.POST)
	public String showRegistrationAppointment(@Valid @ModelAttribute("appointment") Appointment appointment,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			initData(appointment, model);
			return "appointment-creation";
		}

		appointmentService.saveAppointment(appointment);

		return "redirect:/patients/home";
	}

	/**
	 * Initialize data
	 * 
	 * @param appointment
	 * @param model
	 */
	private void initData(Appointment appointment, Model model) {
		appointment.getDoctor().setSpecialization(null);
		model.addAttribute("specializations", appointmentService.getAllSpecialization());
	}

	@RequestMapping(value = "/specializations/{spec}", method = RequestMethod.GET, consumes = "application/json", produces = {
			"application/json" })
	public @ResponseBody Map<Integer, String> findDoctorBySpecialization(@PathVariable("spec") Specialization spec) {
		Map<Integer, String> doctorMap = doctorService.findDoctorBySpecialization(spec);
		return doctorMap;
	}

	@RequestMapping(value = "/appointments/{id}/reschedule", method = RequestMethod.GET)
	public String showReschedulingAppointment(@ModelAttribute("appointment") Appointment appointment,
			@PathVariable("id") Integer appointmentId, Model model) {
		appointment = appointmentService.getAppointment(appointmentId);
		model.addAttribute("appointment", appointment);
		return "appointment-reschedule";
	}

	@RequestMapping(value = "/appointments/{id}/reschedule", method = RequestMethod.POST)
	public String rescheduleAppointment(@Valid @ModelAttribute("appointment") Appointment appointment,
			BindingResult bindingResult, @PathVariable("id") Integer id, Model model) {

		if (bindingResult.hasErrors()) {
			return "appointment-reschedule";
		}

		appointment.setAppointmentId(id);
		appointmentService.rescheduleAppointment(appointment);
		return "redirect:/patients/home";
	}

	@RequestMapping(value = "/appointments/{id}/cancel", method = RequestMethod.GET)
	public String cancelAppointment(@PathVariable("id") Integer id, Model model) {

		appointmentService.cancelAppointment(id);
		return "redirect:/patients/home";
	}
}
