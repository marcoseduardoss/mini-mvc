<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%--
    Document   : index
    Created on : Mai 9, 2012, 3:59:32 PM
    Author     : marcos eduardo
--%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>

        <center>
            <DIV style="COLOR: BLUE" align="CENTER">
                <HR /><br />
                CrudBooks<br /><br />
                <HR />
            </DIV>
            <br />
            <br /> <br />Entrar no Sistema<br />
            <br />

            <form action="<%=request.getContextPath()%>/public/controllerServlet?controle=LoginAction&operacao=entrar" method="post"
                  accept-charset="utf-8">                    
                <table>
                    <tr>
                        <td align="right">Usuário:</td>
                        <td><input type="text" name="login" /></td>
                    </tr>
                    <tr>
                        <td align="right">Senha:</td>
                        <td><input type="password" name="senha" /></td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td>
                        	<input type="submit" value="logar" />
                        	<a href="<%=request.getContextPath()%>/public/controllerServlet?controle=UsuarioAction&operacao=prepararCadastrarse" 
				               title="Cadastrar-se">
				                Cadastre-se
				            </a>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center" style="COLOR: RED">
                            <c:out value="${msg}" />
                        </td>
                    </tr>

                </table>

            </form>
            
               <BR />          
               <BR />
               <BR />
               <BR />
               <HR />
               Marcos Eduardo da Silva Santos - EESDevOps2/UECE
        </center>
    </body>
</html>