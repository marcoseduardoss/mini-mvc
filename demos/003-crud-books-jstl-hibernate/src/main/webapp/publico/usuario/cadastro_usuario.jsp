<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>

                    Cadastro de Usuário
        </title>
    </head>
    <body>
        <hr />
<center>
                Tela de Cadastro de Usuário
</center>
<hr />
<a href="<%=request.getContextPath()%>/index.jsp">Voltar</a>
<hr />
    <form action="<%=request.getContextPath()%>/controllerServletPublico" 
          method="post" 
          accept-charset="utf-8" >				
            
            <input type="hidden" name="controle"  value="UsuarioAction"/>								
	   
            Nome: <input type="text" name="nome" value="${usuario.nome}"/><br/>

            Login <input type="text" name="login" value="${usuario.login}"/><br/>

            Senha: <input type="text" name="senha" value="${usuario.senha}"/><br/>

            Telefone: <input type="text" name="telefone" value="${usuario.telefone}"/><br/>

            Email: <input type="text" name="email" value="${usuario.email}"/><br/>

            <hr />
            
            <!-- botão cadastrar -->
            <input type="hidden" name="operacao" value="cadastrarse" title="lavar no banco de dados"/>			      
            <input type="submit" value="Cadastrar" />

             <!-- botão limpar -->
            <input type="reset" value="Desfazer" title="Desfazer alterações realizadas" />
            
            <!-- link/botão cancelar -->
            <a href="<%=request.getContextPath()%>/restrito/controllerServlet?controle=UsuarioAction&operacao=listar">
                <input type="button" value="Cancelar e voltar" >
            </a>
            
    </form>
    </body>
</html>