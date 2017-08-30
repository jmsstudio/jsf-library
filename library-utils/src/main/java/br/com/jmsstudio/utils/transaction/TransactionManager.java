package br.com.jmsstudio.utils.transaction;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.io.Serializable;

@Interceptor
@Transactional
public class TransactionManager implements Serializable {

    @Inject
    private EntityManager entityManager;

    @AroundInvoke
    public Object doWithTransaction(InvocationContext context) {
        EntityTransaction transaction = entityManager.getTransaction();
        System.out.println("Abrindo transação");
        transaction.begin();

        Object result = null;

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
