package mum.waa.fd.app.domain;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import mum.waa.fd.app.util.FamilyDoctorConstants;

public class Appointment {

	@NotNull
	@DateTimeFormat(pattern = FamilyDoctorConstants.DATE_FORMAT)
	private Date date;

	private String room;

	@NotNull
	private AppointmentStatus status;

	@Valid
	private Invoice invoice;

	public Appointment(Date date, String room, AppointmentStatus status) {
		this.date = date;
		this.room = room;
		this.status = status;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the status
	 */
	public AppointmentStatus getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(AppointmentStatus status) {
		this.status = status;
	}

	/**
	 * @return the room
	 */
	public String getRoom() {
		return room;
	}

	/**
	 * @param room
	 *            the room to set
	 */
	public void setRoom(String room) {
		this.room = room;
	}

	/**
	 * @return the invoice
	 */
	public Invoice getInvoice() {
		return invoice;
	}

	/**
	 * @param invoice
	 *            the invoice to set
	 */
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

}
