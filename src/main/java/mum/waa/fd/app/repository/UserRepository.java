package mum.waa.fd.app.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mum.waa.fd.app.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	/**
	 * Find an user with user's email
	 * 
	 * @param email
	 *            to be found (aka username)
	 * @return {@link User}
	 */
	@Query("SELECT u FROM User u WHERE u.email = :email")
	User findUserByEmail(@Param(value = "email") String email);
}
