package br.me.agenda.controle.acoes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.me.agenda.modelo.dominio.Usuario;
import br.me.agenda.services.UserService;
import br.me.mvc.controle.acoes.Action;

/**
 * Classe de acesso a l�gica de neg�cio
 *
 * @author marcos.eduardo
 *
 */
@SuppressWarnings("serial")
public class LoginAction extends Action {

	private UserService userService = new UserService();
	
    public String entrar(HttpServletRequest request, HttpServletResponse response) {
        try {

            String login = request.getParameter("login");
			
            String password = request.getParameter("senha");
			
			Usuario user = userService.logar(login, password);
            
			HttpSession session = request.getSession(true);
            
			session.setAttribute("usuario", user);

            return "restrito/pagina_principal.jsp";

        } catch (Exception e) {
            
        	String msgStr = "Usuario nao autorizado. Login ou Senha invalidos.";
            
        	request.setAttribute("msg", msgStr);
            
        	return "index.jsp";
        }
    }

    public String sair(HttpServletRequest request, HttpServletResponse response) {
        
        request.getSession().invalidate();
        
        return "../index.jsp";
    }
}