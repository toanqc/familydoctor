package mum.waa.fd.app.util;

import java.util.ArrayList;
import java.util.Calendar;
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
 * <p>FamilyDoctorUtil class.</p>
 *
 * @author Toan Quach
 * @version $Id: $Id
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
	 * This function is to create the {@link java.util.HashMap} of {@link mum.waa.fd.app.domain.Appointment}
	 * based on {@link java.util.List} with key is the appointment date
	 *
	 * @param appointmentList a {@link java.util.List} object.
	 * @param isPast a boolean.
	 * @return a {@link java.util.Map} object.
	 */
	public static Map<Date, List<Appointment>> mapAppointmentFromList(List<Appointment> appointmentList,
			boolean isPast) {

		if (appointmentList.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Date, List<Appointment>> appointmentMap = new HashMap<>();

		Date now = getCurrentDate();

		for (Appointment appointment : appointmentList) {
			List<Appointment> appointments = null;
			if (appointmentMap.containsKey(appointment.getDate())) {
				appointments = appointmentMap.get(appointment.getDate());
			} else {
				appointments = new ArrayList<>();
			}

			if (!AppointmentStatus.CANCELED.equals(appointment.getStatus())
					&& (now.after(appointment.getDate()) == isPast)) {
				appointments.add(appointment);
				appointmentMap.put(appointment.getDate(), appointments);
			}
		}

		return appointmentMap;
	}

	/**
	 * Get current date without time
	 *
	 * @return a {@link java.util.Date} object.
	 */
	public static Date getCurrentDate() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
}
