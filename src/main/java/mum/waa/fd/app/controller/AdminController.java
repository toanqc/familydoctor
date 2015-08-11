package mum.waa.fd.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.ObjectError;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

import mum.waa.fd.app.service.DoctorService;
import mum.waa.fd.app.validator.PasswordValidator;
import mum.waa.fd.app.domain.Doctor;
import mum.waa.fd.app.domain.Specialization;

@Controller
public class AdminController {
	
	@Autowired
	DoctorService doctorService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateOfBirth = new SimpleDateFormat("MM/dd/yyyy");
	    dateOfBirth.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateOfBirth, true));
	}
	
	@RequestMapping("/admin")
	public String adminDashboard() {
		return "admin-dashboard";
	}

	@RequestMapping(value = "/admin/add-doctor", method = RequestMethod.GET)
	public String addDoctorAcount(@ModelAttribute("newDoctor") Doctor newDoctor, Model model) {
		
		model.addAttribute("specializations", Specialization.values());
		
		return "admin-add-doctor";
	}

	@RequestMapping(value = "/admin/save-doctor", method = RequestMethod.POST)
	public String saveDoctor(@ModelAttribute("newDoctor") @Valid Doctor newDoctor, Model model, 
		BindingResult result, RedirectAttributes redirectAttributes) {

		if( result.hasErrors() ){
			return "admin/add-doctor";
		}
		
		doctorService.saveDoctor(newDoctor);
		
		redirectAttributes.addFlashAttribute("message", "Doctor successfully added");	
		return "redirect:/admin/add-doctor";
	}

	@RequestMapping("/admin/account")
	public String modifyAdminAccount() {
		return "admin-account";
	}

}
