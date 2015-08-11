package mum.waa.fd.app.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.commons.lang.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.waa.fd.app.domain.Appointment;
import mum.waa.fd.app.domain.Doctor;
import mum.waa.fd.app.domain.Patient;
import mum.waa.fd.app.domain.Specialization;
import mum.waa.fd.app.repository.AppointmentRepository;
import mum.waa.fd.app.repository.DoctorRepository;
import mum.waa.fd.app.repository.PatientRepository;
import mum.waa.fd.app.service.AppointmentService;
import mum.waa.fd.app.util.FamilyDoctorUtil;

/**
 * 
 * @author Toan Quach
 *
 */

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public Map<String, String> getAllSpecialization() {

		Map<String, String> specializations = new HashMap<>();
		for (Specialization specialization : Specialization.values()) {
			specializations.put(specialization.toString(), WordUtils.capitalizeFully(specialization.toString()));
		}

		return specializations;
	}

	@Override
	public void saveAppointment(Appointment appointment) {
		Patient patient = patientRepository.findPatientByEmail(FamilyDoctorUtil.getEmail());
		Doctor doctor = doctorRepository.findOne(appointment.getDoctor().getDoctorId());

		appointment.setPatient(patient);
		appointment.setDoctor(doctor);
		appointmentRepository.save(appointment);
	}
}
