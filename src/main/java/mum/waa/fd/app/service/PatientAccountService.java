package mum.waa.fd.app.service;

import java.util.List;

import mum.waa.fd.app.domain.PersonTest;

/**
 *
 * @author Toan Quach
 */
public interface PatientAccountService {

	/**
	 * 
	 * @param patient
	 */
	void insertPatientAccount(PersonTest patient);

	/**
	 * 
	 * @return
	 */
	List<PersonTest> getList();
}
