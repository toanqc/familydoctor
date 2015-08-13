package mum.waa.fd.app.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.waa.fd.app.domain.Appointment;
import mum.waa.fd.app.domain.Authority;
import mum.waa.fd.app.domain.AuthorityRole;
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
		Authority authority = new Authority();
		authority.setAuthorityRole(AuthorityRole.ROLE_DOCTOR);
		doctor.getUser().getAuthorities().add(authority);

		String encodedPassword = FamilyDoctorUtil.hashPassword(doctor.getUser().getPassword());
		doctor.getUser().setPassword(encodedPassword);

		doctorRepository.save(doctor);
	}

	@Override
	public void updateDoctor(Doctor doctor) {
		Doctor doctorUpdate = doctorRepository.findDoctorById(doctor.getDoctorId());

		doctorUpdate.setFirstName(doctor.getFirstName());
		doctorUpdate.setLastName(doctor.getLastName());
		doctorUpdate.setDateOfBirth(doctor.getDateOfBirth());
		doctorUpdate.setGender(doctor.getGender());
		doctorUpdate.setLicenseNumber(doctor.getLicenseNumber());
		doctorUpdate.setSpecialization(doctor.getSpecialization());

		doctorUpdate.getAddress().setCity(doctor.getAddress().getCity());
		doctorUpdate.getAddress().setState(doctor.getAddress().getState());
		doctorUpdate.getAddress().setStreet(doctor.getAddress().getStreet());
		doctorUpdate.getAddress().setZipcode(doctor.getAddress().getZipcode());

		doctorUpdate.getUser().setEmail(doctor.getUser().getEmail());

		if (!doctor.getUser().getPassword().isEmpty()) {
			String encodedPassword = FamilyDoctorUtil.hashPassword(doctor.getUser().getPassword());
			doctorUpdate.getUser().setPassword(encodedPassword);
		}

		doctorRepository.save(doctorUpdate);
	}

	@Override
	public void deleteDoctor(Integer doctorId) {
		if (doctorId != null && doctorId != 0) {
			Doctor doctor = doctorRepository.findOne(doctorId);
			doctorRepository.delete(doctor);
		}
	}

	@Override
	public List<Doctor> getAll() {
		List<Doctor> doctors = new ArrayList<Doctor>();

		for (Doctor d : doctorRepository.findAll()) {
			doctors.add(d);
		}

		return doctors;
	}

	public Doctor findDoctorById(int id) {
		Doctor doctor = doctorRepository.findDoctorById(id);
		return doctor;
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
