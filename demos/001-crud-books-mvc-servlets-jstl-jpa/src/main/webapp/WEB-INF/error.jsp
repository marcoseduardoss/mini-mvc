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
			---------------------------------------------------------------------------------------------------------------------------------------------<br />
			Livraria <br />
			---------------------------------------------------------------------------------------------------------------------------------------------
		</DIV>
		<br /> <br /> <br /> <br />
		<b style="COLOR: RED">Oops... aconteceu um probleminha.</b><br /> <br />
		<table>
			<tr>
				<td colspan="2" align="center">Maiores informações no LOG da
					aplicação.</td>
			</tr>

		</table>
	</center>
	
	<div align="center">
		<fieldset style="width:50%;">
			<legend>Detalhes:</legend>
			<center>
				<c:out value="${msgexception}" />
			</center>
		</fieldset>
	</div>
	
</body>
</html>