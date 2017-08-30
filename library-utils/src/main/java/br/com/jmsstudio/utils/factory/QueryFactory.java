package br.com.jmsstudio.utils.factory;

import br.com.jmsstudio.utils.dao.Query;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.lang.reflect.ParameterizedType;

@SuppressWarnings("unchecked")
public class QueryFactory {

    @Inject
    private EntityManager entityManager;

    @Produces
    @Query()
    public <X> TypedQuery<X> factory(InjectionPoint injectionPoint) {
        ParameterizedType type = (ParameterizedType) injectionPoint.getType();

        Class<X> classe = (Class<X>) type.getActualTypeArguments()[0];

        String jpqlQuery = injectionPoint.getAnnotated().getAnnotation(Query.class).value();

        return entityManager.createQuery(jpqlQuery, classe);
    }
}
