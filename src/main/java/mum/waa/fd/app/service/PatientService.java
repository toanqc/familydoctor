package mum.waa.fd.app.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import mum.waa.fd.app.domain.Appointment;
import mum.waa.fd.app.domain.Patient;

/**
 * This interface will have all the operators which is belong to the
 * {@link Patient} domain models, it controls all business logic for this object
 * and also provides all needed methods to proceed the business
 *
 * @author Toan Quach
 */
public interface PatientService {

	/**
	 * Save {@link Patient} to the database by calling the save method in
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
	 * @return {@link Patient}
	 */
	Patient findPatientByEmail(String email);

	/**
	 * 
	 * @param appointmentList
	 * @return
	 */
	Map<Date, List<Appointment>> mapAppointment(List<Appointment> appointmentList);
}
