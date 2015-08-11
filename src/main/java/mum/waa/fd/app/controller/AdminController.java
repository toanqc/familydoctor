package mum.waa.fd.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mum.waa.fd.app.domain.Doctor;
import mum.waa.fd.app.domain.Specialization;
import mum.waa.fd.app.service.DoctorService;
import mum.waa.fd.app.util.FamilyDoctorConstants;

@Controller
public class AdminController {

	@Autowired
	DoctorService doctorService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateOfBirth = new SimpleDateFormat(FamilyDoctorConstants.DATE_FORMAT);
		dateOfBirth.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateOfBirth, true));
	}

	@RequestMapping("/admin")
	public String adminDashboard(Model model) {
		List<Doctor> doctors = doctorService.getAll();
		model.addAttribute("doctors", doctors);
		return "admin-dashboard";
	}

	@RequestMapping(value = "/admin/add-doctor", method = RequestMethod.GET)
	public String addDoctorAcount(@ModelAttribute("newDoctor") Doctor newDoctor, Model model) {

		model.addAttribute("specializations", Specialization.values());

		return "admin-add-doctor";
	}

	@RequestMapping(value = "/admin/save-doctor", method = RequestMethod.POST)
	public String saveDoctor(@Valid @ModelAttribute("newDoctor") Doctor newDoctor, Model model, BindingResult result,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
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
