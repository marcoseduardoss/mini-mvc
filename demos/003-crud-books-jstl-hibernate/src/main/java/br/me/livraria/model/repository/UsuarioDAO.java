package br.me.livraria.model.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import br.me.livraria.exception.LibraryException;
import br.me.livraria.model.repository.config.DaoI;
import br.me.livraria.model.repository.config.HibernateUtil;
import br.me.livraria.modelo.dominio.Usuario;

public class UsuarioDAO implements DaoI<Usuario> {

	private EntityManagerFactory entityManagerFactory = HibernateUtil.INSTANCE.getEntityManagerFactory();

	public void salvar(Usuario usuario) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		if (entityManager == null)
			throw new LibraryException("Repository Exception: EntityManager is null!");

		try {
			
			entityManager.getTransaction().begin();
			
			entityManager.persist(usuario);
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

	public void atualizar(Usuario usuario) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		if (entityManager == null)
			throw new LibraryException("Repository Exception: EntityManager is null!");

		try {
			
			entityManager.getTransaction().begin();
			
			entityManager.merge(usuario);
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

	public void remover(Usuario usuario) {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		if (entityManager == null)
			throw new LibraryException("Repository Exception: EntityManager is null!");

		try {
			
			entityManager.getTransaction().begin();
			
			entityManager.remove(entityManager.getReference(Usuario.class, usuario.getId()));
			
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

	public List<Usuario> getTodos() {

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		List<Usuario> retorno = null;

		if (entityManager == null)
			throw new LibraryException("Repository Exception: EntityManager is null!");

		try {
			
			retorno = entityManager.createQuery("select u from Usuario u", Usuario.class).getResultList();

		} catch (Exception e) {
			
			throw new LibraryException("Repository Exception: " + e.getMessage(), e);
			
		} finally {

			if (entityManager.isOpen()) 
				entityManager.close();
			
		}
		
		return retorno;
	}

	public Usuario obterPorId(Long id) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Usuario retorno = null;

		if (entityManager == null)
			throw new LibraryException("Repository Exception: EntityManager is null!");

		try {
			
			String query = "select u from Usuario u where u.id = :id";
			
			TypedQuery<Usuario> createQuery = entityManager.createQuery(query, Usuario.class);
			
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

	public Usuario getUsuario(String login, String senha) {


		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Usuario retorno = null;

		if (entityManager == null)
			throw new LibraryException("Repository Exception: EntityManager is null!");

		try {
			
			String query = "select u from Usuario u where u.login = :login and u.senha = :senha";
			
			TypedQuery<Usuario> createQuery = entityManager.createQuery(query, Usuario.class);
			
			createQuery.setParameter("login", login);
			
			createQuery.setParameter("senha", senha);
			
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