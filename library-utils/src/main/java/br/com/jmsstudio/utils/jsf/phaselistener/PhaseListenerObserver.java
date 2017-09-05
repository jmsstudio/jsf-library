package br.com.jmsstudio.utils.jsf.phaselistener;

import br.com.jmsstudio.utils.jsf.phaselistener.annotation.After;
import br.com.jmsstudio.utils.jsf.phaselistener.annotation.Before;

import javax.enterprise.inject.Vetoed;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.CDI;
import javax.enterprise.util.AnnotationLiteral;
import javax.faces.event.PhaseEvent;
import java.lang.annotation.Annotation;

@Vetoed //indica que não poderá ser injetada / utilizada diretamente por consumidores
public class PhaseListenerObserver {

    private BeanManager observer = CDI.current().getBeanManager();
    private Annotation stage;

    public PhaseListenerObserver after() {
        this.stage = new AnnotationLiteral<After>() {};
        return this;
    }

    public PhaseListenerObserver before() {
        this.stage = new AnnotationLiteral<Before>() {};
        return this;
    }

    public void fire(PhaseEvent phaseEvent) {
        this.observer.fireEvent(phaseEvent, this.stage, new PhaseLiteral(phaseEvent.getPhaseId()));
    }

}
