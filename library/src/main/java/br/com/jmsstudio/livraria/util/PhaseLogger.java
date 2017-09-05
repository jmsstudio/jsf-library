package br.com.jmsstudio.livraria.util;

import br.com.jmsstudio.utils.jsf.phaselistener.annotation.Before;
import br.com.jmsstudio.utils.jsf.phaselistener.annotation.Phase;

import javax.enterprise.event.Observes;
import javax.faces.event.PhaseEvent;

public class PhaseLogger {

    public void log(@Observes @Before @Phase(Phase.Phases.RESTORE_VIEW) PhaseEvent phaseEvent) {
        System.out.println("FASE: ==> " + phaseEvent.getPhaseId());
    }
}
