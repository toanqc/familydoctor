package mum.waa.fd.app.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import mum.waa.fd.app.domain.Patient;
import mum.waa.fd.app.domain.User;
import mum.waa.fd.app.util.FamilyDoctorConstants;

/**
 * This class is to handle the cross field validation for password and confirm
 * password of {@link User}
 * 
 * @see {@link User}
 * @author Toan Quach
 *
 */
public class PasswordValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Patient.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Patient patient = (Patient) target;
		if (!patient.getUser().getPassword().equals(patient.getUser().getConfirmPassword())) {
			errors.rejectValue("user.password", FamilyDoctorConstants.PASSWORD_NOTMATCH_VALIDATION);
		}
	}
}
