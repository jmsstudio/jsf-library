package br.com.jmsstudio.utils.transaction;

import javax.interceptor.InvocationContext;
import java.io.Serializable;

public interface ITransactional extends Serializable {

    Object doWithTransaction(InvocationContext context);

}
