package mum.waa.fd.app.domain;

import java.util.List;

public class AppointmentRecord {
	
	private Account account;
	private List<Appointment> appointmentList;	
	
	/**
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}
	
	/**
	 * @param account the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}
	
	/**
	 * @return the appointmentList
	 */
	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}
	
	/**
	 * @param appointmentList the appointmentList to set
	 */
	public void setAppointmentList(List<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}
	
}
