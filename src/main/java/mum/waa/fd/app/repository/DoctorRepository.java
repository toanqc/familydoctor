package mum.waa.fd.app.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.waa.fd.app.domain.Doctor;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Integer> {

	//@Query("SELECT d FROM doctor d")
	//List<Doctor> findAllDoctors();
	
}
