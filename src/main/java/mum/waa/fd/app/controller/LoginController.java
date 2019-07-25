package mum.waa.fd.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.waa.fd.app.domain.AuthorityRole;
import mum.waa.fd.app.domain.User;

@Controller
/**
 * <p>LoginController class.</p>
 *
 * @author kamanashisroy
 * @version $Id: $Id
 */
public class LoginController {

	/**
	 * <p>showLogin.</p>
	 *
	 * @param user a {@link mum.waa.fd.app.domain.User} object.
	 * @param request a {@link javax.servlet.http.HttpServletRequest} object.
	 * @return a {@link java.lang.String} object.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogin(@ModelAttribute("user") User user, HttpServletRequest request) {
		String path = redirectByRole(request);

		if ("".equals(path)) {
			return "login";
		}

		return path;
	}

	/**
	 * <p>loginSuccess.</p>
	 *
	 * @param request a {@link javax.servlet.http.HttpServletRequest} object.
	 * @return a {@link java.lang.String} object.
	 */
	@RequestMapping(value = "/login-success", method = RequestMethod.GET)
	public String loginSuccess(HttpServletRequest request) {
		String path = redirectByRole(request);

		if ("".equals(path)) {
			return "redirect:/home";
		}

		return path;
	}

	/**
	 * Redirect based on role of the user
	 * 
	 * @param request
	 * @return the redirect url
	 */
	private String redirectByRole(HttpServletRequest request) {
		if (request.isUserInRole(AuthorityRole.ROLE_PATIENT.toString())) {
			return "redirect:/patients/home";
		}

		if (request.isUserInRole(AuthorityRole.ROLE_DOCTOR.toString())) {
			return "redirect:/doctors/home";
		}

		if (request.isUserInRole(AuthorityRole.ROLE_ADMIN.toString())) {
			return "redirect:/admin";
		}

		return "";
	}

	/**
	 * <p>loginFailed.</p>
	 *
	 * @param user a {@link mum.waa.fd.app.domain.User} object.
	 * @param model a {@link org.springframework.ui.Model} object.
	 * @return a {@link java.lang.String} object.
	 */
	@RequestMapping(value = "/login-failed", method = RequestMethod.GET)
	public String loginFailed(@ModelAttribute("user") User user, Model model) {
		model.addAttribute("fail", true);
		return "login";
	}
	//yoni
	/**
	 * <p>logout.</p>
	 *
	 * @param model a {@link org.springframework.ui.Model} object.
	 * @return a {@link java.lang.String} object.
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model) {
		return "redirect:/home";
	}

	/**
	 * <p>error.</p>
	 *
	 * @param model a {@link org.springframework.ui.Model} object.
	 * @return a {@link java.lang.String} object.
	 */
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String error(Model model) {
		return "403";
	}
}
