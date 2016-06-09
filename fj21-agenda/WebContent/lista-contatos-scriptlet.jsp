<%@page import="br.com.caelum.modulo.ContatoDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ page
		import="java.util.*, br.com.caelum.modulo.*, br.com.caelum.servlet.*, java.util.Date, java.text.SimpleDateFormat"%>
	
	<table>
		<%
			ContatoDAO dao = new ContatoDAO();
		%>
		<%
			ArrayList<Contato> contatos = dao.getLista();
		%>
		<%
			for (Contato contato : contatos) {
		%>
		<tr >
			 <td ><%=contato.getNome()%></td>
			 <td ><%=contato.getEmail() %></td>
			<td><%=contato.getEndereco() %></td>
			<td><%=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(contato.getDataNascimento().getTime())%></td>
			
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>