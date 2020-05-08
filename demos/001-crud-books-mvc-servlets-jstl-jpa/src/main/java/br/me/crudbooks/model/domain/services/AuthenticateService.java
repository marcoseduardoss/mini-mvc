package br.me.crudbooks.model.domain.services;

import br.me.crudbooks.model.domain.entity.Usuario;
import br.me.crudbooks.model.domain.exception.LibrarySystemException;
import br.me.crudbooks.model.repository.UserRepository;

public class AuthenticateService {
	
    private UserRepository userRepository = new UserRepository();

	public Usuario execute(String username, String password) {
        
    	Usuario u = userRepository.authenticate(username, password);
        
        if (u != null)
            return u;
        else 
            throw new LibrarySystemException("Unauthorized user!");

    }

}
