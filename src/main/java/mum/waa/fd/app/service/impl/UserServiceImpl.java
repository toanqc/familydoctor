package mum.waa.fd.app.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.waa.fd.app.domain.User;
import mum.waa.fd.app.repository.UserRepository;
import mum.waa.fd.app.service.UserService;

/**
 * 
 * @author Toan Quach
 *
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User login(String email, String password) {
		return userRepository.findUserByEmailAndPassword(email, password);
	}
}
