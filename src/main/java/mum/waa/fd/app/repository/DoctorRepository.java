package mum.waa.fd.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mum.waa.fd.app.domain.Doctor;
import mum.waa.fd.app.domain.Specialization;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Integer> {

	@Query("SELECT d FROM Doctor d WHERE d.specialization = :spec")
	List<Doctor> findDoctorBySpecialization(@Param(value = "spec") Specialization spec);

	@Query("SELECT d FROM Doctor d INNER JOIN d.user u WHERE u.email = :email")
	Doctor findDoctorByEmail(@Param(value = "email") String email);
}
