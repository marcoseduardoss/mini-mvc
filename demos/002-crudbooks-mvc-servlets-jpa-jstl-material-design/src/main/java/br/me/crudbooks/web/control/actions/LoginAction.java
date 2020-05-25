package br.me.crudbooks.web.control.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.me.crudbooks.model.domain.entity.Usuario;
import br.me.crudbooks.model.domain.services.AuthenticateService;
import br.me.mvc.controle.acoes.Action;

/**
 * Classe de acesso a logica de negocio
 *
 * @author marcos.eduardo
 *
 */
@SuppressWarnings("serial")
public class LoginAction extends Action {

	private AuthenticateService userService = new AuthenticateService();
	
    public String entrar(HttpServletRequest request, HttpServletResponse response) {
        try {

            String login = request.getParameter("login");
			
            String password = request.getParameter("senha");
			
			Usuario user = userService.execute(login, password);
            
			HttpSession session = request.getSession(true);
            
			session.setAttribute("usuario", user);

            return "restrict/home.jsp";

        } catch (Exception e) {
            
        	String msgStr = "Acesso negado. Usuario ou Senha invalido(s).";
            
        	request.setAttribute("msg", msgStr);
            //public/login/index.jsp
        	return "login/index.jsp";
        }
    }

    public String sair(HttpServletRequest request, HttpServletResponse response) {
        
        request.getSession().invalidate();
        
        return "/login/index.jsp";
    }
}