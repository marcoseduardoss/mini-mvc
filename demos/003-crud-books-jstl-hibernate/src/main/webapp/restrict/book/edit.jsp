<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>

            <c:choose>
                <c:when test="${not empty book.id}" >
                    Alteração de Livro
                </c:when>
                <c:otherwise>
                    Cadastro de Livro
                </c:otherwise>
            </c:choose>        
        </title>
    </head>
    <body>
        <hr />
<center>
        <c:choose>
            <c:when test="${not empty book.id}" >
                Tela de Alteração de Livro
            </c:when>
            <c:otherwise>
                Tela de Cadastro de Livro
            </c:otherwise>
        </c:choose>  		
	</center>
	<hr />
	<a href="<%=request.getContextPath()%>/restrict/controllerServlet?controle=BookAction&operacao=exibirPaginaPrincipal">Página Principal</a>
	<hr />
	
	    <form action="<%=request.getContextPath()%>/restrict/controllerServlet" method="post" accept-charset="utf-8" >				
            <input type="hidden" name="controle"  value="BookAction"/>	
            							
	    <input type="hidden" name="id" value="${book.id}" />
             
            <c:if test="${not empty book.id}" >
                Código: ${book.id}<br />
            </c:if> 

            Título: <input type="text" name=title value="${book.title}"/><br/>

            Autor <input type="text" name="author" value="${book.author}"/><br/>

            Sumário: <input type="text" name="summary" value="${book.summary}"/><br/>

            Ano: <input type="text" name="ano" value="${book.ano}"/><br/>

            <hr />
            
            <c:choose><%-- exemplo de condiconal if e Else--%>
                
                <%-- se o id não for vazio, é alteração--%>
                <c:when test="${not empty book.id}" >
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
            <a href="<%=request.getContextPath()%>/restrict/controllerServlet?controle=BookAction&operacao=listar">
                <input type="button" value="Cancelar e voltar" >
            </a>
            
    </form>
    </body>
</html>