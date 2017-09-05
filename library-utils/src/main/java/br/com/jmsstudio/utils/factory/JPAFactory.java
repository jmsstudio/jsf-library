package br.com.jmsstudio.utils.factory;

import br.com.jmsstudio.utils.config.Configuration;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Properties;

public class JPAFactory {

    @Inject
    @Configuration
    private Properties configProperties;

    private EntityManagerFactory emf;

    @Produces
    @RequestScoped
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void close(@Disposes EntityManager em) {
        em.close();
    }

    @PostConstruct
    public void init() {
        this.emf = Persistence.createEntityManagerFactory(configProperties.getProperty("libutils.persistenceUnit"));
    }
}
