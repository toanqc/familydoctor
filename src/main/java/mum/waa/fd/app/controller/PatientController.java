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
import mum.waa.fd.app.domain.PatientAccount;
import mum.waa.fd.app.service.PatientAccountService;
import mum.waa.fd.app.util.Pages;
import mum.waa.fd.app.validator.PasswordValidator;

@Controller
public class PatientController {

	@Autowired
	private PatientAccountService patientAccountService;

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.addValidators(new PasswordValidator());
	}

	@RequestMapping(value = "/patients/register", method = RequestMethod.GET)
	public String showRegistrationPatient(@ModelAttribute("patientAccount") PatientAccount patientAccount) {
		patientAccount.setGender(Gender.MALE);
		// dummy data for testing
		initDummy(patientAccount);
		return Pages.PATIENT_REGISTRATION.getValue();
	}

	@SuppressWarnings("deprecation")
	private void initDummy(PatientAccount patientAccount) {
		patientAccount.setFirstName("Toan");
		patientAccount.setLastName("Quach");
		patientAccount.setDateOfBirth(new Date("10/25/1083"));
		// patientAccount.getAddress().setZipcode("52556");
		patientAccount.setSSN("1111");
		patientAccount.setPhone("111-111-1111");
		// patientAccount.getUser().setEmail("toanqc@gmail.com");
		// patientAccount.getUser().setPassword("1111");
		// patientAccount.getUser().setConfirmPassword("1111");
	}

	@RequestMapping(value = "/patients", method = RequestMethod.POST)
	public String registerPatient(@Valid @ModelAttribute("patientAccount") PatientAccount patientAccount,
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return Pages.PATIENT_REGISTRATION.getValue();
		}

		patientAccountService.savePatient(patientAccount);

		redirectAttributes.addFlashAttribute("patientAccount", patientAccount);
		return "redirect:/patients/successful";
	}

	@RequestMapping(value = "/patients/successful", method = RequestMethod.GET)
	public String showRegistrationSuccessful(@ModelAttribute("patientAccount") PatientAccount patientAccount) {
		return Pages.PATIENT_REGISTRATION_SUCCESSFUL.getValue();
	}
}
