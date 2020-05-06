<%--
    Document   : index
    Created on : Maio 9, 2012, 3:59:32 PM
    Author     : marcos eduardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página Principal - Home</title>
    </head>
    <body>
    Bem vindo <b>${usuario.nome}! </b><br /><br />

	Menu:<br />
	<a href="<%=request.getContextPath()%>/restrito/controllerServlet?controle=UsuarioAction&operacao=prepararCadastro">Cadastrar Usuario</a>
	|
	<a href="<%=request.getContextPath()%>/restrito/controllerServlet?controle=UsuarioAction&operacao=listar">Listar Usuario</a> 
	||
	<a href="<%=request.getContextPath()%>/restrito/controllerServlet?controle=BookAction&operacao=prepararCadastro">Cadastrar Book</a>
	|
	<a href="<%=request.getContextPath()%>/restrito/controllerServlet?controle=BookAction&operacao=listar">Listar Book</a>
    ||
    <a href="<%=request.getContextPath()%>/restrito/controllerServlet?controle=LoginAction&operacao=sair" title="Clique aqui para Sair"> Sair</a>
		    
    </body>
</html>