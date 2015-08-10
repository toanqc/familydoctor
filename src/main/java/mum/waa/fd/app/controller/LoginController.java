package mum.waa.fd.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import mum.waa.fd.app.domain.AuthorityRole;
import mum.waa.fd.app.domain.User;
import mum.waa.fd.app.util.Pages;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogin(@ModelAttribute("user") User user) {
		return Pages.LOGIN.getValue();
	}

	@RequestMapping(value = "/login-success", method = RequestMethod.GET)
	public String loginSuccess(HttpServletRequest request) {
		if (request.isUserInRole(AuthorityRole.ROLE_PATIENT.toString())) {
			return "redirect:/patients/home";
		}

		if (request.isUserInRole(AuthorityRole.ROLE_DOCTOR.toString())) {
			return "redirect:/doctors/home";
		}

		if (request.isUserInRole(AuthorityRole.ROLE_ADMIN.toString())) {
			return "redirect:/patients/admin";
		}

		return "redirect:/home";
	}

	@RequestMapping(value = "/login-failed", method = RequestMethod.GET)
	public String loginFailed(@ModelAttribute("user") User user, Model model) {
		model.addAttribute("fail", true);
		return Pages.LOGIN.getValue();
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, SessionStatus status) {
		status.setComplete();
		return "redirect:/home";
	}
}
