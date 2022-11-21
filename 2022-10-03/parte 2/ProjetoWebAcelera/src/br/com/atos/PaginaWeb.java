package br.com.atos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWord
 */
@WebServlet("/PaginaWeb")
public class PaginaWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PaginaWeb() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter saida = response.getWriter();// Cria objeto que utiliza o response para enviar varias Strings (Grosso Modo)
		saida.println("<!DOCTYPE html>");
		saida.println("<html>");
		
		saida.print("<head>");
		saida.println("<meta charset=\"ISO-8859-1\">");
		saida.println("<title>Dados Do Professor</title>");
		saida.println("</head>");
		saida.println("<body>");
		saida.println("<h2>Dados do professor</h2>");
		saida.println("<h1>Nome: </h1>");
		saida.println("<p1>Danilo</p1>");
		
		saida.println("<h1>Email: </h1>");
		saida.println("<p>danilo.oliveira@gmail.com</p>");
		
		saida.println("<h1>Idade: </h2>");
		saida.println("<p>26</p>");
		
		saida.println("<h2>Como se exerga daqui a 5 anos?</h2>");
		saida.println("<p>Senior</p>");
		
	
		saida.println("</body>");
		saida.println("</html>");
		
		//(saida).append(request.getContextPath());
	}

}
