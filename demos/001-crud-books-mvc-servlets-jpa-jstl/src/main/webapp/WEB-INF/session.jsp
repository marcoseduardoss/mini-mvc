<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sessão expirada</title>
    </head>
    <body>
		
		
		<div align="center">
	    	<h1 style="color: red">Sessão expirada.</h1><br />
	    	
	    	<p> Sua <em>sessão expirou</em>. Faça <em>login</em> novamente!</p>
	    	
	    	<p>A sessão tem duração máxima de <strong> 10</strong> minutos em caso de inatividade.</p><br />
			
			Clique <a href="<%=request.getContextPath()%>/index.jsp" >aqui</a> para acessar a página de login.
		</div>
	
</body>
</html>