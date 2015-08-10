package mum.waa.fd.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.waa.fd.app.domain.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer> {
}
