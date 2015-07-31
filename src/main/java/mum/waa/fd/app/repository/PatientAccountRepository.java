package mum.waa.fd.app.repository;

import java.util.List;

import mum.waa.fd.app.domain.PersonTest;

public interface PatientAccountRepository {

	/**
	 * 
	 * @param patient
	 */
	void insertPatientAccount(PersonTest patient);

	/**
	 * 
	 */
	List<PersonTest> getList();
}
