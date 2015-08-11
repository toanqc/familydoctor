package mum.waa.fd.app.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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
}
