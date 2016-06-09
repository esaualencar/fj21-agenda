package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contador")
public class Contador extends HttpServlet {

	private int contador=0;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// busca o writer
		PrintWriter out = response.getWriter();
		out.println("<html>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<head>");
        out.println("<title>Cadastro de Contato</title>");
        out.println("</head>"); 
        out.println("<body>");
        out.println("Contador => "+contador);
        out.println("</body>");
        out.println("</html>");

		contador++;
	}
	public Contador() {
		// TODO Auto-generated constructor stub
	}

}
