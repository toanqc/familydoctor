package mum.waa.fd.app.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import mum.waa.fd.app.domain.Appointment;
import mum.waa.fd.app.domain.Patient;

/**
 * This interface will have all the operators which is belong to the
 * {@link mum.waa.fd.app.domain.Patient} domain models, it controls all business logic for this object
 * and also provides all needed methods to proceed the business
 *
 * @author Toan Quach
 * @version $Id: $Id
 */
public interface PatientService {

	/**
	 * Save {@link mum.waa.fd.app.domain.Patient} to the database by calling the save method in
	 * repository
	 *
	 * @param patient
	 *            the patient account to be saved
	 */
	void savePatient(Patient patient);

	/**
	 * Find a patient based on email address
	 *
	 * @param email
	 *            email to be found
	 * @return {@link mum.waa.fd.app.domain.Patient}
	 */
	Patient findPatientByEmail(String email);

	/**
	 * <p>getUpcomingAppointment.</p>
	 *
	 * @param appointmentList a {@link java.util.List} object.
	 * @return a {@link java.util.Map} object.
	 */
	Map<Date, List<Appointment>> getUpcomingAppointment(List<Appointment> appointmentList);

	/**
	 * <p>getOverdueAppointment.</p>
	 *
	 * @param appointmentList a {@link java.util.List} object.
	 * @return a {@link java.util.Map} object.
	 */
	Map<Date, List<Appointment>> getOverdueAppointment(List<Appointment> appointmentList);
}
