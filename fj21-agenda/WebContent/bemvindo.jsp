<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Primeiro JSP</title>
</head>
<body>
	<%-- Comentário do Arquivo --%>
	<%
		String mensagem = "Bem vindo ao sistema de agendas do FJ-21";
	%>
	<%
		out.println(mensagem);
	%>
	<br />
	<%
		String desenvolvido = "Desenvolvido por Esaú Alencar Tavares";
	%>
	<%=desenvolvido%>
	<br />
	<% System.out.println("Tudo executado com sucesso !"); %>
	
</body>
</html>