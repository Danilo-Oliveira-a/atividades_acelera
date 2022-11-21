package br.com.atos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.atos.model.Aluno;
import br.atos.model.Endereco;
import br.com.atos.factory.ConnectionFactory;

public class AlunoDAO {

	public List<Aluno> listaAlunos(){
		String sql = " select * from pessoas where tipo_pessoa = ?"; 
		Connection conexao = null; // Cria o objeto de conexão (null)
		PreparedStatement pstm = null; // // Cria o objeto de execução (null)
		ResultSet resultSet = null; // Cria o objeto que recebe uma tabela do banco de dados
		List<Aluno> Alunoes = new ArrayList<Aluno>();
		try {
			conexao = ConnectionFactory.criarConexaocomMySql(); // Cria a conexão com o banco e aloca na variavel
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1,"A");
			resultSet = pstm.executeQuery();// Executa o comando SQL e armazena o resultado no objeto ResultSet
			
			System.out.println("lista sucesso!");
			while( resultSet.next()) {
				Aluno aluno = new Aluno();
				aluno.setNome(resultSet.getString("nome"));
				aluno.setCpf(resultSet.getString("cpf"));
				aluno.setTurma(resultSet.getString("turma"));
				aluno.setMedia(resultSet.getDouble("media"));
				Endereco end = new Endereco();
				end.setCidade(resultSet.getString("cidade"));
				end.setRua(resultSet.getString("rua"));
				end.setCasa(resultSet.getString("casa"));
				aluno.setEndereco(end);
				Alunoes.add(aluno);
			};
			
			return Alunoes;
			
		} catch (Exception e) {
			System.out.println("erro ao listar");
			return Alunoes;
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

	public boolean usuarioExistente(Aluno aluno) {
		String sql = " select * from pessoas where cpf =?"; 
		Connection conexao = null; // Cria o objeto de conexão (null)
		PreparedStatement pstm = null; // // Cria o objeto de execução (null)
		ResultSet resultSet = null; // Cria o objeto que recebe uma tabela do banco de dados
		try {
			conexao = ConnectionFactory.criarConexaocomMySql(); // Cria a conexão com o banco e aloca na variavel
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1,aluno.getCpf());
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
	public boolean salvar(Aluno aluno) throws Exception {
		String sql = "INSERT INTO pessoas "
				+ "(nome,cpf,cidade,rua,casa,turma,media,tipo_pessoa)"
				+ "VALUES (?,?,?,?,?,?,?,?)";
		boolean validasalvar = false;
		Connection conn = null;
		PreparedStatement pstm = null;
		if(usuarioExistente(aluno)) {
			throw new Exception("Usuário já existe");
		}
		try {
			conn = ConnectionFactory.criarConexaocomMySql();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, aluno.getNome());
			pstm.setString(2, aluno.getCpf());
			pstm.setString(3, aluno.getEndereco().getCidade());
			pstm.setString(4, aluno.getEndereco().getRua());
			pstm.setString(5, aluno.getEndereco().getCasa());
			pstm.setString(6, aluno.getTurma());
			pstm.setDouble(7, aluno.getMedia());			
			pstm.setString(8, "A");
			
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
	
	public boolean editar(Aluno aluno) {
		String sql = "update pessoas "
				+ "set nome = ?, "
				+ "cidade=?,"
				+ "rua=?,"
				+ "casa=?,"
				+ "turma =?,"
				+ "media=?"
				+ "where cpf = ? "
				+ "	AND tipo_pessoa =?";
				
		boolean validasalvar = false;
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.criarConexaocomMySql();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, aluno.getNome());
			pstm.setString(2, aluno.getEndereco().getCidade());
			pstm.setString(3, aluno.getEndereco().getRua());
			pstm.setString(4, aluno.getEndereco().getCasa());
			pstm.setString(5, aluno.getTurma());
			pstm.setDouble(6, aluno.getMedia());	
			pstm.setString(7, aluno.getCpf());
			pstm.setString(8, "A");
			
			pstm.execute();			
			validasalvar = true;
			System.out.println("alterado com sucesso");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("erro ao alterar");
			return false;

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
	
	public boolean exlcuir(Aluno aluno) {
		String sql = "delete from pessoas "
				+ "where cpf = ?"
				+ "and tipo_pessoa = ?";
				
		boolean validasalvar = false;
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.criarConexaocomMySql();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, aluno.getCpf());
			pstm.setString(2, "A");
			
			pstm.execute();			
			validasalvar = true;
			System.out.println("deletado com sucesso");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("erro ao deletar");
			return false;

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
