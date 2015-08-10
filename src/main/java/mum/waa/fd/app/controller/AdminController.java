package mum.waa.fd.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.waa.fd.app.domain.Doctor;

@Controller
public class AdminController {
	
	@RequestMapping("/admin")
	public String adminDashboard() {
		return "admin/dashboard";
	}
	
	@RequestMapping(value = "/admin/add-doctor", method = RequestMethod.GET)
	public String addDoctorAcount(Model model){
		return "admin/add-doctor";
	}
	
	@RequestMapping(value = "/admin/save-doctor", method = RequestMethod.POST)
	public String saveDoctorAcount(Doctor doctor, Model model){
		return "admin/add-doctor";
	}	
	
	@RequestMapping("/admin/account")
	public String modifyAdminAccount(){
		return "admin/account";
	}
	
}
