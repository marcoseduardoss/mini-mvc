package br.me.agenda.services;

import br.me.agenda.exception.LibraryException;
import br.me.agenda.model.repository.UsuarioDAO;
import br.me.agenda.modelo.dominio.Usuario;

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
