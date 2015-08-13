package mum.waa.fd.app.domain;

import java.util.Date;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import mum.waa.fd.app.util.FamilyDoctorConstants;

@Entity
/**
 * <p>Appointment class.</p>
 *
 * @author kamanashisroy
 * @version $Id: $Id
 */
@Table(name = "Appointment")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int appointmentId;

	@NotNull(message = FamilyDoctorConstants.EMPTY_VALIDATION)
	@DateTimeFormat(pattern = FamilyDoctorConstants.DATE_FORMAT)
	@Column(name = "DATE")
	private Date date;

	@NotBlank(message = FamilyDoctorConstants.EMPTY_VALIDATION)
	@Column(name = "TIME")
	@Size(min = 1, max = 10, message = FamilyDoctorConstants.RANGE_LETTERS_VALIDATION)
	private String time;

	@Column(name = "ROOM")
	private String room;

	@NotBlank(message = FamilyDoctorConstants.EMPTY_VALIDATION)
	@Column(name = "DESCRIPTION")
	private String description;

	@NotNull
	@Column(name = "STATUS")
	@Enumerated(EnumType.STRING)
	private AppointmentStatus status = AppointmentStatus.NEW;

	@Valid
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "INVOICE_ID")
	private Invoice invoice;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Patient.class)
	@JoinColumn(name = "PATIENT_ID")
	private Patient patient;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Doctor.class)
	@JoinColumn(name = "DOCTOR_ID")
	private Doctor doctor;

	/**
	 * <p>Constructor for Appointment.</p>
	 */
	public Appointment() {
		this.invoice = new Invoice();
		this.patient = new Patient();
		this.doctor = new Doctor();
	}

	/**
	 * <p>Constructor for Appointment.</p>
	 *
	 * @param date a {@link java.util.Date} object.
	 * @param room a {@link java.lang.String} object.
	 * @param status a {@link mum.waa.fd.app.domain.AppointmentStatus} object.
	 */
	public Appointment(Date date, String room, AppointmentStatus status) {
		this.date = date;
		this.room = room;
		this.status = status;
	}

	/**
	 * <p>Getter for the field <code>appointmentId</code>.</p>
	 *
	 * @return the appointmentId
	 */
	public int getAppointmentId() {
		return appointmentId;
	}

	/**
	 * <p>Setter for the field <code>appointmentId</code>.</p>
	 *
	 * @param appointmentId
	 *            the appointmentId to set
	 */
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	/**
	 * <p>Getter for the field <code>date</code>.</p>
	 *
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * <p>Setter for the field <code>date</code>.</p>
	 *
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * <p>Getter for the field <code>status</code>.</p>
	 *
	 * @return the status
	 */
	public AppointmentStatus getStatus() {
		return status;
	}

	/**
	 * <p>Setter for the field <code>status</code>.</p>
	 *
	 * @param status
	 *            the status to set
	 */
	public void setStatus(AppointmentStatus status) {
		this.status = status;
	}

	/**
	 * <p>Getter for the field <code>room</code>.</p>
	 *
	 * @return the room
	 */
	public String getRoom() {
		return room;
	}

	/**
	 * <p>Setter for the field <code>room</code>.</p>
	 *
	 * @param room
	 *            the room to set
	 */
	public void setRoom(String room) {
		this.room = room;
	}

	/**
	 * <p>Getter for the field <code>time</code>.</p>
	 *
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * <p>Setter for the field <code>time</code>.</p>
	 *
	 * @param time
	 *            the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * <p>Getter for the field <code>description</code>.</p>
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <p>Setter for the field <code>description</code>.</p>
	 *
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * <p>Getter for the field <code>invoice</code>.</p>
	 *
	 * @return the invoice
	 */
	public Invoice getInvoice() {
		return invoice;
	}

	/**
	 * <p>Setter for the field <code>invoice</code>.</p>
	 *
	 * @param invoice
	 *            the invoice to set
	 */
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	/**
	 * <p>Getter for the field <code>doctor</code>.</p>
	 *
	 * @return the doctor
	 */
	public Doctor getDoctor() {
		return doctor;
	}

	/**
	 * <p>Setter for the field <code>doctor</code>.</p>
	 *
	 * @param doctor
	 *            the doctor to set
	 */
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	/**
	 * <p>Getter for the field <code>patient</code>.</p>
	 *
	 * @return the patient
	 */
	public Patient getPatient() {
		return patient;
	}

	/**
	 * <p>Setter for the field <code>patient</code>.</p>
	 *
	 * @param patient
	 *            the patient to set
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
}
