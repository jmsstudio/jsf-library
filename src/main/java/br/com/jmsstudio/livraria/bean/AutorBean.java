package br.com.jmsstudio.livraria.bean;

import br.com.jmsstudio.livraria.dao.DAO;
import br.com.jmsstudio.livraria.modelo.Autor;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class AutorBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private DAO<Autor> autorDAO;

	private Autor autor = new Autor();
	
	private Integer autorId;

	public Integer getAutorId() {
		return autorId;
	}

	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}
	
	public void carregarAutorPelaId() {
		this.autor = autorDAO.buscaPorId(autorId);
	}

	public String gravar() {
		System.out.println("Gravando autor " + this.autor.getNome());

		if(this.autor.getId() == null) {
			autorDAO.adiciona(this.autor);
		} else {
			autorDAO.atualiza(this.autor);
		}

		this.autor = new Autor();

		return "livro?faces-redirect=true";
	}
	
	public void remover(Autor autor) {
		System.out.println("Removendo autor " + autor.getNome());
		autorDAO.remove(autor);
	}
	
	public List<Autor> getAutores() {
		return autorDAO.listaTodos();
	}
	
	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
}
