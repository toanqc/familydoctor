package mum.waa.fd.app.domain;

import java.util.Date;

public class Invoice {

	private Date date_created;
	private Double amount;
	private String status;
	private String ccardLast4Digits;
	private Date date_paid;	
	private Appointment appointment;
	private DoctorAccount doctor;
	private PatientAccount patient;
	
	/**
	 * @return the date_created
	 */
	public Date getDate_created() {
		return date_created;
	}
	
	/**
	 * @param date_created the date_created to set
	 */
	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}
	
	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}
	
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * @return the ccardLast4Digits
	 */
	public String getCcardLast4Digits() {
		return ccardLast4Digits;
	}
	
	/**
	 * @param ccardLast4Digits the ccardLast4Digits to set
	 */
	public void setCcardLast4Digits(String ccardLast4Digits) {
		this.ccardLast4Digits = ccardLast4Digits;
	}
	
	/**
	 * @return the date_paid
	 */
	public Date getDate_paid() {
		return date_paid;
	}
	
	/**
	 * @param date_paid the date_paid to set
	 */
	public void setDate_paid(Date date_paid) {
		this.date_paid = date_paid;
	}
	
	/**
	 * @return the appointment
	 */
	public Appointment getAppointment() {
		return appointment;
	}
	
	/**
	 * @param appointment the appointment to set
	 */
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	
	/**
	 * @return the doctor
	 */
	public DoctorAccount getDoctor() {
		return doctor;
	}
	
	/**
	 * @param doctor the doctor to set
	 */
	public void setDoctor(DoctorAccount doctor) {
		this.doctor = doctor;
	}
	
	/**
	 * @return the patient
	 */
	public PatientAccount getPatient() {
		return patient;
	}
	
	/**
	 * @param patient the patient to set
	 */
	public void setPatient(PatientAccount patient) {
		this.patient = patient;
	}	
	
}
