package mum.waa.fd.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.waa.fd.app.domain.PatientAccount;
import mum.waa.fd.app.service.PatientAccountService;
import mum.waa.fd.app.util.Pages;

@Controller
@RequestMapping("/patients")
public class PatientController {

	@Autowired
	private PatientAccountService patientAccountService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegistrationPatient(@ModelAttribute("patientAccount") PatientAccount patientAccount) {
		return Pages.PATIENT_REGISTRATION_SUCCESSFUL.getValue();
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String registerPatient(@ModelAttribute("patientAccount") PatientAccount patientAccount,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return Pages.PATIENT_REGISTRATION.getValue();
		}

		patientAccountService.savePatient(patientAccount);

		return Pages.PATIENT_REGISTRATION_SUCCESSFUL.getValue();
	}
}
