package br.me.crudbooks.model.repository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.me.crudbooks.model.domain.exception.LibrarySystemException;

public enum HibernateUtil {

    INSTANCE;

    private final EntityManagerFactory entityManagerFactory;

    HibernateUtil() {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("eesdevops");
        } catch (Exception e) {
            throw new LibrarySystemException("Unable to configure Hibernate connection: " + e.getMessage());
        }
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}
