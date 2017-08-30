package br.com.jmsstudio.livraria.dao;

import br.com.jmsstudio.livraria.modelo.Usuario;
import br.com.jmsstudio.utils.dao.Query;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class UsuarioDao {

	@Inject
	private EntityManager em;

    @Inject
    @Query("select u from Usuario u where u.email = :pEmail and u.senha = :pSenha")
	private TypedQuery<Usuario> query;

	public boolean existe(Usuario usuario) {
		
		query.setParameter("pEmail", usuario.getEmail());
		query.setParameter("pSenha", usuario.getSenha());
		try {
			query.getSingleResult();
		} catch (NoResultException ex) {
			return false;
		}
		
		return true;
	}

}
