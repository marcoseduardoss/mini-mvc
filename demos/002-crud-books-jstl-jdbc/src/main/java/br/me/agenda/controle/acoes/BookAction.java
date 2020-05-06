package br.me.agenda.controle.acoes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.me.agenda.modelo.dominio.Book;
import br.me.agenda.modelo.persistencia.jdbc.BookDAO;
import br.me.mvc.controle.acoes.Action;
//import br.me.agenda.modelo.persistencia.lista.BookDao;

/**
 * Classe de acesso a logica de negocio
 * @author marcos.eduardo
 *
 */
public class BookAction extends Action {

    private static final long serialVersionUID = 3189580885709221082L;
	
    public String sair(HttpServletRequest request, HttpServletResponse response) {
    	
    	//expira sessao do book
    	request.getSession().invalidate();
        
        //redirecion para tela inicial
        return "../index.jsp";
    }
	
    public String exibirPaginaPrincipal(HttpServletRequest request, HttpServletResponse response) {
        return "pagina_principal.jsp";
    }
     
    public String prepararAlteracao(HttpServletRequest request, HttpServletResponse response) {
        //recuperar o parametro id passado no link clicado na tela de listagem
        String idStr = request.getParameter("id");
        
        //verifica se o id é nulo para evitar erro NullPOintException
        Long idLong = new Long((idStr == null ? "-1" : idStr));
       
        //Ontém o book no banco de dados
        Book u = (Book) BookDAO.getInstance().obterPorId(idLong);
        
        //criar um atributo/variável visível no formulário da tela de alteracao
        request.setAttribute("book", u);
        
        //redireciona para tela de cadastro para possibilitar a alteracao do
        //book selecionado na tela de listagem.
        return "book/cadastro_book.jsp";
    }

    public String prepararCadastro(HttpServletRequest request, HttpServletResponse response) {
    	
    	//cria uma nova instancia para utilizá-lo na tela d ealteracao
        request.setAttribute("book", new Book());

        //redireciona para tela de cadastro para possibilitar o cadastro de
        //um novo book
        return "book/cadastro_book.jsp";
    }

    public String cadastrar(HttpServletRequest request, HttpServletResponse response) {
        //criando instancia de um novo usuário
        Book book = new Book();
        
        //inclusão dos dados preenchidos no firmulário html
        book.setAuthor(request.getParameter("nome"));
        book.setTitle(request.getParameter("login"));
        book.setSummary(request.getParameter("senha"));
        book.setAno(Integer.parseInt(request.getParameter("telefone")));
        
        //Savando dados do usuário no banco de dados(BD)
        BookDAO.getInstance().salvar(book);
        
        //recuperando lista de objetos, no BD, para exibi-los na tela 
        //de listagem. Inclusive o usuário que acabou de ser salvo no BD.
        request.setAttribute("books", BookDAO.getInstance().getTodos());
        
        //incluindo mensagem de sucesso
        request.setAttribute("msgSucesso", "Book cadastrado com sucesso");
        
        //redirecionando para tela de listagem
        return "book/lista_book.jsp";
    }

    public String alterar(HttpServletRequest request, HttpServletResponse response) {
        //recuperando id do book escolhido na listagem
        String idStr = request.getParameter("id");
        
        //criando instancia de um objeto usuário
        Book book = new Book();
        
        //inclusão dos dados alterados no formulário html
        book.setId(new Long(idStr == null ? "-1" : idStr));
        book.setAuthor(request.getParameter("nome"));
        book.setTitle(request.getParameter("login"));
        book.setSummary(request.getParameter("senha"));
        book.setAno(Integer.parseInt(request.getParameter("telefone")));
        
        //atualizando os dados no Banco de Dados
        BookDAO.getInstance().atualizar(book);
        
        //inclui uma mensagem de sucesso
        request.setAttribute("msgSucesso", "Book alterado com sucesso");

        //obtém todos os objetos do banco        
        request.setAttribute("books", BookDAO.getInstance().getTodos());
        
        //redirecionando para tela  de listagem
        return "book/lista_book.jsp";
    }

    public String listar(HttpServletRequest request, HttpServletResponse response) {
        
    	//inclui a lista de usuário em um atributo "books" para poder
       
    	//exibir, na tela de listagem, todos os usuário cadastrados no BD
        request.setAttribute("books", BookDAO.getInstance().getTodos());
        
        //redireciona para tela de listagem
        return "book/lista_book.jsp";
    }

    public String listarSemLogar(HttpServletRequest request, HttpServletResponse response) {
        
    	//inclui a lista de usuário em um atributo "books" para poder
        //exibir, na tela de listagem, todos os usuário cadastrados no BD
        request.setAttribute("books", BookDAO.getInstance().getTodos());
        
        //redireciona para tela de listagem publica
        return "publico/lista_book_publico.jsp";
    }

    public String remover(HttpServletRequest request, HttpServletResponse response) {
        //recuperar o parametro id passado no link clicado na tela de listagem
        String idStr = request.getParameter("id");
        
        //cria um objeto book
        Book book = new Book();
        
        //inclui o id do book no objeto
        book.setId(new Long(idStr == null ? "-1" : idStr));
        
        //remove o book selecionado do banco de dados
        BookDAO.getInstance().remover(book);
        
        //inclui a lista de usuário em um atributo "books" para poder
        //exibir, na tela de listagem, todos os usuário cadastrados no BD
        request.setAttribute("books", BookDAO.getInstance().getTodos());
        
        //inclui uma nendagem de book
        request.setAttribute("msgSucesso", "Book removido com sucesso");
        
        //redireciona para tela de listagem publica
        return "book/lista_book.jsp";
    }
}