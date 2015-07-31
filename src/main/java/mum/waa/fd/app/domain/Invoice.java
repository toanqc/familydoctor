package mum.waa.fd.app.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import mum.waa.fd.app.util.FamilyDoctorConstants;

public class Invoice {

	@NotNull
	@DateTimeFormat(pattern = FamilyDoctorConstants.DATE_FORMAT)
	private Date dateCreated;

	@NotNull
	@Digits(integer = 6, fraction = 2, message = FamilyDoctorConstants.AMOUNT_VALIDATION)
	private BigDecimal amount;

	@NotNull
	private InvoiceStatus status;

	@NotBlank(message = FamilyDoctorConstants.EMPTY_VALIDATION)
	private String ccardLast4Digits;

	@DateTimeFormat(pattern = FamilyDoctorConstants.DATE_FORMAT)
	private Date datePaid;

	@Valid
	private Appointment appointment;

	@Valid
	private DoctorAccount doctor;

	@Valid
	private PatientAccount patient;

	/**
	 * @return the dateCreated
	 */
	public Date getDateCreated() {
		return dateCreated;
	}

	/**
	 * @param dateCreated
	 *            the dateCreated to set
	 */
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * @return the status
	 */
	public InvoiceStatus getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(InvoiceStatus status) {
		this.status = status;
	}

	/**
	 * @return the ccardLast4Digits
	 */
	public String getCcardLast4Digits() {
		return ccardLast4Digits;
	}

	/**
	 * @param ccardLast4Digits
	 *            the ccardLast4Digits to set
	 */
	public void setCcardLast4Digits(String ccardLast4Digits) {
		this.ccardLast4Digits = ccardLast4Digits;
	}

	/**
	 * @return the datePaid
	 */
	public Date getDatePaid() {
		return datePaid;
	}

	/**
	 * @param datePaid
	 *            the datePaid to set
	 */
	public void setDatePaid(Date datePaid) {
		this.datePaid = datePaid;
	}

	/**
	 * @return the appointment
	 */
	public Appointment getAppointment() {
		return appointment;
	}

	/**
	 * @param appointment
	 *            the appointment to set
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
	 * @param doctor
	 *            the doctor to set
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
	 * @param patient
	 *            the patient to set
	 */
	public void setPatient(PatientAccount patient) {
		this.patient = patient;
	}
}
