package mum.waa.fd.app.domain;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import mum.waa.fd.app.util.FamilyDoctorConstants;

public class PatientAccount extends Account {

	@NotBlank(message = FamilyDoctorConstants.EMPTY_VALIDATION)
	@Size(min = 4, max = 4, message = FamilyDoctorConstants.EXACTLY_DIGITS_VALIDATION)
	private String ssn;

	@Valid
	private AppointmentRecord appointmentRecord;

	public PatientAccount(String firstName, String lastName, String phone, String email, String password,
			Address address, String ssn) {
		super(firstName, lastName, phone, email, password, address);
		this.ssn = ssn;
		appointmentRecord = new AppointmentRecord(this);
	}

	/**
	 * @return the ssn
	 */
	public String getSSN() {
		return ssn;
	}

	/**
	 * @param ssn
	 *            the ssn to set
	 */
	public void setSSN(String ssn) {
		this.ssn = ssn;
	}

	/**
	 * @return the appointmentRecord
	 */
	public AppointmentRecord getAppointmentRecord() {
		return appointmentRecord;
	}

	/**
	 * @param appointmentRecord
	 *            the appointmentRecord to set
	 */
	public void setAppointmentRecord(AppointmentRecord appointmentRecord) {
		this.appointmentRecord = appointmentRecord;
	}
}
