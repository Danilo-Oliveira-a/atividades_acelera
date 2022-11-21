package br.com.atos.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.atos.dao.LoginDAO;
import br.com.atos.model.User;

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
		String nome= request.getParameter("nome");
		String senha= request.getParameter("senha");
		String email= request.getParameter("email");
		String telefone= request.getParameter("telefone");
			
		User login = new User();
		login.setNome(nome);
		login.setSenha(senha);
		login.setEmail(email);
		login.setTelefone(telefone);	
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("registration.jsp");
		LoginDAO dao = new LoginDAO();			
		String msg = "";
		boolean sucessoRegistrar;
		try {
			sucessoRegistrar = false;
			sucessoRegistrar = dao.cadastrar(login);
			if(sucessoRegistrar) {
				 msg = "Cadastrado com sucesso!";
				 request.setAttribute("status", "Sucesso");
			}
			else {
				 msg = "Erro ao cadastrar usuário!";
				 request.setAttribute("status", "Erro");
			}
		}
		catch (Exception e) {
			msg = e.getMessage();
			request.setAttribute("status", "Erro");
		}
		finally {
			request.setAttribute("msgDispacher", msg);
			dispatcher.forward(request, response);
		}
		
		
		
	}

}
