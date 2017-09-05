package br.com.jmsstudio.utils.jsf.phaselistener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class GenericPhaseListener implements PhaseListener {

    private PhaseListenerObserver observer = new PhaseListenerObserver();

    @Override
    public void afterPhase(PhaseEvent phaseEvent) {
        observer.after().fire(phaseEvent);
    }

    @Override
    public void beforePhase(PhaseEvent phaseEvent) {
        observer.before().fire(phaseEvent);
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }

}
