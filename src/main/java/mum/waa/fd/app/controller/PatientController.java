package mum.waa.fd.app.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mum.waa.fd.app.domain.Gender;
import mum.waa.fd.app.domain.Patient;
import mum.waa.fd.app.service.PatientService;
import mum.waa.fd.app.util.Pages;
import mum.waa.fd.app.validator.PasswordValidator;

/**
 * The servlet controller for patient account
 * 
 * @author Toan Quach
 *
 */

@Controller
public class PatientController {

	@Autowired
	private PatientService patientService;

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.addValidators(new PasswordValidator());
	}

	/**
	 * 
	 * @param patient
	 * @return
	 */
	@RequestMapping(value = "/patients/register", method = RequestMethod.GET)
	public String showRegistrationPatient(@ModelAttribute("patient") Patient patient) {
		patient.setGender(Gender.MALE);
		// dummy data for testing
		initDummy(patient);
		return Pages.PATIENT_REGISTRATION.getValue();
	}

	/**
	 * 
	 * @param patient
	 */
	@SuppressWarnings("deprecation")
	private void initDummy(Patient patient) {
		patient.setFirstName("Toan");
		patient.setLastName("Quach");
		patient.setDateOfBirth(new Date("10/25/1083"));
		// patient.getAddress().setZipcode("52556");
		patient.setSSN("1111");
		patient.setPhone("111-111-1111");
		// patient.getUser().setEmail("toanqc@gmail.com");
		// patient.getUser().setPassword("1111");
		// patient.getUser().setConfirmPassword("1111");
	}

	/**
	 * 
	 * @param patient
	 * @param bindingResult
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "/patients", method = RequestMethod.POST)
	public String registerPatient(@Valid @ModelAttribute("patient") Patient patient, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return Pages.PATIENT_REGISTRATION.getValue();
		}

		patientService.savePatient(patient);

		redirectAttributes.addFlashAttribute("patient", patient);
		return "redirect:/patients/successful";
	}

	/**
	 * 
	 * @param patient
	 * @return
	 */
	@RequestMapping(value = "/patients/successful", method = RequestMethod.GET)
	public String showRegistrationSuccessful(@ModelAttribute("patient") Patient patient) {
		return Pages.PATIENT_REGISTRATION_SUCCESSFUL.getValue();
	}

	/**
	 * 
	 * @param patient
	 * @return
	 */
	@RequestMapping(value = "/patients/home", method = RequestMethod.GET)
	public String showPatientHome(@ModelAttribute("patient") Patient patient) {
		return Pages.PATIENT_HOME.getValue();
	}
}
