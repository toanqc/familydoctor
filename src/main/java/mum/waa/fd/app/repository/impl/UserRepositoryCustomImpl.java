package mum.waa.fd.app.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import mum.waa.fd.app.domain.User;
import mum.waa.fd.app.repository.UserRepositoryCustom;

public class UserRepositoryCustomImpl implements UserRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public User findUserByEmailAndPassword(String email, String password) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);
		Root<User> root = query.from(User.class);
		Predicate preEmail = builder.equal(root.get("email"), email);
		Predicate prePassword = builder.equal(root.get("password"), password);
		query.where(builder.and(preEmail, prePassword));

		try {
			return entityManager.createQuery(query.select(root)).getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}
}
