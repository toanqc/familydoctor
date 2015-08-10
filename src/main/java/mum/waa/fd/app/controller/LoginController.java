package mum.waa.fd.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.waa.fd.app.domain.User;
import mum.waa.fd.app.util.Pages;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogin(@ModelAttribute("user") User user) {
		return Pages.LOGIN.getValue();
	}

	@RequestMapping(value = "/login-success", method = RequestMethod.GET)
	public String loginSuccess() {
		return "redirect:/patients/home";
	}

	@RequestMapping(value = "/login-failed", method = RequestMethod.GET)
	public String loginFailed(@ModelAttribute("user") User user, Model model) {
		model.addAttribute("fail", true);
		return Pages.LOGIN.getValue();
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout() {
		return "redirect:/home";
	}
}
