package mum.waa.fd.app.util;

import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 
 * @author Toan Quach
 *
 */
public class FamilyDoctorUtil {

	private FamilyDoctorUtil() {
		// prevent instantiate
	}

	public static String getEmail() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
}
