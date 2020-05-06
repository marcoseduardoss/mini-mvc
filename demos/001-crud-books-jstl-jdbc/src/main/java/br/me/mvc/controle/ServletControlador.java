package br.me.mvc.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.me.mvc.controle.acoes.Action;
import br.me.mvc.excecoes.ControllerMvcException;
import br.me.mvc.util.JavaReflectionUtil;


@WebServlet(name = "ServletControlador", urlPatterns = {"/controllerServletPublico", "/restrito/controllerServlet"}) 
@WebInitParam(name="package-actions-mvc", value="br.me.agenda.controle.acoes")
//@WebServlet(value = "/controllerServletPublico")
//@WebServlet("/restrito/controllerServlet")
@SuppressWarnings("serial")
public class ServletControlador extends HttpServlet {

	private void controlarAcessoAoModelo(HttpServletRequest req,
			HttpServletResponse res) 
                throws ServletException, IOException {
            
            //alteral o encondig da requisicao para utf-8
            req.setCharacterEncoding("UTF-8");            
                
            try {
                
                String className = req.getParameter("controle");
                String realPath = req.getServletContext().getRealPath("/WEB-INF/classes");
                
                Action comando = Action.newInstance(className, realPath);

                //aplica a logica de negocio
                String paginaRedirecionada = comando.executa(req, res);
                
                String url = "./"+paginaRedirecionada;
                
                //altera o encoding da repsosta para utf-8
                res.setCharacterEncoding("UTF-8");
                res.setContentType("text/html;charset=UTF-8");
                
//                if(paginaRedirecionada.equals("pagina_principal.jsp")) 
//                    throw new Exception("teste");
                
                //redireciona 
                if(comando.isRedirect())
                    res.sendRedirect(res.encodeRedirectURL(url));
                else
                    req.getRequestDispatcher(url).forward(req, res);
                
                
            } catch (Exception e) {
                //imprime no console o erro ocorrido
                String msg = "Erro na classe ServletContrador. ";
                msg += "Detalhes do erro em inglês: "+e.getMessage();        
                System.out.println(msg);            
                throw new ControllerMvcException(msg, e);
            } 
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) 
                throws ServletException, IOException {
            
		controlarAcessoAoModelo(request, response);
	
    }

	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) 
                throws ServletException, IOException {
            
		controlarAcessoAoModelo(request, response);
	
    }

}