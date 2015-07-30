package mum.waa.fd.app.domain;

public class DoctorAccount extends Account{
	
	private String licenseNumber;
	private String specialization;	
	private AppointmentRecord appointmentRecord;
	
	/**
	 * @return the licenseNumber
	 */
	public String getLicenseNumber() {
		return licenseNumber;
	}
	
	/**
	 * @param licenseNumber the licenseNumber to set
	 */
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	
	/**
	 * @return the specialization
	 */
	public String getSpecialization() {
		return specialization;
	}
	
	/**
	 * @param specialization the specialization to set
	 */
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
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
