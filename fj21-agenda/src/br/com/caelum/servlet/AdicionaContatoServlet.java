package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.modulo.Contato;
import br.com.caelum.modulo.ContatoDAO;

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// busca o writer
		PrintWriter out = response.getWriter();
		out.println("<html>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<head>");
        out.println("<title>Cadastro de Contato</title>");
        out.println("</head>");
		
		//buscando os parametros no request
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String dataTexto = request.getParameter("dataNascimento");
		Calendar dataNascimento = null;
		
		//fazendo a conversão da data
		try {
			Date data = new SimpleDateFormat("dd/mm/yyyy").parse(dataTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(data);
		} catch (ParseException e) {
			out.println("<h1>Erro de converão da data</h1>");
			return; // para a execução do método
		}
		
		//Montando Novo Contato
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(dataNascimento);
		
		//Salva contato BD
		ContatoDAO dao = new ContatoDAO();
		System.out.println("Agora vou add...");
		dao.adiciona(contato);
		
		//imprime nome do contato que foi add
		
        out.println("<body>");
        out.println("Contato ("+contato.getNome()+") -> Adicionado com Sucesso");
        out.println("</body>");
        out.println("</html>");

	}
	
	public AdicionaContatoServlet() {
		// TODO Auto-generated constructor stub
	}

}
