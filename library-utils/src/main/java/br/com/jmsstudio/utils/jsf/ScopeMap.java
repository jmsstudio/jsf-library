package br.com.jmsstudio.utils.jsf;

import javax.inject.Qualifier;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Qualificador responsável por definir o escopo de um objeto gerenciado pelo CDI na aplicação.
 */
@Qualifier
@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ScopeMap {

    enum Scope {
        APPLICATION,
        REQUEST,
        SESSION
    }

    Scope value();
}
