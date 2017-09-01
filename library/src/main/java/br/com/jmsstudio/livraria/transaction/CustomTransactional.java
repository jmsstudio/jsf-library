package br.com.jmsstudio.livraria.transaction;

import br.com.jmsstudio.utils.transaction.ITransactional;

import javax.annotation.Priority;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Alternative
@Priority(Interceptor.Priority.APPLICATION)
public class CustomTransactional implements ITransactional {

    @Inject
    private EntityManager entityManager;

    @Override
    public Object doWithTransaction(InvocationContext invocationContext) {
        EntityTransaction transaction = entityManager.getTransaction();
        System.out.println("CUSTOM::: Abrindo transação");
        transaction.begin();

        Object result;

        try {
            result = invocationContext.proceed();
            transaction.commit();
            System.out.println("CUSTOM::: Commitando transação");
        } catch (Exception e) {
            transaction.rollback();
            System.out.println("CUSTOM::: Erro - rollback na transação");

            throw new RuntimeException(e);
        }

        return result;

    }
}
