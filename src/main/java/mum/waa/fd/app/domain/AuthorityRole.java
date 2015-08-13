package mum.waa.fd.app.domain;

/**
 * This class is indicate the user type of the web application.
 * Currently there 3 types of user:
 * <ul>
 * <li>1. Patient : this is the user which is a customer of the hospital</li>
 * <li>2. Doctor : this is the type for the staff that is working in the hospital</li>
 * <li>3. Admin : this is the super user, the admin is able to create / register
 * the doctor account.</li>
 * </ul>
 *
 * @author Toan Quach
 * @version $Id: $Id
 */
public enum AuthorityRole {

	ROLE_PATIENT, ROLE_DOCTOR, ROLE_ADMIN;
}
