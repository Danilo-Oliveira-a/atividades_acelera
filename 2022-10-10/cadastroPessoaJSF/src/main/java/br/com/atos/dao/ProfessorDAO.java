package br.com.atos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.atos.model.Endereco;
import br.atos.model.Professor;
import br.com.atos.factory.ConnectionFactory;

public class ProfessorDAO {

	public List<Professor> listaProfessores(){
		String sql = " select * from pessoas where tipo_pessoa = ?"; 
		Connection conexao = null; // Cria o objeto de conexão (null)
		PreparedStatement pstm = null; // // Cria o objeto de execução (null)
		ResultSet resultSet = null; // Cria o objeto que recebe uma tabela do banco de dados
		List<Professor> professores = new ArrayList<Professor>();
		try {
			conexao = ConnectionFactory.criarConexaocomMySql(); // Cria a conexão com o banco e aloca na variavel
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1,"P");
			resultSet = pstm.executeQuery();// Executa o comando SQL e armazena o resultado no objeto ResultSet
			
			
			while( resultSet.next()) {
				Professor professor = new Professor();
				professor.setNome(resultSet.getString("nome"));
				professor.setCpf(resultSet.getString("cpf"));
				professor.setDisciplina(resultSet.getString("disciplina"));
				professor.setSalario(resultSet.getDouble("salario"));
				Endereco end = new Endereco();
				end.setCidade(resultSet.getString("cidade"));
				end.setRua(resultSet.getString("rua"));
				end.setCasa(resultSet.getString("casa"));
				professor.setEndereco(end);
				professores.add(professor);
				System.out.println("Sucesso ao listar professores");
			};
			
			return professores;
			
		} catch (Exception e) {
			System.out.println("erro ao listar");
			return professores;
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

	public boolean  pessoaExistente(Professor professor) {
		String sql = " select * from pessoas where cpf =? and tipo_pessoa=?"; 
		Connection conexao = null; // Cria o objeto de conexão (null)
		PreparedStatement pstm = null; // // Cria o objeto de execução (null)
		ResultSet resultSet = null; // Cria o objeto que recebe uma tabela do banco de dados
		try {
			conexao = ConnectionFactory.criarConexaocomMySql(); // Cria a conexão com o banco e aloca na variavel
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1,professor.getCpf());
			pstm.setString(2, "P");
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
	public boolean salvar(Professor professor) throws Exception {
		String sql = "INSERT INTO pessoas "
				+ "(nome,cpf,cidade,rua,casa,disciplina,salario,tipo_pessoa)"
				+ "VALUES (?,?,?,?,?,?,?,?)";
		boolean validasalvar = false;
		Connection conn = null;
		PreparedStatement pstm = null;
		if(pessoaExistente(professor)) {
			throw new Exception("Usuário já existe");
		}
		try {
			conn = ConnectionFactory.criarConexaocomMySql();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, professor.getNome());
			pstm.setString(2, professor.getCpf());
			pstm.setString(3, professor.getEndereco().getCidade());
			pstm.setString(4, professor.getEndereco().getRua());
			pstm.setString(5, professor.getEndereco().getCasa());
			pstm.setString(6, professor.getDisciplina());
			pstm.setDouble(7, professor.getSalario());			
			pstm.setString(8, "P");
			
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
	
	public boolean editar(Professor professor) {
		String sql = "update pessoas "
				+ "set nome = ?, "
				+ "cidade=?,"
				+ "rua=?,"
				+ "casa=?,"
				+ "disciplina =?,"
				+ "salario=?"
				+ "where cpf = ?"
				+ "and tipo_pessoa = ?";
				
		boolean validasalvar = false;
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.criarConexaocomMySql();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, professor.getNome());
			pstm.setString(2, professor.getEndereco().getCidade());
			pstm.setString(3, professor.getEndereco().getRua());
			pstm.setString(4, professor.getEndereco().getCasa());
			pstm.setString(5, professor.getDisciplina());
			pstm.setDouble(6, professor.getSalario());	
			pstm.setString(7, professor.getCpf());
			pstm.setString(8, "P");
			validasalvar = true;
			pstm.execute();
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
	
	public boolean exlcuir(Professor professor) throws Exception {
		String sql = "delete from pessoas "
				+ "where cpf = ?"
				+ "and tipo_pessoa = ?";
				
		boolean validasalvar = false;
		Connection conn = null;
		PreparedStatement pstm = null;
		
		if(!pessoaExistente(professor)) {
			throw new Exception("Usuário não existe");
		}
		try {
			conn = ConnectionFactory.criarConexaocomMySql();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, professor.getCpf());
			pstm.setString(2, "P");
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
