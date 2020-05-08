package br.me.crudbooks.model.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import br.me.crudbooks.model.domain.entity.Usuario;
import br.me.crudbooks.model.domain.exception.LibrarySystemException;

public class UserRepository {

	private final EntityManagerFactory entityManagerFactory = HibernateUtil.INSTANCE.getEntityManagerFactory();

	public void save(Usuario user) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		if (entityManager == null)
			throw new LibrarySystemException("Repository Exception: EntityManager is null!");

		try {
			
			entityManager.getTransaction().begin();
			
			entityManager.persist(user);
			entityManager.flush();
			
			entityManager.getTransaction().commit();

		} catch (Exception e) {
			
			if (entityManager.isOpen())
				entityManager.getTransaction().rollback();
			
			throw new LibrarySystemException("Repository Exception: " + e.getMessage(), e);
			
		} finally {

			if (entityManager.isOpen()) 
				entityManager.close();
			
		}

	}

	public void update(Usuario user) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		if (entityManager == null)
			throw new LibrarySystemException("Repository Exception: EntityManager is null!");

		try {
			
			entityManager.getTransaction().begin();
			
			entityManager.merge(user);
			entityManager.flush();
			
			entityManager.getTransaction().commit();

		} catch (Exception e) {
			
			if (entityManager.isOpen())
				entityManager.getTransaction().rollback();
			
			throw new LibrarySystemException("Repository Exception: " + e.getMessage(), e);
			
		} finally {

			if (entityManager.isOpen()) 
				entityManager.close();
			
		}

	}

	public void remove(Usuario user) {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		if (entityManager == null)
			throw new LibrarySystemException("Repository Exception: EntityManager is null!");

		try {
			
			entityManager.getTransaction().begin();
			
			entityManager.remove(entityManager.getReference(Usuario.class, user.getId()));
			
			entityManager.getTransaction().commit();

		} catch (Exception e) {
			
			if (entityManager.isOpen())
				entityManager.getTransaction().rollback();
			
			throw new LibrarySystemException("Repository Exception: " + e.getMessage(), e);
			
		} finally {

			if (entityManager.isOpen()) 
				entityManager.close();
			
		}
		
	}

	public List<Usuario> findAll() {

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		List<Usuario> list = null;

		if (entityManager == null)
			throw new LibrarySystemException("Repository Exception: EntityManager is null!");

		try {
			
			list = entityManager.createQuery("select u from Usuario u", Usuario.class).getResultList();

		} catch (Exception e) {
			
			throw new LibrarySystemException("Repository Exception: " + e.getMessage(), e);
			
		} finally {

			if (entityManager.isOpen()) 
				entityManager.close();
			
		}
		
		return list;
	}

	public Usuario findById(Long id) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Usuario user = null;

		if (entityManager == null)
			throw new LibrarySystemException("Repository Exception: EntityManager is null!");

		try {
			
			String query = "select u from Usuario u where u.id = :id";
			
			TypedQuery<Usuario> createQuery = entityManager.createQuery(query, Usuario.class);
			
			createQuery.setParameter("id", id);
			
			user = createQuery.getSingleResult();

		} catch (Exception e) {
			
			throw new LibrarySystemException("Repository Exception: " + e.getMessage(), e);
			
		} finally {

			if (entityManager.isOpen()) 
				entityManager.close();
			
		}
		
		return user;

	}

	public Usuario authenticate(String username, String password) {


		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Usuario user = null;

		if (entityManager == null)
			throw new LibrarySystemException("Repository Exception: EntityManager is null!");

		try {
			
			String query = "select u from Usuario u where u.login = :username and u.senha = :password";
			
			TypedQuery<Usuario> createQuery = entityManager.createQuery(query, Usuario.class);
			
			createQuery.setParameter("username", username);
			
			createQuery.setParameter("password", password);
			
			user = createQuery.getSingleResult();

		} catch (Exception e) {
			
			throw new LibrarySystemException("Repository Exception: " + e.getMessage(), e);
			
		} finally {

			if (entityManager.isOpen()) 
				entityManager.close();
			
		}
		
		return user;
	}
}