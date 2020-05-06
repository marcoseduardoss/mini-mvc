package br.me.agenda.model.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import br.me.agenda.exception.LibraryException;
import br.me.agenda.model.repository.config.DaoI;
import br.me.agenda.model.repository.config.HibernateUtil;
import br.me.agenda.modelo.dominio.Book;

public class BookDAO implements DaoI<Book> {


	private EntityManagerFactory entityManagerFactory = HibernateUtil.INSTANCE.getEntityManagerFactory();

	public void salvar(Book book) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		if (entityManager == null)
			throw new LibraryException("Repository Exception: EntityManager is null!");

		try {
			
			entityManager.getTransaction().begin();
			
			entityManager.persist(book);
			entityManager.flush();
			
			entityManager.getTransaction().commit();

		} catch (Exception e) {
			
			if (entityManager.isOpen())
				entityManager.getTransaction().rollback();
			
			throw new LibraryException("Repository Exception: " + e.getMessage(), e);
			
		} finally {

			if (entityManager.isOpen()) 
				entityManager.close();
			
		}

	}

	public void atualizar(Book book) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		if (entityManager == null)
			throw new LibraryException("Repository Exception: EntityManager is null!");

		try {
			
			entityManager.getTransaction().begin();
			
			entityManager.merge(book);
			entityManager.flush();
			
			entityManager.getTransaction().commit();

		} catch (Exception e) {
			
			if (entityManager.isOpen())
				entityManager.getTransaction().rollback();
			
			throw new LibraryException("Repository Exception: " + e.getMessage(), e);
			
		} finally {

			if (entityManager.isOpen()) 
				entityManager.close();
			
		}

	}

	public void remover(Book book) {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		if (entityManager == null)
			throw new LibraryException("Repository Exception: EntityManager is null!");

		try {
			
			entityManager.getTransaction().begin();
			
			entityManager.remove(entityManager.getReference(Book.class, book.getId()));
			
			entityManager.getTransaction().commit();

		} catch (Exception e) {
			
			if (entityManager.isOpen())
				entityManager.getTransaction().rollback();
			
			throw new LibraryException("Repository Exception: " + e.getMessage(), e);
			
		} finally {

			if (entityManager.isOpen()) 
				entityManager.close();
			
		}
		
	}

	public List<Book> getTodos() {

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		List<Book> retorno = null;

		if (entityManager == null)
			throw new LibraryException("Repository Exception: EntityManager is null!");

		try {
			
			retorno = entityManager.createQuery("select u from Book u", Book.class).getResultList();

		} catch (Exception e) {
			
			throw new LibraryException("Repository Exception: " + e.getMessage(), e);
			
		} finally {

			if (entityManager.isOpen()) 
				entityManager.close();
			
		}
		
		return retorno;
	}

	public Book obterPorId(Long id) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Book retorno = null;

		if (entityManager == null)
			throw new LibraryException("Repository Exception: EntityManager is null!");

		try {
			
			String query = "select u from Book u where u.id = :id";
			
			TypedQuery<Book> createQuery = entityManager.createQuery(query, Book.class);
			
			createQuery.setParameter("id", id);
			
			retorno = createQuery.getSingleResult();

		} catch (Exception e) {
			
			throw new LibraryException("Repository Exception: " + e.getMessage(), e);
			
		} finally {

			if (entityManager.isOpen()) 
				entityManager.close();
			
		}
		
		return retorno;

	}

}