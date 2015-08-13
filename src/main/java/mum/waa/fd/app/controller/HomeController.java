package mum.waa.fd.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
/**
 * <p>HomeController class.</p>
 *
 * @author kamanashisroy
 * @version $Id: $Id
 */
public class HomeController {

	/**
	 * <p>mainPage.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String mainPage() {
		return "home";
	}
}
