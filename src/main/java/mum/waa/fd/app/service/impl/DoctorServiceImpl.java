package mum.waa.fd.app.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.waa.fd.app.domain.Appointment;
import mum.waa.fd.app.domain.Doctor;
import mum.waa.fd.app.domain.Specialization;
import mum.waa.fd.app.repository.DoctorRepository;
import mum.waa.fd.app.service.DoctorService;
import mum.waa.fd.app.util.FamilyDoctorUtil;

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
	public List<Doctor> getAll() {
		List<Doctor> doctors = new ArrayList<Doctor>();

		for (Doctor d : doctorRepository.findAll()) {
			doctors.add(d);
		}

		return doctors;
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

	@Override
	public Doctor findDoctorByEmail(String email) {
		return doctorRepository.findDoctorByEmail(email);
	}

	@Override
	public Map<Date, List<Appointment>> getUpcomingAppointment(List<Appointment> appointmentList) {
		return FamilyDoctorUtil.mapAppointmentFromList(appointmentList, false);
	}

	@Override
	public Map<Date, List<Appointment>> getOverdueAppointment(List<Appointment> appointmentList) {
		return FamilyDoctorUtil.mapAppointmentFromList(appointmentList, true);
	}
}
