package mum.waa.fd.app.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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
import mum.waa.fd.app.domain.AuthorityRole;
import mum.waa.fd.app.domain.Specialization;
import mum.waa.fd.app.service.AppointmentService;
import mum.waa.fd.app.service.DoctorService;

/**
 * <p>AppointmentController class.</p>
 *
 * @author Toan Quach
 * @version $Id: $Id
 */

@Controller
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;

	@Autowired
	private DoctorService doctorService;

	/**
	 * <p>showRegistrationAppointment.</p>
	 *
	 * @param appointment a {@link mum.waa.fd.app.domain.Appointment} object.
	 * @param model a {@link org.springframework.ui.Model} object.
	 * @return a {@link java.lang.String} object.
	 */
	@RequestMapping(value = "/appointments/register", method = RequestMethod.GET)
	public String showRegistrationAppointment(@ModelAttribute("appointment") Appointment appointment, Model model) {
		initData(appointment, model);
		return "appointment-creation";
	}

	/**
	 * <p>showRegistrationAppointment.</p>
	 *
	 * @param appointment a {@link mum.waa.fd.app.domain.Appointment} object.
	 * @param bindingResult a {@link org.springframework.validation.BindingResult} object.
	 * @param model a {@link org.springframework.ui.Model} object.
	 * @return a {@link java.lang.String} object.
	 */
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

	/**
	 * <p>findDoctorBySpecialization.</p>
	 *
	 * @param spec a {@link mum.waa.fd.app.domain.Specialization} object.
	 * @return a {@link java.util.Map} object.
	 */
	@RequestMapping(value = "/specializations/{spec}", method = RequestMethod.GET, consumes = "application/json", produces = {
			"application/json" })
	public @ResponseBody Map<Integer, String> findDoctorBySpecialization(@PathVariable("spec") Specialization spec) {
		Map<Integer, String> doctorMap = doctorService.findDoctorBySpecialization(spec);
		return doctorMap;
	}

	/**
	 * <p>showReschedulingAppointment.</p>
	 *
	 * @param appointment a {@link mum.waa.fd.app.domain.Appointment} object.
	 * @param appointmentId a {@link java.lang.Integer} object.
	 * @param model a {@link org.springframework.ui.Model} object.
	 * @return a {@link java.lang.String} object.
	 */
	@RequestMapping(value = "/appointments/{id}/reschedule", method = RequestMethod.GET)
	public String showReschedulingAppointment(@ModelAttribute("appointment") Appointment appointment,
			@PathVariable("id") Integer appointmentId, Model model) {
		appointment = appointmentService.getAppointment(appointmentId);
		model.addAttribute("appointment", appointment);
		return "appointment-reschedule";
	}

	/**
	 * <p>rescheduleAppointment.</p>
	 *
	 * @param appointment a {@link mum.waa.fd.app.domain.Appointment} object.
	 * @param bindingResult a {@link org.springframework.validation.BindingResult} object.
	 * @param id a {@link java.lang.Integer} object.
	 * @param model a {@link org.springframework.ui.Model} object.
	 * @return a {@link java.lang.String} object.
	 */
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

	/**
	 * <p>cancelAppointment.</p>
	 *
	 * @param id a {@link java.lang.Integer} object.
	 * @param model a {@link org.springframework.ui.Model} object.
	 * @return a {@link java.lang.String} object.
	 */
	@RequestMapping(value = "/appointments/{id}/cancel", method = RequestMethod.GET)
	public String cancelAppointment(@PathVariable("id") Integer id, Model model) {

		appointmentService.cancelAppointment(id);
		return "redirect:/patients/home";
	}

	/**
	 * <p>acceptAppointment.</p>
	 *
	 * @param id a {@link java.lang.Integer} object.
	 * @param model a {@link org.springframework.ui.Model} object.
	 * @return a {@link java.lang.String} object.
	 */
	@RequestMapping(value = "/appointments/{id}/accept", method = RequestMethod.GET)
	public String acceptAppointment(@PathVariable("id") Integer id, Model model) {

		appointmentService.acceptAppointment(id);
		return "redirect:/doctors/home";
	}

	/**
	 * <p>rejectAppointment.</p>
	 *
	 * @param id a {@link java.lang.Integer} object.
	 * @param model a {@link org.springframework.ui.Model} object.
	 * @return a {@link java.lang.String} object.
	 */
	@RequestMapping(value = "/appointments/{id}/reject", method = RequestMethod.GET)
	public String rejectAppointment(@PathVariable("id") Integer id, Model model) {

		appointmentService.acceptAppointment(id);
		return "redirect:/doctors/home";
	}

	/**
	 * <p>getAppointmentDetail.</p>
	 *
	 * @param appointment a {@link mum.waa.fd.app.domain.Appointment} object.
	 * @param id a {@link java.lang.Integer} object.
	 * @param model a {@link org.springframework.ui.Model} object.
	 * @param request a {@link javax.servlet.http.HttpServletRequest} object.
	 * @return a {@link java.lang.String} object.
	 */
	@RequestMapping(value = "/appointments/{id}/detail", method = RequestMethod.GET)
	public String getAppointmentDetail(@ModelAttribute("appointment") Appointment appointment,
			@PathVariable("id") Integer id, Model model, HttpServletRequest request) {

		appointment = appointmentService.getAppointment(id);
		model.addAttribute("appointment", appointment);

		if (request.isUserInRole(AuthorityRole.ROLE_PATIENT.toString())) {
			return "appointment-detail";
		} else {
			return "doctor-appointment-detail";
		}
	}

	/**
	 * <p>updateInvoiceDetail.</p>
	 *
	 * @param appointment a {@link mum.waa.fd.app.domain.Appointment} object.
	 * @param model a {@link org.springframework.ui.Model} object.
	 * @param request a {@link javax.servlet.http.HttpServletRequest} object.
	 * @return a {@link java.lang.String} object.
	 */
	@RequestMapping(value = "/appointments/update", method = RequestMethod.POST)
	public String updateInvoiceDetail(@ModelAttribute("appointment") Appointment appointment, Model model,
			HttpServletRequest request) {

		appointmentService.updateAppointment(appointment);

		return "redirect:/doctors/home";
	}
}
