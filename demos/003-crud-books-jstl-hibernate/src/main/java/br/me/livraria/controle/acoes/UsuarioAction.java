package br.me.livraria.controle.acoes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.me.livraria.exception.LibraryException;
import br.me.livraria.model.repository.UsuarioDAO;
import br.me.livraria.modelo.dominio.Usuario;
import br.me.mvc.controle.acoes.Action;
//import br.me.agenda.modelo.persistencia.lista.UsuarioDao;

/**
 * Classe de acesso a logica de negocio
 * 
 * @author marcos.eduardo
 *
 */
@SuppressWarnings("serial")
public class UsuarioAction extends Action {

	private UsuarioDAO usuarioDAO = new UsuarioDAO();

	public String sair(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			request.getSession().invalidate();

			return "../index.jsp";
			
		} catch (Exception e) {
			request.setAttribute("msgexception", e.getMessage());
			throw new LibraryException(e);
		}
	}

	public String exibirPaginaPrincipal(HttpServletRequest request, HttpServletResponse response) {
		return "pagina_principal.jsp";
	}

	public String prepararAlteracao(HttpServletRequest request, HttpServletResponse response) {

		try {

			String idStr = request.getParameter("id");

			Long idLong = new Long((idStr == null ? "-1" : idStr));

			Usuario u = (Usuario) usuarioDAO.obterPorId(idLong);

			request.setAttribute("usuario", u);

			return "usuario/cadastro_usuario.jsp";

		} catch (Exception e) {
			request.setAttribute("msgexception", e.getMessage());
			throw new LibraryException(e);
		}
	}

	public String prepararCadastro(HttpServletRequest request, HttpServletResponse response) {

		request.setAttribute("usuario", new Usuario());

		return "usuario/cadastro_usuario.jsp";
	}

	public String cadastrar(HttpServletRequest request, HttpServletResponse response) {
		try {

			Usuario usuario = new Usuario();

			usuario.setNome(request.getParameter("nome"));
			usuario.setLogin(request.getParameter("login"));
			usuario.setSenha(request.getParameter("senha"));
			usuario.setTelefone(request.getParameter("telefone"));
			usuario.setEmail(request.getParameter("email"));

			usuarioDAO.salvar(usuario);

			request.setAttribute("usuarios", usuarioDAO.getTodos());

			request.setAttribute("msgSucesso", "Usuario cadastrado com sucesso");

			return "usuario/lista_usuario.jsp";

		} catch (Exception e) {
			request.setAttribute("msgexception", e.getMessage());
			throw new LibraryException(e);
		}
	}

	public String cadastrarse(HttpServletRequest request, HttpServletResponse response) {

		try {
			Usuario usuario = new Usuario();

			usuario.setNome(request.getParameter("nome"));
			usuario.setLogin(request.getParameter("login"));
			usuario.setSenha(request.getParameter("senha"));
			usuario.setTelefone(request.getParameter("telefone"));
			usuario.setEmail(request.getParameter("email"));

			usuarioDAO.salvar(usuario);

			request.setAttribute("usuarios", usuarioDAO.getTodos());

			request.setAttribute("msgSucesso", "Usuario cadastrado com sucesso");

			return new LoginAction().entrar(request, response);

		} catch (Exception e) {
			request.setAttribute("msgexception", e.getMessage());
			throw new LibraryException(e);
		}
	}

	public String prepararCadastrarse(HttpServletRequest request, HttpServletResponse response) {

		request.setAttribute("usuario", new Usuario());

		return "publico/usuario/cadastro_usuario.jsp";
	}

	public String alterar(HttpServletRequest request, HttpServletResponse response) {

		try {

			String idStr = request.getParameter("id");

			Usuario usuario = new Usuario();

			usuario.setId(new Long(idStr == null ? "-1" : idStr));
			usuario.setNome(request.getParameter("nome"));
			usuario.setLogin(request.getParameter("login"));
			usuario.setSenha(request.getParameter("senha"));
			usuario.setTelefone(request.getParameter("telefone"));
			usuario.setEmail(request.getParameter("email"));

			usuarioDAO.atualizar(usuario);

			request.setAttribute("msgSucesso", "Usuario alterado com sucesso");

			request.setAttribute("usuarios", usuarioDAO.getTodos());

		} catch (Exception e) {

			request.setAttribute("msgexception", e.getMessage());
			throw new LibraryException(e);

		}
		return "usuario/lista_usuario.jsp";
	}

	public String listar(HttpServletRequest request, HttpServletResponse response) {

		try {

			request.setAttribute("usuarios", usuarioDAO.getTodos());

		} catch (Exception e) {

			request.setAttribute("msgexception", e.getMessage());
			throw new LibraryException(e);

		}

		return "usuario/lista_usuario.jsp";
	}

	public String listarSemLogar(HttpServletRequest request, HttpServletResponse response) {

		try {

			request.setAttribute("usuarios", usuarioDAO.getTodos());

		} catch (Exception e) {
			request.setAttribute("msgexception", e.getMessage());
			throw new LibraryException(e);
		}
		return "publico/lista_usuario_publico.jsp";
	}

	public String remover(HttpServletRequest request, HttpServletResponse response) {
		try {

			String idStr = request.getParameter("id");

			Usuario usuario = new Usuario();

			usuario.setId(new Long(idStr == null ? "-1" : idStr));

			usuarioDAO.remover(usuario);

			request.setAttribute("usuarios", usuarioDAO.getTodos());

			request.setAttribute("msgSucesso", "Usuario removido com sucesso");

		} catch (Exception e) {
			request.setAttribute("msgexception", e.getMessage());
			throw new LibraryException(e);
		}
		return "usuario/lista_usuario.jsp";
	}
}