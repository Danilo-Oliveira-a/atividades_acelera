package br.com.atos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.atos.factory.ConnectionFactory;
import br.com.atos.model.UserLogin;

public class LoginDAO {

	public boolean login(UserLogin user) {
		String sql = " select * from usuarios_login where userName =? and pass = ?"; 
		Connection conexao = null; // Cria o objeto de conexão (null)
		PreparedStatement pstm = null; // // Cria o objeto de execução (null)
		ResultSet resultSet = null; // Cria o objeto que recebe uma tabela do banco de dados
		try {
			conexao = ConnectionFactory.criarConexaocomMySql(); // Cria a conexão com o banco e aloca na variavel
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1,user.getUserName());
			pstm.setString(2,user.getPassword());
			resultSet = pstm.executeQuery();// Executa o comando SQL e armazena o resultado no objeto ResultSet
			
			System.out.println("Sucesso");
			boolean possuiReg = resultSet.next();
			return possuiReg;

			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao buscar lista: "+e);
			return false;
		} finally {
			try {

				if (resultSet != null) {
					resultSet.close();
				}
				if (conexao != null) {
					conexao.close();
				}

				if (pstm != null) {
					pstm.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
				System.out.println("Erro ao fechar conexão");
			}

		}

	}

	public boolean cadastrar(UserLogin login) {
		String sql = "INSERT INTO usuarios_login "
				+ "(userName,pass)"
				+ "VALUES (?, ?)";
		boolean validasalvar = false;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.criarConexaocomMySql();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, login.getUserName());
			pstm.setString(2, login.getPassword());
			
			pstm.execute();
			System.out.println("Registrado com sucesso");
			validasalvar = true;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro na tentativa de registrar");

		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
				System.out.println("Erro ao tentar encerrrar as conexÃµes");
			}
		}
		return validasalvar;
	}
}
