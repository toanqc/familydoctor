package mum.waa.fd.app.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import mum.waa.fd.app.util.FamilyDoctorConstants;

@Entity
/**
 * <p>Doctor class.</p>
 *
 * @author kamanashisroy
 * @version $Id: $Id
 */
@Table(name = "Doctor")
public class Doctor extends Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int doctorId;

	@NotBlank(message = FamilyDoctorConstants.EMPTY_VALIDATION)
	@Column(name = "LICENSE_NUMBER")
	private String licenseNumber;

	@NotNull
	@Column(name = "SPECIALIZATION")
	@Enumerated(EnumType.STRING)
	private Specialization specialization;

	@Valid
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "DOCTOR_ID")
	private List<Appointment> appointmentList;

	/**
	 * <p>Constructor for Doctor.</p>
	 */
	public Doctor() {
		// default constructor
	}

	/**
	 * <p>Constructor for Doctor.</p>
	 *
	 * @param firstName a {@link java.lang.String} object.
	 * @param lastName a {@link java.lang.String} object.
	 * @param dateOfBirth a {@link java.util.Date} object.
	 * @param gender a {@link mum.waa.fd.app.domain.Gender} object.
	 * @param phone a {@link java.lang.String} object.
	 * @param user a {@link mum.waa.fd.app.domain.User} object.
	 * @param address a {@link mum.waa.fd.app.domain.Address} object.
	 * @param licenseNumber a {@link java.lang.String} object.
	 * @param specialization a {@link mum.waa.fd.app.domain.Specialization} object.
	 */
	public Doctor(String firstName, String lastName, Date dateOfBirth, Gender gender, String phone, User user,
			Address address, String licenseNumber, Specialization specialization) {
		super(firstName, lastName, dateOfBirth, gender, phone, user, address);
		this.licenseNumber = licenseNumber;
		this.specialization = specialization;
		appointmentList = new ArrayList<Appointment>();
	}

	/**
	 * <p>getFullName.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getFullName() {
		return this.getFirstName() + " " + this.getLastName();
	}

	/**
	 * <p>Getter for the field <code>doctorId</code>.</p>
	 *
	 * @return the doctorId
	 */
	public int getDoctorId() {
		return doctorId;
	}

	/**
	 * <p>Setter for the field <code>doctorId</code>.</p>
	 *
	 * @param doctorId
	 *            the doctorId to set
	 */
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	/**
	 * <p>Getter for the field <code>licenseNumber</code>.</p>
	 *
	 * @return the licenseNumber
	 */
	public String getLicenseNumber() {
		return licenseNumber;
	}

	/**
	 * <p>Setter for the field <code>licenseNumber</code>.</p>
	 *
	 * @param licenseNumber
	 *            the licenseNumber to set
	 */
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	/**
	 * <p>Getter for the field <code>specialization</code>.</p>
	 *
	 * @return the specialization
	 */
	public Specialization getSpecialization() {
		return specialization;
	}

	/**
	 * <p>Setter for the field <code>specialization</code>.</p>
	 *
	 * @param specialization
	 *            the specialization to set
	 */
	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}

	/**
	 * <p>Getter for the field <code>appointmentList</code>.</p>
	 *
	 * @return the appointmentList
	 */
	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}

	/**
	 * <p>Setter for the field <code>appointmentList</code>.</p>
	 *
	 * @param appointmentList
	 *            the appointmentList to set
	 */
	public void setAppointmentList(List<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}
}
