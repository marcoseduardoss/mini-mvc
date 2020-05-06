package br.me.agenda.modelo.persistencia;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public enum HibernateUtil {

    INSTANCE;

    private final EntityManagerFactory entityManagerFactory;

    HibernateUtil() {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("eesdevops");
        } catch (Exception e) {
            throw new RuntimeException("Unable to configure Hibernate connection: " + e.getMessage());
        }
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}
