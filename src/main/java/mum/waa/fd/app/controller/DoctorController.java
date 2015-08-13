package mum.waa.fd.app.controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.waa.fd.app.domain.Appointment;
import mum.waa.fd.app.domain.Doctor;
import mum.waa.fd.app.service.DoctorService;

/**
 * <p>DoctorController class.</p>
 *
 * @author Toan Quach
 * @version $Id: $Id
 */

@Controller
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	/**
	 * <p>showPatientHome.</p>
	 *
	 * @param doctor a {@link mum.waa.fd.app.domain.Doctor} object.
	 * @param model a {@link org.springframework.ui.Model} object.
	 * @param principal a {@link java.security.Principal} object.
	 * @return a {@link java.lang.String} object.
	 */
	@RequestMapping(value = "/doctors/home", method = RequestMethod.GET)
	public String showPatientHome(@ModelAttribute("doctor") Doctor doctor, Model model, Principal principal) {
		Doctor foundDoctor = doctorService.findDoctorByEmail(principal.getName());
		Map<Date, List<Appointment>> upcomingAppointment = doctorService
				.getUpcomingAppointment(foundDoctor.getAppointmentList());
		Map<Date, List<Appointment>> overdueAppointment = doctorService
				.getOverdueAppointment(foundDoctor.getAppointmentList());

		model.addAttribute("upcomingAppointment", upcomingAppointment);
		model.addAttribute("overdueAppointment", overdueAppointment);
		model.addAttribute("doctor", foundDoctor);
		return "doctor-home";
	}
}
