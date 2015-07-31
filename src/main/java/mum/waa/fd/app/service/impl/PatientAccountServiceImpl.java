package mum.waa.fd.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.waa.fd.app.domain.PersonTest;
import mum.waa.fd.app.repository.PatientAccountRepository;
import mum.waa.fd.app.service.PatientAccountService;

/**
 * 
 * @author Toan Quach
 */

@Service
public class PatientAccountServiceImpl implements PatientAccountService {

	@Autowired
	private PatientAccountRepository patientAccountRepository;

	@Override
	public void insertPatientAccount(PersonTest patient) {
		patientAccountRepository.insertPatientAccount(patient);
	}

	@Override
	public List<PersonTest> getList() {
		return patientAccountRepository.getList();
	}
}
