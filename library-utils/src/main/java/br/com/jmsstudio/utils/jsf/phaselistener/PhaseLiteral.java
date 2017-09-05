package br.com.jmsstudio.utils.jsf.phaselistener;

import br.com.jmsstudio.utils.jsf.phaselistener.annotation.Phase;

import javax.enterprise.util.AnnotationLiteral;
import javax.faces.event.PhaseId;

public class PhaseLiteral extends AnnotationLiteral<Phase> implements Phase {

    private Phases phases;

    public PhaseLiteral(PhaseId phaseId) {
        this.phases = Phase.Phases.valueOf(phaseId.getName());
    }

    @Override
    public Phases value() {
        return this.phases;
    }
}
