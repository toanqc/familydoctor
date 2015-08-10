package mum.waa.fd.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.waa.fd.app.domain.Authority;
import mum.waa.fd.app.domain.AuthorityRole;
import mum.waa.fd.app.domain.Patient;
import mum.waa.fd.app.repository.PatientRepository;
import mum.waa.fd.app.service.PatientService;

/**
 * 
 * @author Toan Quach
 */

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;

	@Override
	public void savePatient(Patient patient) {
		Authority authority = new Authority();
		authority.setAuthorityRole(AuthorityRole.PATIENT);
		patient.getUser().getAuthorities().add(authority);
		patientRepository.save(patient);
	}
}
