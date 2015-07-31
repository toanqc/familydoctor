package mum.waa.fd.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
 
	//@Autowired
	//UserService userService;
 	
	@RequestMapping(value={"/home"}, method = RequestMethod.GET)
	public String mainPage(){
		return "home";
	}
}
