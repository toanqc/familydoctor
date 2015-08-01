package mum.waa.fd.app.domain;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import mum.waa.fd.app.util.FamilyDoctorConstants;

//@Entity
//@Table(name = "DoctorAccount")
public class DoctorAccount extends Account {

	// @Id
	// @GeneratedValue
	// @Column(name = "ID")
	private int doctorId;

	@NotBlank(message = FamilyDoctorConstants.EMPTY_VALIDATION)
	// @Column(name = "LICENSE_NUMBER")
	private String licenseNumber;

	@NotNull
	// @Column(name = "SPECIALIZATION")
	private Specialization specialization;

	@Valid
	private AppointmentRecord appointmentRecord;

	public DoctorAccount(String firstName, String lastName, String phone, String email, String password,
			Address address, String licenseNumber, Specialization specialization) {
		super(firstName, lastName, phone, email, password, address);
		this.licenseNumber = licenseNumber;
		this.specialization = specialization;
		appointmentRecord = new AppointmentRecord(this);
	}

	/**
	 * @return the doctorId
	 */
	public int getDoctorId() {
		return doctorId;
	}

	/**
	 * @param doctorId
	 *            the doctorId to set
	 */
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	/**
	 * @return the licenseNumber
	 */
	public String getLicenseNumber() {
		return licenseNumber;
	}

	/**
	 * @param licenseNumber
	 *            the licenseNumber to set
	 */
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	/**
	 * @return the specialization
	 */
	public Specialization getSpecialization() {
		return specialization;
	}

	/**
	 * @param specialization
	 *            the specialization to set
	 */
	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
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
