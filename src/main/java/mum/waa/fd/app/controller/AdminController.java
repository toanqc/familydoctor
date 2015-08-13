package mum.waa.fd.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mum.waa.fd.app.domain.Doctor;
import mum.waa.fd.app.service.AppointmentService;
import mum.waa.fd.app.service.DoctorService;
import mum.waa.fd.app.util.FamilyDoctorConstants;

@Controller
/**
 * <p>AdminController class.</p>
 *
 * @author kamanashisroy
 * @version $Id: $Id
 */
public class AdminController {

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private AppointmentService appointmentService;

	/**
	 * <p>initBinder.</p>
	 *
	 * @param binder a {@link org.springframework.web.bind.WebDataBinder} object.
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateOfBirth = new SimpleDateFormat(FamilyDoctorConstants.DATE_FORMAT);
		dateOfBirth.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateOfBirth, true));
	}

	/**
	 * <p>adminDashboard.</p>
	 *
	 * @param model a {@link org.springframework.ui.Model} object.
	 * @return a {@link java.lang.String} object.
	 */
	@RequestMapping("/admin")
	public String adminDashboard(Model model) {
		List<Doctor> doctors = doctorService.getAll();
		model.addAttribute("doctors", doctors);
		return "admin-dashboard";
	}

	/**
	 * <p>addDoctorAcount.</p>
	 *
	 * @param newDoctor a {@link mum.waa.fd.app.domain.Doctor} object.
	 * @param model a {@link org.springframework.ui.Model} object.
	 * @return a {@link java.lang.String} object.
	 */
	@RequestMapping(value = "/admin/add-doctor", method = RequestMethod.GET)
	public String addDoctorAcount(@ModelAttribute("newDoctor") Doctor newDoctor, Model model) {

		model.addAttribute("specializations", appointmentService.getAllSpecialization());
		return "admin-add-doctor";
	}

	/**
	 * <p>saveDoctor.</p>
	 *
	 * @param newDoctor a {@link mum.waa.fd.app.domain.Doctor} object.
	 * @param bindingResult a {@link org.springframework.validation.BindingResult} object.
	 * @param redirectAttributes a {@link org.springframework.web.servlet.mvc.support.RedirectAttributes} object.
	 * @return a {@link java.lang.String} object.
	 */
	@RequestMapping(value = "/admin/save-doctor", method = RequestMethod.POST)
	public String saveDoctor(@Valid @ModelAttribute("newDoctor") Doctor newDoctor, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		if (!newDoctor.getUser().getPassword().isEmpty()
				&& !newDoctor.getUser().getPassword().equals(newDoctor.getUser().getConfirmPassword())) {
			ObjectError err = new ObjectError("passwordMath", "Password and Confirm Password do not match");

			bindingResult.addError(err);
		}

		if (bindingResult.hasErrors()) {
			return "admin-add-doctor";
		}

		doctorService.saveDoctor(newDoctor);

		redirectAttributes.addFlashAttribute("message", "Doctor successfully added!");
		return "redirect:/admin/add-doctor";
	}

	/**
	 * <p>modifyAdminAccount.</p>
	 *
	 * @param doctorId a int.
	 * @param model a {@link org.springframework.ui.Model} object.
	 * @return a {@link java.lang.String} object.
	 */
	@RequestMapping(value = "/admin/doctor/{doctorId}", method = RequestMethod.GET)
	public String modifyAdminAccount(@PathVariable int doctorId, Model model) {

		Doctor doctor = doctorService.findDoctorById(doctorId);
		model.addAttribute("doctor", doctor);
		model.addAttribute("specializations", appointmentService.getAllSpecialization());

		return "admin-doctor-account";
	}

	/**
	 * <p>editDoctor.</p>
	 *
	 * @param doctor a {@link mum.waa.fd.app.domain.Doctor} object.
	 * @param bindingResult a {@link org.springframework.validation.BindingResult} object.
	 * @param redirectAttributes a {@link org.springframework.web.servlet.mvc.support.RedirectAttributes} object.
	 * @return a {@link java.lang.String} object.
	 */
	@RequestMapping(value = "/admin/doctor/{doctorId}", method = RequestMethod.POST)
	public String editDoctor(@Valid Doctor doctor, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

		if (!doctor.getUser().getPassword().isEmpty()
				&& !doctor.getUser().getPassword().equals(doctor.getUser().getConfirmPassword())) {
			ObjectError err = new ObjectError("passwordMath", "Password and Confirm Password do not match");

			bindingResult.addError(err);
		}

		if (bindingResult.hasErrors() && ((!bindingResult.hasFieldErrors("user.password")
				&& !bindingResult.hasFieldErrors("user.confirmPassword"))
				|| ((bindingResult.hasFieldErrors("user.password")
						&& bindingResult.hasFieldErrors("user.confirmPassword")
						&& bindingResult.getErrorCount() > 2)))) {

			return "admin-doctor-account";
		}

		doctorService.updateDoctor(doctor);
		redirectAttributes.addFlashAttribute("message", "Doctor info updated!");

		return "redirect:/admin/doctor/" + doctor.getDoctorId();
	}
}
