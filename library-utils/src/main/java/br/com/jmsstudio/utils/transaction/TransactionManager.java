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

    @Inject
    private ITransactional transactional;

    @AroundInvoke
    public Object doWithTransaction(InvocationContext context) {
        return transactional.doWithTransaction(context);
    }
}
