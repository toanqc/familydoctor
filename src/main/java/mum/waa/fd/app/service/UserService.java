package mum.waa.fd.app.service;

import mum.waa.fd.app.domain.User;

/**
 * 
 * @author Toan Quach
 *
 */
public interface UserService {

	/**
	 * Login to the system with user email and password
	 * 
	 * @param email
	 *            to be login, it also an username
	 * @param password
	 *            pass to be login
	 * @return the login user
	 */
	User login(String email, String password);
}
