package mum.waa.fd.app.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import mum.waa.fd.app.domain.Appointment;
import mum.waa.fd.app.domain.AppointmentStatus;

/**
 * 
 * @author Toan Quach
 *
 */
public class FamilyDoctorUtil {

	private FamilyDoctorUtil() {
		// prevent instantiate
	}

	/**
	 * Get the logged in email address
	 * 
	 * @return the email address
	 */
	public static String getEmail() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}

	/**
	 * Hash the password with bcrypt mechanism
	 * 
	 * @param rawPassword
	 *            the original password
	 * @return encoded password
	 */
	public static String hashPassword(String rawPassword) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode(rawPassword);
	}

	/**
	 * This function is to create the {@link HashMap} of {@link Appointment}
	 * based on {@link List} with key is the appointment date
	 * 
	 * @param appointmentList
	 * @return
	 */
	public static Map<Date, List<Appointment>> mapAppointmentFromList(List<Appointment> appointmentList) {

		if (appointmentList.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Date, List<Appointment>> appointmentMap = new HashMap<>();

		for (Appointment appointment : appointmentList) {
			List<Appointment> appointments = null;
			if (appointmentMap.containsKey(appointment.getDate())) {
				appointments = appointmentMap.get(appointment.getDate());
			} else {
				appointments = new ArrayList<>();
			}

			if (!AppointmentStatus.CANCELED.equals(appointment.getStatus())) {
				appointments.add(appointment);
				appointmentMap.put(appointment.getDate(), appointments);
			}
		}

		return appointmentMap;
	}
}
