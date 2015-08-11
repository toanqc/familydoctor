package mum.waa.fd.app.service;

import java.util.Map;

import mum.waa.fd.app.domain.Doctor;
import mum.waa.fd.app.domain.Specialization;

public interface DoctorService {

	public void saveDoctor(Doctor doctor);

	/**
	 * 
	 * @param specialization
	 * @return
	 */
	Map<Integer, String> findDoctorBySpecialization(Specialization specialization);
}
