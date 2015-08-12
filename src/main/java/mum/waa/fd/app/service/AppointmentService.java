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

	/**
	 * 
	 * @param appointment
	 */
	void rescheduleAppointment(Appointment appointment);

	/**
	 * Get appointment information by appointment id
	 * 
	 * @param id
	 *            the id to be found
	 * @return {@link Appointment}
	 */
	Appointment getAppointment(Integer id);

	/**
	 * 
	 * @param id
	 */
	void cancelAppointment(Integer id);

	/**
	 * 
	 * @param id
	 */
	void acceptAppointment(Integer id);

	/**
	 * 
	 * @param id
	 */
	void rejectAppointment(Integer id);

	/**
	 * 
	 * @param id
	 */
	void updateAppointment(Appointment appointment);
}
