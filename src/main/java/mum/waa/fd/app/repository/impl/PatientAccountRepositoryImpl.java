package mum.waa.fd.app.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import mum.waa.fd.app.domain.PersonTest;
import mum.waa.fd.app.repository.PatientAccountRepository;

@Repository
@Transactional
public class PatientAccountRepositoryImpl implements PatientAccountRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertPatientAccount(PersonTest patient) {
		entityManager.persist(patient);
	}

	@Override
	public List<PersonTest> getList() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<PersonTest> cq = builder.createQuery(PersonTest.class);
		Root<PersonTest> root = cq.from(PersonTest.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}
}
