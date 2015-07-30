package mum.waa.fd.app.controller;

//import mum.waa.fd.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
 
	//@Autowired
	//UserService userService;
 	
	//@Autowired
	//AdviceService adviceService;
 	
	@RequestMapping(value={"/","/home"}, method = RequestMethod.GET)
	public String mainPage(){
		return "Home";
	}
 
}
