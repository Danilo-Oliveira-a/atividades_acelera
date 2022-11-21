package br.com.atos.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.atos.dao.LoginDAO;
import br.com.atos.model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/logar")
public class PaginaLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PaginaLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome= request.getParameter("nome");
		String senha= request.getParameter("senha");
		User login = new User();
		login.setNome(nome);
		login.setSenha(senha);
	
		LoginDAO dao = new LoginDAO();
		HttpSession session =  request.getSession();
		RequestDispatcher dispatcher =null;
		String msg ="";
		try {
			dao.login(login);
			session.setAttribute("nome", login.getNome());
			dispatcher = request.getRequestDispatcher("indexLogado.jsp");
			dispatcher.forward(request, response);
		}
		catch (Exception e) {
			dispatcher = request.getRequestDispatcher("login.jsp");
			msg = e.getMessage();
			request.setAttribute("status", "Erro");
		}
		finally {
			request.setAttribute("msgDispacher", msg);
			dispatcher.forward(request, response);
		}
	}

}
