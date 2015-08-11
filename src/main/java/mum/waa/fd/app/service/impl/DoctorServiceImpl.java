package mum.waa.fd.app.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.waa.fd.app.domain.Doctor;
import mum.waa.fd.app.domain.Specialization;
import mum.waa.fd.app.repository.DoctorRepository;
import mum.waa.fd.app.service.DoctorService;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public void saveDoctor(Doctor doctor) {
		doctorRepository.save(doctor);
	}

	@Override
	public Map<Integer, String> findDoctorBySpecialization(Specialization spec) {
		List<Doctor> doctors = doctorRepository.findDoctorBySpecialization(spec);

		if (doctors.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Integer, String> doctorMap = new HashMap<>();
		for (Doctor doctor : doctors) {
			doctorMap.put(doctor.getDoctorId(), doctor.getFullName());
		}

		return doctorMap;
	}
}
