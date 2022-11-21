package br.com.atos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.atos.factory.ConnectionFactory;
import br.com.atos.model.User;

public class LoginDAO {

	public void login(User user) throws Exception {
		String sql = " select * from usuarios where nome =? and senha = ?"; 
		Connection conexao = null; // Cria o objeto de conexão (null)
		PreparedStatement pstm = null; // // Cria o objeto de execução (null)
		ResultSet resultSet = null; // Cria o objeto que recebe uma tabela do banco de dados
		try {
			conexao = ConnectionFactory.criarConexaocomMySql(); // Cria a conexão com o banco e aloca na variavel
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1,user.getNome());
			pstm.setString(2,user.getSenha());
			resultSet = pstm.executeQuery();// Executa o comando SQL e armazena o resultado no objeto ResultSet
			
			System.out.println("Sucesso");
			boolean possuiReg = resultSet.next();
			if(!possuiReg)
				throw new Exception("Nenhum usuário encontrado!");
			
		} catch (Exception e) {
			throw new Exception("Erro ao consultar usuário");
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

	public boolean usuarioExistente(User user) {
		String sql = " select * from usuarios where nome =?"; 
		Connection conexao = null; // Cria o objeto de conexão (null)
		PreparedStatement pstm = null; // // Cria o objeto de execução (null)
		ResultSet resultSet = null; // Cria o objeto que recebe uma tabela do banco de dados
		try {
			conexao = ConnectionFactory.criarConexaocomMySql(); // Cria a conexão com o banco e aloca na variavel
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1,user.getNome());
			resultSet = pstm.executeQuery();// Executa o comando SQL e armazena o resultado no objeto ResultSet
			
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
	public boolean cadastrar(User login) throws Exception {
		String sql = "INSERT INTO usuarios "
				+ "(nome,senha,email,telefone)"
				+ "VALUES (?, ?,?,?)";
		boolean validasalvar = false;
		Connection conn = null;
		PreparedStatement pstm = null;
		if(usuarioExistente(login)) {
			throw new Exception("Usuário já existe");
		}
		try {
			conn = ConnectionFactory.criarConexaocomMySql();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, login.getNome());
			pstm.setString(2, login.getSenha());
			pstm.setString(3, login.getEmail());
			pstm.setString(4, login.getTelefone());
			
			pstm.execute();
			System.out.println("Registrado com sucesso");
			validasalvar = true;

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro na tentativa de registrar");

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
