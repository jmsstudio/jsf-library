package br.com.jmsstudio.utils.transaction;

import javax.inject.Inject;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class DefaultTransactional implements ITransactional {

    @Inject
    protected EntityManager entityManager;

    @Override
    public Object doWithTransaction(InvocationContext context) {
        EntityTransaction transaction = entityManager.getTransaction();
        System.out.println("Abrindo transação");
        transaction.begin();

        Object result;

        try {
            result = context.proceed();
            transaction.commit();
            System.out.println("Commitando transação");
        } catch (Exception e) {
            transaction.rollback();
            System.out.println("Erro - rollback na transação");

            throw new RuntimeException(e);
        }

        return result;

    }
}
