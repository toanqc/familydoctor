package mum.waa.fd.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mum.waa.fd.app.domain.Doctor;
import mum.waa.fd.app.domain.Specialization;

@Repository
/**
 * <p>DoctorRepository interface.</p>
 *
 * @author kamanashisroy
 * @version $Id: $Id
 */
public interface DoctorRepository extends CrudRepository<Doctor, Integer> {

	/**
	 * <p>findDoctorBySpecialization.</p>
	 *
	 * @param spec a {@link mum.waa.fd.app.domain.Specialization} object.
	 * @return a {@link java.util.List} object.
	 */
	@Query("SELECT d FROM Doctor d WHERE d.specialization = :spec")
	List<Doctor> findDoctorBySpecialization(@Param(value = "spec") Specialization spec);

	/**
	 * <p>findDoctorByEmail.</p>
	 *
	 * @param email a {@link java.lang.String} object.
	 * @return a {@link mum.waa.fd.app.domain.Doctor} object.
	 */
	@Query("SELECT d FROM Doctor d INNER JOIN d.user u WHERE u.email = :email")
	Doctor findDoctorByEmail(@Param(value = "email") String email);

	/**
	 * <p>findDoctorById.</p>
	 *
	 * @param doctorId a {@link java.lang.Integer} object.
	 * @return a {@link mum.waa.fd.app.domain.Doctor} object.
	 */
	@Query("SELECT d FROM Doctor d INNER JOIN d.user u WHERE d.id = :doctorId")
	Doctor findDoctorById(@Param(value = "doctorId") Integer doctorId);
}
