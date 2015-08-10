package mum.waa.fd.app.domain;

/**
 * This class is indicate the user type of the web application.<br/>
 * Currently there 3 types of user:<br/>
 * 1. Patient --> this is the user which is a customer of the hospital<br/>
 * 2. Doctor --> this is the type for the staff that is working in the hospital
 * <br/>
 * 3. Admin --> this is the super user, the admin is able to create / register
 * the doctor account.
 * 
 * @author Toan Quach
 *
 */
public enum AuthorityRole {

	PATIENT, DOCTOR, ADMIN;
}
