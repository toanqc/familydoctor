package mum.waa.fd.app.service;

import mum.waa.fd.app.domain.PatientAccount;

/**
 * This interface will have all the operators which is belong to the
 * {@link PatientAccount} domain models, it controls all business logic for this
 * object and also provides all needed methods to proceed the business
 *
 * @author Toan Quach
 */
public interface PatientAccountService {

	/**
	 * Save {@link PatientAccount} to the database by calling the save method in
	 * repository
	 * 
	 * @param patientAccount the patient account to be saved
	 */
	void savePatient(PatientAccount patientAccount);
}
