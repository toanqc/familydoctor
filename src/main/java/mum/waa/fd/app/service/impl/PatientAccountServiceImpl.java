package mum.waa.fd.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.waa.fd.app.domain.PatientAccount;
import mum.waa.fd.app.repository.PatientAccountRepository;
import mum.waa.fd.app.service.PatientAccountService;

/**
 * 
 * @author Toan Quach
 */

@Service
@Transactional
public class PatientAccountServiceImpl implements PatientAccountService {

	@Autowired
	private PatientAccountRepository patientAccountRepository;

	@Override
	public void savePatient(PatientAccount patientAccount) {
		patientAccountRepository.save(patientAccount);
	}
}
