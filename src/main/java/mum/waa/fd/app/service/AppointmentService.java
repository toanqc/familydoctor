package mum.waa.fd.app.service;

import java.util.Map;

import mum.waa.fd.app.domain.Appointment;

/**
 * <p>AppointmentService interface.</p>
 *
 * @author Toan Quach
 * @version $Id: $Id
 */
public interface AppointmentService {

	/**
	 * <p>getAllSpecialization.</p>
	 *
	 * @return a {@link java.util.Map} object.
	 */
	Map<String, String> getAllSpecialization();

	/**
	 * <p>saveAppointment.</p>
	 *
	 * @param appointment a {@link mum.waa.fd.app.domain.Appointment} object.
	 */
	void saveAppointment(Appointment appointment);

	/**
	 * <p>rescheduleAppointment.</p>
	 *
	 * @param appointment a {@link mum.waa.fd.app.domain.Appointment} object.
	 */
	void rescheduleAppointment(Appointment appointment);

	/**
	 * Get appointment information by appointment id
	 *
	 * @param id
	 *            the id to be found
	 * @return {@link mum.waa.fd.app.domain.Appointment}
	 */
	Appointment getAppointment(Integer id);

	/**
	 * <p>cancelAppointment.</p>
	 *
	 * @param id a {@link java.lang.Integer} object.
	 */
	void cancelAppointment(Integer id);

	/**
	 * <p>acceptAppointment.</p>
	 *
	 * @param id a {@link java.lang.Integer} object.
	 */
	void acceptAppointment(Integer id);

	/**
	 * <p>rejectAppointment.</p>
	 *
	 * @param id a {@link java.lang.Integer} object.
	 */
	void rejectAppointment(Integer id);

	/**
	 * <p>updateAppointment.</p>
	 *
	 * @param appointment a {@link mum.waa.fd.app.domain.Appointment} object.
	 */
	void updateAppointment(Appointment appointment);
}
