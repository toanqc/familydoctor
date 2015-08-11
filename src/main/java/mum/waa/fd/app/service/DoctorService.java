package mum.waa.fd.app.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import mum.waa.fd.app.domain.Appointment;
import mum.waa.fd.app.domain.Doctor;
import mum.waa.fd.app.domain.Specialization;

public interface DoctorService {

	public void saveDoctor(Doctor doctor);
	
	List<Doctor> getAll();

	/**
	 * 
	 * @param specialization
	 * @return
	 */
	Map<Integer, String> findDoctorBySpecialization(Specialization specialization);

	/**
	 * 
	 * @param name
	 * @return
	 */
	Doctor findDoctorByEmail(String name);

	/**
	 * 
	 * @param appointmentList
	 * @return
	 */
	Map<Date, List<Appointment>> getUpcomingAppointment(List<Appointment> appointmentList);

	/**
	 * 
	 * @param appointmentList
	 * @return
	 */
	Map<Date, List<Appointment>> getOverdueAppointment(List<Appointment> appointmentList);
}
