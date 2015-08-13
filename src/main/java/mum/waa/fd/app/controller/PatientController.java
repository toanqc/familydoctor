package mum.waa.fd.app.controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mum.waa.fd.app.domain.Appointment;
import mum.waa.fd.app.domain.Gender;
import mum.waa.fd.app.domain.Patient;
import mum.waa.fd.app.service.PatientService;
import mum.waa.fd.app.validator.PasswordValidator;

/**
 * The servlet controller for patient account
 *
 * @author Toan Quach
 * @version $Id: $Id
 */

@Controller
public class PatientController {

	@Autowired
	private PatientService patientService;

	/**
	 * <p>
	 * initBinder.
	 * </p>
	 *
	 * @param dataBinder
	 *            a {@link org.springframework.web.bind.WebDataBinder} object.
	 */
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.addValidators(new PasswordValidator());
	}

	/**
	 * <p>
	 * showRegistrationPatient.
	 * </p>
	 *
	 * @param patient
	 *            a {@link mum.waa.fd.app.domain.Patient} object.
	 * @return a {@link java.lang.String} object.
	 */
	@RequestMapping(value = "/patients/register", method = RequestMethod.GET)
	public String showRegistrationPatient(@ModelAttribute("patient") Patient patient) {
		patient.setGender(Gender.MALE);
		// dummy data for testing
		return "patient-registration";
	}

	/**
	 * <p>
	 * registerPatient.
	 * </p>
	 *
	 * @param patient
	 *            a {@link mum.waa.fd.app.domain.Patient} object.
	 * @param bindingResult
	 *            a {@link org.springframework.validation.BindingResult} object.
	 * @param redirectAttributes
	 *            a
	 *            {@link org.springframework.web.servlet.mvc.support.RedirectAttributes}
	 *            object.
	 * @return a {@link java.lang.String} object.
	 */
	@RequestMapping(value = "/patients", method = RequestMethod.POST)
	public String registerPatient(@Valid @ModelAttribute("patient") Patient patient, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return "patient-registration";
		}

		patientService.savePatient(patient);

		redirectAttributes.addFlashAttribute("patient", patient);
		return "redirect:/patients/successful";
	}

	/**
	 * <p>
	 * showRegistrationSuccessful.
	 * </p>
	 *
	 * @param patient
	 *            a {@link mum.waa.fd.app.domain.Patient} object.
	 * @return a {@link java.lang.String} object.
	 */
	@RequestMapping(value = "/patients/successful", method = RequestMethod.GET)
	public String showRegistrationSuccessful(@ModelAttribute("patient") Patient patient) {
		return "patient-registration-successful";
	}

	/**
	 * <p>
	 * showPatientHome.
	 * </p>
	 *
	 * @param patient
	 *            a {@link mum.waa.fd.app.domain.Patient} object.
	 * @param model
	 *            a {@link org.springframework.ui.Model} object.
	 * @param principal
	 *            a {@link java.security.Principal} object.
	 * @return a {@link java.lang.String} object.
	 */
	@RequestMapping(value = "/patients/home", method = RequestMethod.GET)
	public String showPatientHome(@ModelAttribute("patient") Patient patient, Model model, Principal principal) {
		Patient foundPatient = patientService.findPatientByEmail(principal.getName());
		Map<Date, List<Appointment>> upcomingAppointment = patientService
				.getUpcomingAppointment(foundPatient.getAppointmentList());
		Map<Date, List<Appointment>> overdueAppointment = patientService
				.getOverdueAppointment(foundPatient.getAppointmentList());

		model.addAttribute("upcomingAppointment", upcomingAppointment);
		model.addAttribute("overdueAppointment", overdueAppointment);
		return "patient-home";
	}
}
