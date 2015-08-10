package mum.waa.fd.app.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mum.waa.fd.app.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	/**
	 * Find an user with user's email and password
	 * 
	 * @param email
	 *            to be found (aka username)
	 * @param password
	 *            password to be found
	 * @return {@link User}
	 */
	@Query("SELECT u FROM User u WHERE u.email = :email AND u.password = :password")
	User findUserByEmailAndPassword(@Param(value = "email") String email, @Param(value = "password") String password);
}
