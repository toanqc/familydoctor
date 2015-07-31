package mum.waa.fd.app.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.waa.fd.app.domain.PersonTest;
import mum.waa.fd.app.service.PatientAccountService;

@Controller
public class TestController {

	@Autowired
	private PatientAccountService patientAccountService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showPerson(@ModelAttribute("person") PersonTest person) {
		return "test";
	}

	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public String insertPerson(@Valid @ModelAttribute("person") PersonTest person, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "test";
		}
		// patientAccountService.insertPatientAccount(person);
		run(person);
		return "test";
	}

	public void run(PersonTest person) {
		EntityManagerFactory factory = null;
		EntityManager entityManager = null;
		try {
			factory = Persistence.createEntityManagerFactory("FamilyDoctor");
			entityManager = factory.createEntityManager();
			persistPerson(entityManager, person);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
			if (factory != null) {
				factory.close();
			}
		}
	}

	private void persistPerson(EntityManager entityManager, PersonTest person) {
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(person);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}
	}
}
