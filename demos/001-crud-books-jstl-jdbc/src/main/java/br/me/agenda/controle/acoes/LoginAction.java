package br.me.agenda.controle.acoes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.me.agenda.modelo.dominio.Usuario;
import br.me.mvc.controle.acoes.Action;

/**
 * Classe de acesso a l�gica de neg�cio
 *
 * @author marcos.eduardo
 *
 */
public class LoginAction extends Action {

	
	
    /**
     *
     */
    private static final long serialVersionUID = -2713541453116369196L;

    public String entrar(HttpServletRequest request, HttpServletResponse response) {
        try {

            Usuario usuario = new Usuario();
            usuario.setLogin(request.getParameter("login"));
            usuario.setSenha(request.getParameter("senha"));
            usuario = usuario.logar();

            HttpSession session = request.getSession(true);
            session.setAttribute("usuario", usuario);

            return "restrito/pagina_principal.jsp";

        } catch (Exception e) {
            String msgStr = "Usuario nao autorizado. Login ou Senha invalidos.";
            request.setAttribute("msg", msgStr);
            return "index.jsp";
        }
    }

    public String sair(HttpServletRequest request, HttpServletResponse response) {
        //expira sessao do usuario
        request.getSession().invalidate();
        return "../index.jsp";
    }
}