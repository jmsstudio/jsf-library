package br.com.jmsstudio.livraria.dao;

import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;

public class DAOFactory {

    @Inject
    private EntityManager entityManager;

    public <T> DAO<T> factory(InjectionPoint injectionPoint) {
        ParameterizedType parameterizedType = (ParameterizedType) injectionPoint.getType();

        Class<T> classe = (Class<T>) parameterizedType.getActualTypeArguments()[0];

        return new DAO<T>(classe, entityManager);
    }
}
