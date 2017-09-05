package br.com.jmsstudio.livraria.util;

import br.com.jmsstudio.livraria.modelo.Usuario;
import br.com.jmsstudio.utils.jsf.phaselistener.annotation.After;
import br.com.jmsstudio.utils.jsf.phaselistener.annotation.Phase;

import javax.enterprise.event.Observes;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.inject.Inject;

public class Autorizador {

	@Inject
    private FacesContext context;

    @Inject
    private NavigationHandler handler;

	public void autorizar(@Observes @After @Phase(Phase.Phases.RESTORE_VIEW) PhaseEvent event) {
		String nomePagina = context.getViewRoot().getViewId();
	
		System.out.println(nomePagina);
		
		if("/login.xhtml".equals(nomePagina)) {
			return;
		}
		
		Usuario usuarioLogado = (Usuario) context.getExternalContext().getSessionMap().get("usuarioLogado");
		
		if(usuarioLogado == null) {
            //redirecionamento para login.xhtml

            handler.handleNavigation(context, null, "/login?faces-redirect=true");
            context.renderResponse();
        }
	} 
}
