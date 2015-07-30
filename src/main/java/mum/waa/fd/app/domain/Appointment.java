package mum.waa.fd.app.domain;

import java.util.Date;

public class Appointment {
	
	private Date date;
	private String status;
	private String room;
	private Invoice invoice;

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
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
	 * @return the room
	 */
	public String getRoom() {
		return room;
	}
	
	/**
	 * @param room the room to set
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
	 * @param invoice the invoice to set
	 */
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}	
	
}
