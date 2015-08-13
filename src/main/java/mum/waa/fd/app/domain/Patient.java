package mum.waa.fd.app.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import mum.waa.fd.app.util.FamilyDoctorConstants;

@Entity
/**
 * <p>Patient class.</p>
 *
 * @author kamanashisroy
 * @version $Id: $Id
 */
@Table(name = "Patient")
public class Patient extends Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int patientId;

	@NotBlank(message = FamilyDoctorConstants.EMPTY_VALIDATION)
	@Size(min = 4, max = 4, message = FamilyDoctorConstants.EXACTLY_DIGITS_VALIDATION)
	@Column(name = "SSN")
	private String ssn;

	@Valid
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "PATIENT_ID")
	private List<Appointment> appointmentList;

	/**
	 * <p>Constructor for Patient.</p>
	 */
	public Patient() {
		// default constructor
	}

	/**
	 * <p>Constructor for Patient.</p>
	 *
	 * @param firstName a {@link java.lang.String} object.
	 * @param lastName a {@link java.lang.String} object.
	 * @param dateOfBirth a {@link java.util.Date} object.
	 * @param gender a {@link mum.waa.fd.app.domain.Gender} object.
	 * @param phone a {@link java.lang.String} object.
	 * @param user a {@link mum.waa.fd.app.domain.User} object.
	 * @param address a {@link mum.waa.fd.app.domain.Address} object.
	 * @param ssn a {@link java.lang.String} object.
	 */
	public Patient(String firstName, String lastName, Date dateOfBirth, Gender gender, String phone, User user,
			Address address, String ssn) {
		super(firstName, lastName, dateOfBirth, gender, phone, user, address);
		this.ssn = ssn;
		appointmentList = new ArrayList<Appointment>();
	}

	/**
	 * <p>Getter for the field <code>patientId</code>.</p>
	 *
	 * @return the patientId
	 */
	public int getPatientId() {
		return patientId;
	}

	/**
	 * <p>Setter for the field <code>patientId</code>.</p>
	 *
	 * @param patientId
	 *            the patientId to set
	 */
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	/**
	 * <p>Getter for the field <code>ssn</code>.</p>
	 *
	 * @return the ssn
	 */
	public String getSsn() {
		return ssn;
	}

	/**
	 * <p>Setter for the field <code>ssn</code>.</p>
	 *
	 * @param ssn
	 *            the ssn to set
	 */
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	/**
	 * <p>getSSN.</p>
	 *
	 * @return the ssn
	 */
	public String getSSN() {
		return ssn;
	}

	/**
	 * <p>setSSN.</p>
	 *
	 * @param ssn
	 *            the ssn to set
	 */
	public void setSSN(String ssn) {
		this.ssn = ssn;
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
