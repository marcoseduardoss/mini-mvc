package br.me.agenda.controle.acoes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.me.agenda.modelo.dominio.Usuario;
import br.me.agenda.modelo.persistencia.jdbc.UsuarioDAO;
import br.me.mvc.controle.acoes.Action;
//import br.me.agenda.modelo.persistencia.lista.UsuarioDao;

/**
 * Classe de acesso a logica de negocio
 * @author marcos.eduardo
 *
 */
public class UsuarioAction extends Action {

    private static final long serialVersionUID = 3189580885709221082L;
	
    public String sair(HttpServletRequest request, HttpServletResponse response) {
    	
    	//expira sessao do usuario
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
       
        //Ontém o usuario no banco de dados
        Usuario u = (Usuario) UsuarioDAO.getInstance().obterPorId(idLong);
        
        //criar um atributo/variável visível no formulário da tela de alteracao
        request.setAttribute("usuario", u);
        
        //redireciona para tela de cadastro para possibilitar a alteracao do
        //usuario selecionado na tela de listagem.
        return "usuario/cadastro_usuario.jsp";
    }

    public String prepararCadastro(HttpServletRequest request, HttpServletResponse response) {
    	
    	//cria uma nova instancia para utilizá-lo na tela d ealteracao
        request.setAttribute("usuario", new Usuario());

        //redireciona para tela de cadastro para possibilitar o cadastro de
        //um novo usuario
        return "usuario/cadastro_usuario.jsp";
    }

    public String cadastrar(HttpServletRequest request, HttpServletResponse response) {
        //criando instancia de um novo usuário
        Usuario usuario = new Usuario();
        
        //inclusão dos dados preenchidos no firmulário html
        usuario.setNome(request.getParameter("nome"));
        usuario.setLogin(request.getParameter("login"));
        usuario.setSenha(request.getParameter("senha"));
        usuario.setTelefone(request.getParameter("telefone"));
        usuario.setEmail(request.getParameter("email"));
        
        //Savando dados do usuário no banco de dados(BD)
        UsuarioDAO.getInstance().salvar(usuario);
        
        //recuperando lista de objetos, no BD, para exibi-los na tela 
        //de listagem. Inclusive o usuário que acabou de ser salvo no BD.
        request.setAttribute("usuarios", UsuarioDAO.getInstance().getTodos());
        
        //incluindo mensagem de sucesso
        request.setAttribute("msgSucesso", "Usuario cadastrado com sucesso");
        
        //redirecionando para tela de listagem
        return "usuario/lista_usuario.jsp";
    }

    public String alterar(HttpServletRequest request, HttpServletResponse response) {
        //recuperando id do usuario escolhido na listagem
        String idStr = request.getParameter("id");
        
        //criando instancia de um objeto usuário
        Usuario usuario = new Usuario();
        
        //inclusão dos dados alterados no formulário html
        usuario.setId(new Long(idStr == null ? "-1" : idStr));
        usuario.setNome(request.getParameter("nome"));
        usuario.setLogin(request.getParameter("login"));
        usuario.setSenha(request.getParameter("senha"));
        usuario.setTelefone(request.getParameter("telefone"));
        usuario.setEmail(request.getParameter("email"));
        
        //atualizando os dados no Banco de Dados
        UsuarioDAO.getInstance().atualizar(usuario);
        
        //inclui uma mensagem de sucesso
        request.setAttribute("msgSucesso", "Usuario alterado com sucesso");

        //obtém todos os objetos do banco        
        request.setAttribute("usuarios", UsuarioDAO.getInstance().getTodos());
        
        //redirecionando para tela  de listagem
        return "usuario/lista_usuario.jsp";
    }

    public String listar(HttpServletRequest request, HttpServletResponse response) {
        
    	//inclui a lista de usuário em um atributo "usuarios" para poder
       
    	//exibir, na tela de listagem, todos os usuário cadastrados no BD
        request.setAttribute("usuarios", UsuarioDAO.getInstance().getTodos());
        
        //redireciona para tela de listagem
        return "usuario/lista_usuario.jsp";
    }

    public String listarSemLogar(HttpServletRequest request, HttpServletResponse response) {
        
    	//inclui a lista de usuário em um atributo "usuarios" para poder
        //exibir, na tela de listagem, todos os usuário cadastrados no BD
        request.setAttribute("usuarios", UsuarioDAO.getInstance().getTodos());
        
        //redireciona para tela de listagem publica
        return "publico/lista_usuario_publico.jsp";
    }

    public String remover(HttpServletRequest request, HttpServletResponse response) {
        //recuperar o parametro id passado no link clicado na tela de listagem
        String idStr = request.getParameter("id");
        
        //cria um objeto usuario
        Usuario usuario = new Usuario();
        
        //inclui o id do usuario no objeto
        usuario.setId(new Long(idStr == null ? "-1" : idStr));
        
        //remove o usuario selecionado do banco de dados
        UsuarioDAO.getInstance().remover(usuario);
        
        //inclui a lista de usuário em um atributo "usuarios" para poder
        //exibir, na tela de listagem, todos os usuário cadastrados no BD
        request.setAttribute("usuarios", UsuarioDAO.getInstance().getTodos());
        
        //inclui uma nendagem de usuario
        request.setAttribute("msgSucesso", "Usuario removido com sucesso");
        
        //redireciona para tela de listagem publica
        return "usuario/lista_usuario.jsp";
    }
}