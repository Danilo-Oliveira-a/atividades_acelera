package br.com.atos.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	private static String USERNAME = "ujhjago0sd02ddly";
	private static String PASSWORD = "HRshw59rXoOZqxANcxh4";
	private static String HOST ="b3tb7m1v7hvkjmjw7apy-mysql.services.clever-cloud.com";
	private static String DATA_BASE = "b3tb7m1v7hvkjmjw7apy";
	
	private static String DATABASE_URL = "jdbc:mysql://"+HOST+":3306/"+DATA_BASE+"?useTimezone=true&serverTimezone=UTC";
	
	
	public static Connection criarConexaocomMySql() {
		Connection conexao = null;
		try {
			System.out.println(DATABASE_URL);
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			 conexao = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
			
			 if (conexao != null) {
	             System.out.println("Connected");
	         }
			 else {
				 System.out.println("FAIL ");
			 }
			 
			return conexao;
		}
		catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
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