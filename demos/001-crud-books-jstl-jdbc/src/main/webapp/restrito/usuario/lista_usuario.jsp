<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>lista de usuários</title>

</head>
<body>
	<div align="center" style="color:red">${msgSucesso}</div>
	<br />

	<br />

	
	
		<div align="center">
		
			<a href="<%=request.getContextPath()%>/restrito/controllerServlet?controle=UsuarioAction&operacao=exibirPaginaPrincipal">Página Principal</a> | 
			<a href="<%=request.getContextPath()%>/restrito/controllerServlet?controle=UsuarioAction&operacao=prepararCadastro">Cadastrar Um Novo Usuario</a><br />

			<table border="1">
				<tr>
					<td colspan="8" align="center">lista de usuários</td>
				</tr>
				<tr>
					<td>CÓDIGO</td>
					<td>NOME</td>
					<td>LOGIN</td>
					<td>SENHA</td>
					<td>TELEFONE</td>
					<td>EMAIL</td>
					<td>ALTERAR</td>
					<td>REMOVER</td>
				</tr>
				<c:forEach var="u" begin="0" items="${usuarios}">
					<tr>
						<td>${u.id}</td>
						<td>${u.nome}</td>
						<td>${u.login}</td>
						<td>${u.senha}</td>
						<td>${u.telefone}</td>
						<td>${u.email}</td>
						<td><a
							href="<%=request.getContextPath()%>/restrito/controllerServlet?controle=UsuarioAction&operacao=prepararAlteracao&id=${u.id}">Alterar</a></td>
						<td><a
							href="<%=request.getContextPath()%>/restrito/controllerServlet?controle=UsuarioAction&operacao=remover&id=${u.id}">Remover</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
</body>
</html>