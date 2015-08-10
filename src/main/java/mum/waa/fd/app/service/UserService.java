package mum.waa.fd.app.service;

import mum.waa.fd.app.domain.User;

/**
 * 
 * @author Toan Quach
 *
 */
public interface UserService {

	/**
	 * Login to the system with user email
	 * 
	 * @param email
	 *            to be login, it also an username
	 * @return the login user
	 */
	User login(String email);
}
