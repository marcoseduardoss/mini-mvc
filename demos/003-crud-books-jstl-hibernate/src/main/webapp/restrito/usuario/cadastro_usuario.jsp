<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>

            <c:choose>
                <c:when test="${not empty usuario.id}" >
                    <%-- Se existe id é alteração. Quando o id for nulo é cadastro. 
                    Pois, o id só é gerado depois qu eo usuário é incluído no banco --%>
                    Alteração de Usuário
                </c:when>
                <c:otherwise>
                    <%-- Se não existe, é um cadastro Quando o id não for nulo é alteração.--%>
                    Cadastro de Usuário
                </c:otherwise>
            </c:choose>        
        </title>
    </head>
    <body>
        <hr />
<center>
        <c:choose>
            <c:when test="${not empty usuario.id}" >
                <!-- Se existe id é alteração-->
                Tela de Alteração de Usuário
            </c:when>
            <c:otherwise>
                <!-- Se não existe, é um cadastro-->
                Tela de Cadastro de Usuário
            </c:otherwise>
        </c:choose>  		
</center>
<hr />
<a href="<%=request.getContextPath()%>/restrito/controllerServlet?controle=UsuarioAction&operacao=exibirPaginaPrincipal">Página Principal</a>
<hr />
    <form action="<%=request.getContextPath()%>/restrito/controllerServlet" 
          method="post" 
          accept-charset="utf-8" >				
            <input type="hidden" name="controle"  value="UsuarioAction"/>								
	    <input type="hidden" name="id" value="${usuario.id}" />
             
            <c:if test="${not empty usuario.id}" >
                <%-- se "existe id" (é alteraçao), então exibe o código 
                     disabled (bloqueado para edição) --%>
                Código: ${usuario.id}<br />
            </c:if> 

			

            Nome: <input type="text" name="nome" value="${usuario.nome}"/><br/>

            Login <input type="text" name="login" value="${usuario.login}"/><br/>

            Senha: <input type="text" name="senha" value="${usuario.senha}"/><br/>

            Telefone: <input type="text" name="telefone" value="${usuario.telefone}"/><br/>

            Email: <input type="text" name="email" value="${usuario.email}"/><br/>

            <hr />
            
            <c:choose><%-- exemplo de condiconal if e Else--%>
                
                <%-- se o id não for vazio, é alteração--%>
                <c:when test="${not empty usuario.id}" >
                    <!-- botão alterar -->
                    <input type="hidden" name="operacao" value="alterar" title="alterar dados" />
                    <input type="submit" value="Alterar" />
                </c:when>
                
                <%-- se o id for vazio, é inclusão--%>
                <c:otherwise>
                    <!-- botão cadastrar -->
                    <input type="hidden" name="operacao" value="cadastrar" title="slavar n obanco de dados"/>			      
                    <input type="submit" value="Cadastrar" />
                </c:otherwise>
            </c:choose>
            
             <!-- botão limpar -->
            <input type="reset" value="Desfazer" title="Desfazer alterações realizadas" />
            
            <!-- link/botão cancelar -->
            <a href="<%=request.getContextPath()%>/restrito/controllerServlet?controle=UsuarioAction&operacao=listar">
                <input type="button" value="Cancelar e voltar" >
            </a>
            
    </form>
    </body>
</html>