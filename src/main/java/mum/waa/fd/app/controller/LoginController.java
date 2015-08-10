package mum.waa.fd.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.waa.fd.app.domain.User;
import mum.waa.fd.app.domain.UserType;
import mum.waa.fd.app.service.UserService;
import mum.waa.fd.app.util.Pages;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogin(@ModelAttribute("user") User user) {
		return Pages.LOGIN.getValue();
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("user") User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return Pages.LOGIN.getValue();
		}

		user.setEmail("toanqc@gmail.com");
		user.setPassword("111111");
		User foundUser = userService.login(user.getEmail(), user.getPassword());
		if (foundUser == null) {
			return Pages.LOGIN.getValue();
		}

		if (UserType.PATIENT.equals(foundUser.getUserType())) {
			return Pages.PATIENT_HOME.getValue();
		}

		// TODO: need to complete for admin and doctor
		return null;
	}
}
