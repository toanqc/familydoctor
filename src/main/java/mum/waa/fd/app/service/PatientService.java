package mum.waa.fd.app.service;

import mum.waa.fd.app.domain.Patient;

/**
 * This interface will have all the operators which is belong to the
 * {@link Patient} domain models, it controls all business logic for this
 * object and also provides all needed methods to proceed the business
 *
 * @author Toan Quach
 */
public interface PatientService {

	/**
	 * Save {@link Patient} to the database by calling the save method in
	 * repository
	 * 
	 * @param patient the patient account to be saved
	 */
	void savePatient(Patient patient);
}
