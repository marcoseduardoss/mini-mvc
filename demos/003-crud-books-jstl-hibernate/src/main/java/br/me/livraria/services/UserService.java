package br.me.livraria.services;

import br.me.livraria.exception.LibraryException;
import br.me.livraria.model.repository.UsuarioDAO;
import br.me.livraria.modelo.dominio.Usuario;

public class UserService {
	
    private UsuarioDAO usuarioDao = new UsuarioDAO();

	public Usuario logar(String login, String senha) {
        
    	Usuario u = usuarioDao.getUsuario(login, senha);
        
        if (u != null)
            return u;
        else 
            throw new LibraryException("Usuario nao autorizado");

    }

}
