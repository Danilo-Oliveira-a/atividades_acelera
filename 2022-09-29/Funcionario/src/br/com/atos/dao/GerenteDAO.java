package br.com.atos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.atos.enums.TipoFuncionario;
import br.com.atos.model.Endereco;
import br.com.atos.model.Gerente;
import br.com.atos.persistencia.FabricaDeConexao;

public class GerenteDAO {

	public boolean salvar(Gerente gerente) {
		String sql = "INSERT INTO KIPREVWEB.ACELERA_FUNCIONARIOS "
				+ "(CPF,NOME,ESTADO,RUA,NUMERO,SALARIO,CARGO) "
				+ "VALUES (?, ?, ?, ?, ?,?,?)";
		boolean validasalvar = false;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = FabricaDeConexao.criarConexaocomOracle();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, gerente.getCpf());
			pstm.setString(2, gerente.getNome());
			pstm.setString(3, gerente.getEndereco().getEstado());
			pstm.setString(4, gerente.getEndereco().getRua());
			pstm.setString(5, gerente.getEndereco().getNumero());
			pstm.setDouble(6, gerente.getSalarioLiquido());
			pstm.setString(7, gerente.getCargo().getDescricao());
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

	public List<Gerente> listar() {
		String sql = "select * from KIPREVWEB.ACELERA_FUNCIONARIOS WHERE CARGO = ?"; // Cria a string recebendo o comando de consulta do
																		// SQL
		List<Gerente> listaGerente = new ArrayList<Gerente>(); // Cria a lista de programadores
		Connection conexao = null; // Cria o objeto de conexão (null)
		PreparedStatement pstm = null; // // Cria o objeto de execução (null)
		ResultSet resultSet = null; // Cria o objeto que recebe uma tabela do banco de dados
		try {
			conexao = FabricaDeConexao.criarConexaocomOracle(); // Cria a conexão com o banco e aloca na variavel
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1,TipoFuncionario.GERENTE.getDescricao());// / Cria a execução informando a conexão e o comando SQL
			resultSet = pstm.executeQuery();// Executa o comando SQL e armazena o resultado no objeto ResultSet
			while (resultSet.next()) {
				Gerente gerente = new Gerente();
				Endereco endereco = new Endereco();
				gerente.setCpf(resultSet.getString("cpf"));
				gerente.setNome(resultSet.getString("nome"));
				endereco.setEstado(resultSet.getString("estado"));
				endereco.setRua(resultSet.getString("rua"));
				endereco.setNumero(resultSet.getString("numero"));
				gerente.setEndereco(endereco);
				gerente.setSalarioLiquido(resultSet.getDouble("salario"));
				gerente.setCargo(TipoFuncionario.GERENTE);
				gerente.getCargo().setDescricao(resultSet.getString("cargo"));
				listaGerente.add(gerente);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao buscar lista");
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
		return listaGerente;

	}

	public boolean alterar(Gerente gerente) {
		String sql = "update KIPREVWEB.ACELERA_FUNCIONARIOS G  "
				+ " set g.nome    = ?,"
				+ " g.estado  = ?," + "       "
				+ " g.rua     = ?," + "       "
				+ " g.numero  = ?,"
				+ " g.salario = ?" 
				+ " where g.cpf = ? and cargo = ?";
		boolean validasalvar = false;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = FabricaDeConexao.criarConexaocomOracle();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, gerente.getNome());
			pstm.setString(2, gerente.getEndereco().getEstado());
			pstm.setString(3, gerente.getEndereco().getRua());
			pstm.setString(4, gerente.getEndereco().getNumero());
			pstm.setDouble(5, gerente.getSalarioLiquido());
			pstm.setString(6, gerente.getCpf());
			pstm.setString(7, gerente.getCargo().getDescricao());
			pstm.execute();
			System.out.println("Alterado com sucesso");
			validasalvar = true;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro na tentativa de alterar");

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
				System.out.println("Erro ao tentar encerrrar as conexoes");
			}
		}
		return validasalvar;
	}
	
	public boolean deletar(Gerente gerente) {
		String sql = "delete from KIPREVWEB.ACELERA_FUNCIONARIOS where cpf=? and cargo = ?";
		boolean validasalvar = false;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = FabricaDeConexao.criarConexaocomOracle();
			pstm = (PreparedStatement)conn.prepareStatement(sql);
			pstm.setString(1, gerente.getCpf());
			pstm.setString(2, gerente.getCargo().getDescricao());
			
			pstm.execute();
			System.out.println("deletado com sucesso");
			validasalvar = true;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro na tentativa de registrar");
			
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
				System.out.println("Erro ao tentar encerrrar as conexoes");
			}
		}
		return validasalvar;
	}

}
