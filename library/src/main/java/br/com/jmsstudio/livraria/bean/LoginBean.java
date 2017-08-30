package br.com.jmsstudio.livraria.bean;

import br.com.jmsstudio.livraria.dao.UsuarioDao;
import br.com.jmsstudio.livraria.modelo.Usuario;
import br.com.jmsstudio.utils.jsf.MessageHelper;
import br.com.jmsstudio.utils.jsf.ScopeMap;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;

@Named
@RequestScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

    @Inject
	private UsuarioDao usuarioDao;

    @Inject
    @ScopeMap(ScopeMap.Scope.SESSION)
	private Map<String, Object> sessionMap;

    @Inject
    private MessageHelper messageHelper;

	private Usuario usuario = new Usuario();

	public Usuario getUsuario() {
		return usuario;
	}
	
	public String efetuaLogin() {
		System.out.println("fazendo login do usuario " + this.usuario.getEmail());
		
		FacesContext context = FacesContext.getCurrentInstance();
		boolean existe = usuarioDao.existe(this.usuario);
		if (existe) {
            sessionMap.put("usuarioLogado", this.usuario);
			return "livro?faces-redirect=true";
		}
		
		messageHelper.addMessage(null, new FacesMessage("Usuário não encontrado"));
		
		return "login?faces-redirect=true";
	}
	
	public String deslogar() {
		sessionMap.remove("usuarioLogado");
		return "login?faces-redirect=true";
	}
}
