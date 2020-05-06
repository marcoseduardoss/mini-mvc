package br.me.agenda.controle.acoes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.me.agenda.exception.LibraryException;
import br.me.agenda.model.repository.BookDAO;
import br.me.agenda.modelo.dominio.Book;
import br.me.mvc.controle.acoes.Action;
//import br.me.agenda.modelo.persistencia.lista.BookDao;

/**
 * Classe de acesso a logica de negocio
 * 
 * @author marcos.eduardo
 *
 */
@SuppressWarnings("serial")
public class BookAction extends Action {
	
	private BookDAO bookDAO = new BookDAO();

	public String sair(HttpServletRequest request, HttpServletResponse response) {
		try {

			request.getSession().invalidate();

			return "../index.jsp";

		} catch (Exception e) {
			request.setAttribute("msgexception", isNull(e) ? "Erro com valor nulo" : e.getMessage() ) ;
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

			Book u = (Book) bookDAO.obterPorId(idLong);

			request.setAttribute("book", u);

			return "book/cadastro_book.jsp";

		} catch (Exception e) {
			request.setAttribute("msgexception", isNull(e) ? "Erro com valor nulo" : e.getMessage() ) ;
			throw new LibraryException(e);
		}
	}

	public String prepararCadastro(HttpServletRequest request, HttpServletResponse response) {

		request.setAttribute("book", new Book());

		return "book/cadastro_book.jsp";
	}

	public String cadastrar(HttpServletRequest request, HttpServletResponse response) {
		try {

			Book book = new Book();

	        book.setAuthor(request.getParameter("author"));
	        
	        book.setTitle(request.getParameter("title"));
	        
	        book.setSummary(request.getParameter("summary"));
	        
	        String ano = request.getParameter("ano");
	        book.setAno(ano != null ? Integer.parseInt(ano) : null );

			bookDAO.salvar(book);

			request.setAttribute("books", bookDAO.getTodos());

			request.setAttribute("msgSucesso", "Book cadastrado com sucesso");

			return "book/lista_book.jsp";

		} catch (Exception e) {
			request.setAttribute("msgexception", isNull(e) ? "Erro com valor nulo" : e.getMessage() ) ;
			throw new LibraryException(e);
		}
	}



	public String cadastrarse(HttpServletRequest request, HttpServletResponse response) {

		try {
			Book book = new Book();

	        book.setAuthor(request.getParameter("author"));
	        
	        book.setTitle(request.getParameter("title"));
	        
	        book.setSummary(request.getParameter("summary"));
	        
	        String ano = request.getParameter("ano");
	        book.setAno(ano != null ? Integer.parseInt(ano) : null );


			bookDAO.salvar(book);

			request.setAttribute("books", bookDAO.getTodos());

			request.setAttribute("msgSucesso", "Book cadastrado com sucesso");

			return new LoginAction().entrar(request, response);

		} catch (Exception e) {
			request.setAttribute("msgexception", isNull(e) ? "Erro com valor nulo" : e.getMessage() ) ;
			throw new LibraryException(e);
		}
	}

	public String prepararCadastrarse(HttpServletRequest request, HttpServletResponse response) {

		request.setAttribute("book", new Book());

		return "publico/book/cadastro_book.jsp";
	}

	public String alterar(HttpServletRequest request, HttpServletResponse response) {

		try {

			String idStr = request.getParameter("id");

			Book book = new Book();

	        book.setId(new Long(idStr == null ? "-1" : idStr));
	        
	        book.setAuthor(request.getParameter("author"));
	        
	        book.setTitle(request.getParameter("title"));
	        
	        book.setSummary(request.getParameter("summary"));

	        String ano = request.getParameter("ano");
	        book.setAno(ano != null ? Integer.parseInt(ano) : null );

	        bookDAO.atualizar(book);

			request.setAttribute("msgSucesso", "Book alterado com sucesso");

			request.setAttribute("books", bookDAO.getTodos());

		} catch (Exception e) {

			request.setAttribute("msgexception", isNull(e) ? "Erro com valor nulo" : e.getMessage() ) ;
			throw new LibraryException(e);

		}
		return "book/lista_book.jsp";
	}

	public String listar(HttpServletRequest request, HttpServletResponse response) {

		try {

			request.setAttribute("books", bookDAO.getTodos());

		} catch (Exception e) {

			request.setAttribute("msgexception", isNull(e) ? "Erro com valor nulo" : e.getMessage() ) ;
			throw new LibraryException(e);

		}

		return "book/lista_book.jsp";
	}

	public String listarSemLogar(HttpServletRequest request, HttpServletResponse response) {

		try {

			request.setAttribute("books", bookDAO.getTodos());

		} catch (Exception e) {
			request.setAttribute("msgexception", isNull(e) ? "Erro com valor nulo" : e.getMessage() ) ;
			throw new LibraryException(e);
		}
		return "publico/lista_book_publico.jsp";
	}

	public String remover(HttpServletRequest request, HttpServletResponse response) {
		try {

			String idStr = request.getParameter("id");

			Book book = new Book();

			book.setId(new Long(idStr == null ? "-1" : idStr));

			bookDAO.remover(book);

			request.setAttribute("books", bookDAO.getTodos());

			request.setAttribute("msgSucesso", "Book removido com sucesso");

		} catch (Exception e) {
			request.setAttribute("msgexception", isNull(e) ? "Erro com valor nulo" : e.getMessage() ) ;
			throw new LibraryException(e);
		}
		return "book/lista_book.jsp";
	}
	
	public boolean isNull(Exception e) {
		return e==null || e.getMessage ()== null || e.getMessage ().trim().contentEquals("null");
	}
}