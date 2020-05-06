<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>lista de books</title>

</head>
<body>
	<div align="center" style="color:red">${msgSucesso}</div>
	<br />

	<br />

	
	
		<div align="center">
		
			<a href="<%=request.getContextPath()%>/restrito/controllerServlet?controle=BookAction&operacao=exibirPaginaPrincipal">Página Principal</a> | 
			<a href="<%=request.getContextPath()%>/restrito/controllerServlet?controle=BookAction&operacao=prepararCadastro">Cadastrar Um Novo Book</a><br />

			<table border="1">
				<tr>
					<td colspan="8" align="center">lista de books</td>
				</tr>
				<tr>
					<td>ID</td>
					<td>TITLE</td>
					<td>AUTHOR</td>
					<td>SUMMARY</td>
					<td>ANO</td>
					<td>ALTERAR</td>
					<td>REMOVER</td>
				</tr>
				<c:forEach var="u" begin="0" items="${books}">
					<tr>
						<td>${u.id}</td>
						<td>${u.title}</td>
						<td>${u.author}</td>
						<td>${u.summary}</td>
						<td>${u.ano}</td>
						<td><a
							href="<%=request.getContextPath()%>/restrito/controllerServlet?controle=BookAction&operacao=prepararAlteracao&id=${u.id}">Alterar</a></td>
						<td><a
							href="<%=request.getContextPath()%>/restrito/controllerServlet?controle=BookAction&operacao=remover&id=${u.id}">Remover</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
</body>
</html>