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
		
			<a href="<%=request.getContextPath()%>/index.jsp">Voltar</a> 

                        <center>
                            <br />
                            Lista de usuários com acesso irrestrito <br />
                            (Obs.: Não precisa estar logado para visualizar esta página)
                            <br /><br />
                        </center> 
			<table border="1">
				<tr>
					<td colspan="8" align="center">lista de usuários</td>
				</tr>
				<tr>
					<td>CÓDIGO</td>
					<td>NOME</td>
					<td>LOGIN</td>
					<td>TELEFONE</td>
					<td>EMAIL</td>
				</tr>
				<c:forEach var="u" begin="0" items="${usuarios}">
					<tr>
						<td>${u.id}</td>
						<td>${u.nome}</td>
						<td>${u.login}</td>
						<td>${u.telefone}</td>
						<td>${u.email}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
</body>
</html>