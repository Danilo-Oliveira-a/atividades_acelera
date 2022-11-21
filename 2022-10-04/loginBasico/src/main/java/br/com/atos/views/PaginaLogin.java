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
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class PaginaLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaginaLogin() {
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
		UserLogin login = new UserLogin();
		login.setUserName(userName);
		login.setPassword(pass);
		System.out.println("Nome: "+userName);
		System.out.println("Senha: "+pass);
		LoginDAO dao = new LoginDAO();
		boolean loginSucesso =dao.login(login);
		if(loginSucesso) {	
			//response.sendRedirect(request.getContextPath() + "/LoginSucesso.jsp");
			request.setAttribute("nome", userName);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/LoginSucesso.jsp");
			dispatcher.forward(request, response);
		}
		else
			response.sendRedirect(request.getContextPath() + "/LoginErro.jsp");
	}

}
