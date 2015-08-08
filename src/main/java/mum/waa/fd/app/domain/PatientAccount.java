package mum.waa.fd.app.domain;

import java.util.ArrayList;
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
@Table(name = "PatientAccount")
public class PatientAccount extends Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int patientId;

	@NotBlank(message = FamilyDoctorConstants.EMPTY_VALIDATION)
	@Size(min = 4, max = 4, message = FamilyDoctorConstants.EXACTLY_DIGITS_VALIDATION)
	@Column(name = "SSN")
	private String ssn;

	@Valid
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "PATIENT_ID")
	private List<Appointment> appointmentList;

	public PatientAccount(String firstName, String lastName, String phone, User user, Address address, String ssn) {
		super(firstName, lastName, phone, user, address);
		this.ssn = ssn;
		appointmentList = new ArrayList<Appointment>();
	}

	/**
	 * @return the patientId
	 */
	public int getPatientId() {
		return patientId;
	}

	/**
	 * @param patientId
	 *            the patientId to set
	 */
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	/**
	 * @return the ssn
	 */
	public String getSsn() {
		return ssn;
	}

	/**
	 * @param ssn
	 *            the ssn to set
	 */
	public void setSsn(String ssn) {
		this.ssn = ssn;
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
	 * @return the appointmentList
	 */
	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}

	/**
	 * @param appointmentList
	 *            the appointmentList to set
	 */
	public void setAppointmentList(List<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}
}
