package mum.waa.fd.app.service;

import java.util.Map;

import mum.waa.fd.app.domain.Appointment;

/**
 * 
 * @author Toan Quach
 *
 */
public interface AppointmentService {

	/**
	 * 
	 * @return
	 */
	Map<String, String> getAllSpecialization();

	/**
	 * 
	 * @param appointment
	 */
	void saveAppointment(Appointment appointment);
}
