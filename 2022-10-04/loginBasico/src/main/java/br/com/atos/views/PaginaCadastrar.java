package br.com.atos.views;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.atos.dao.LoginDAO;
import br.com.atos.model.UserLogin;

/**
 * Servlet implementation class Cadastrar
 */
@WebServlet("/cadastrar")
public class PaginaCadastrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaginaCadastrar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName= request.getParameter("userName");
		String pass= request.getParameter("password");
		String passConfirm= request.getParameter("passwordConfirm");
		String msgErro = null;
		if(pass.equals(passConfirm)) {
			System.out.println("Senhas iguais");
			
			UserLogin login = new UserLogin();
			login.setUserName(userName);
			login.setPassword(pass);
			
			LoginDAO dao = new LoginDAO();
			
			if(dao.cadastrar(login))	{
				response.sendRedirect(request.getContextPath() + "/Login.jsp");
				
			}	
				
			else {
				msgErro = "Não foi possível cadastrar este usuario";
				//response.sendRedirect(request.getContextPath() + "/CadastroErro.jsp");
				request.setAttribute("msgErro", msgErro);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/CadastroErro.jsp");
				dispatcher.forward(request, response);
			}
		}
		else {
			System.out.println("Senhas  diferentes");
			msgErro = "Senhas não coincidem";
			//response.sendRedirect(request.getContextPath() + "/CadastroErro.jsp");
			request.setAttribute("msgErro", msgErro);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/CadastroErro.jsp");
			dispatcher.forward(request, response);
			//response.sendRedirect(request.getContextPath() + "/CadastroErro.jsp");
		}
		
		
	}

}
