package br.com.atos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.atos.enums.TipoFuncionario;
import br.com.atos.model.Endereco;
import br.com.atos.model.Coordenador;
import br.com.atos.persistencia.FabricaDeConexao;

public class CoordenadorDAO {

	public boolean salvar(Coordenador coordenador) {
		String sql = "INSERT INTO KIPREVWEB.ACELERA_FUNCIONARIOS "
				+ "(CPF,NOME,ESTADO,RUA,NUMERO,SALARIO,CARGO) "
				+ "VALUES (?, ?, ?, ?, ?,?,?)";
		boolean validasalvar = false;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = FabricaDeConexao.criarConexaocomOracle();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, coordenador.getCpf());
			pstm.setString(2, coordenador.getNome());
			pstm.setString(3, coordenador.getEndereco().getEstado());
			pstm.setString(4, coordenador.getEndereco().getRua());
			pstm.setString(5, coordenador.getEndereco().getNumero());
			pstm.setDouble(6, coordenador.getSalarioLiquido());
			pstm.setString(7, coordenador.getCargo().getDescricao());
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

	public List<Coordenador> listar() {
		String sql = "select * from KIPREVWEB.ACELERA_FUNCIONARIOS 	WHERE CARGO =?"; // Cria a string recebendo o comando de consulta do
																		// SQL
		List<Coordenador> listaCoordenador = new ArrayList<Coordenador>(); // Cria a lista de programadores
		Connection conexao = null; // Cria o objeto de conexão (null)
		PreparedStatement pstm = null; // // Cria o objeto de execução (null)
		ResultSet resultSet = null; // Cria o objeto que recebe uma tabela do banco de dados
		try {
			conexao = FabricaDeConexao.criarConexaocomOracle(); // Cria a conexão com o banco e aloca na variavel
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1,TipoFuncionario.COORDENADOR.getDescricao());
			resultSet = pstm.executeQuery();// Executa o comando SQL e armazena o resultado no objeto ResultSet
			while (resultSet.next()) {
				Coordenador Coordenador = new Coordenador();
				Endereco endereco = new Endereco();
				Coordenador.setCpf(resultSet.getString("cpf"));
				Coordenador.setNome(resultSet.getString("nome"));
				endereco.setEstado(resultSet.getString("estado"));
				endereco.setRua(resultSet.getString("rua"));
				endereco.setNumero(resultSet.getString("numero"));
				Coordenador.setEndereco(endereco);
				Coordenador.setSalarioLiquido(resultSet.getDouble("salario"));
				Coordenador.setCargo(TipoFuncionario.COORDENADOR);
				Coordenador.getCargo().setDescricao(resultSet.getString("cargo"));
				listaCoordenador.add(Coordenador);
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
		return listaCoordenador;

	}

	public boolean alterar(Coordenador coordenador) {
		String sql = "update KIPREVWEB.ACELERA_FUNCIONARIOS G\r\n" + "   set g.nome    = ?,\r\n"
				+ "       g.estado  = ?,\r\n" + "       g.rua     = ?,\r\n" + "       g.numero  = ?,\r\n"
				+ "       g.salario = ?\r\n" + " where g.cpf = ? and cargo =?\r\n" + "";
		boolean validasalvar = false;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = FabricaDeConexao.criarConexaocomOracle();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
//		pstm.setString(1, Coordenador.getCpf());
			pstm.setString(1, coordenador.getNome());
			pstm.setString(2, coordenador.getEndereco().getEstado());
			pstm.setString(3, coordenador.getEndereco().getRua());
			pstm.setString(4, coordenador.getEndereco().getNumero());
			pstm.setDouble(5, coordenador.getSalarioLiquido());
			pstm.setString(6, coordenador.getCpf());
			pstm.setString(7, coordenador.getCargo().getDescricao());
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
	
	public boolean deletar(Coordenador coordenador) {
		String sql = "delete from KIPREVWEB.ACELERA_FUNCIONARIOS where cpf=? and cargo=?";
		boolean validasalvar = false;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = FabricaDeConexao.criarConexaocomOracle();
			pstm = (PreparedStatement)conn.prepareStatement(sql);
			pstm.setString(1, coordenador.getCpf());
			pstm.setString(2, coordenador.getCargo().getDescricao());
			
			
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
