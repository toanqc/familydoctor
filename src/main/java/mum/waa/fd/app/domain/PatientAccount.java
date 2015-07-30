package mum.waa.fd.app.domain;

public class PatientAccount extends Account{

	private String ssn;
	private AppointmentRecord appointmentRecord;
	
	/**
	 * @return the ssn
	 */
	public String getSSN() {
		return ssn;
	}

	/**
	 * @param ssn the ssn to set
	 */
	public void setSSN(String ssn) {
		this.ssn = ssn;
	}
	
	/**
	 * @return the appointmentRecord
	 */
	public AppointmentRecord getAppointmentRecord() {
		return appointmentRecord;
	}

	/**
	 * @param appointmentRecord the appointmentRecord to set
	 */
	public void setAppointmentRecord(AppointmentRecord appointmentRecord) {
		this.appointmentRecord = appointmentRecord;
	}
	
}
