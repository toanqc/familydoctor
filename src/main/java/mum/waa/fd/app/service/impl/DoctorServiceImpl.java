package mum.waa.fd.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.waa.fd.app.domain.Doctor;
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
	
//	@Override
//	public List<Doctor> findAll(){
//		return doctorRepository.findAllDoctors();
//	}
	
//	@Override
//	public List<Doctor> findDoctorBySpecialization(String specialization){
//		return doctorRepository.findDoctorBySpecialization(specialization);
//	}
}
