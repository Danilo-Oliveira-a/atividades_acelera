package br.com.atos.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaDeConexao {

	private static String USERNAME = "root";
	private static String PASSWORD = "root";
	
	private static String DATABASE_URL = "jdbc:mysql://localhost:3306/funcionarios?useTimezone=true&serverTimezone=UTC";
	
	
	public static Connection criarConexaocomMySql() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conexao = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
		
		
		return conexao;
		
	} 
	
	
	public static Connection criarConexaocomOracle() throws Exception {
		String USERNAME = "";
		String PASSWORD = "";
		String classForName ="oracle.jdbc.OracleDriver";
		String DATABASE_URL = "";
		
		Class.forName(classForName);
		
		Connection conexao = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
		
		 if (conexao != null) {
             System.out.println("Connected");
         }
		 else {
			 System.out.println("FAIL ");
		 }
		
		return conexao;
		
	} 
	
}
