package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class ConexaoDB {

	private Connection conexao = null;
	private Statement statementQuery = null;
	private ResultSet sql = null;
	
			
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		if (conexao == null){
			
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				conexao = DriverManager.getConnection ("jdbc:sqlserver://localhost:1433;databaseName=master;user=vinicius;;integratedSecurity=true;");
				System.out.println("Conexao OK");
		}
		
		return conexao ;
	}
	
	public void close() {
		try {
			if (sql != null) {
				sql.close();
			}

			if (statementQuery != null) {
				statementQuery.close();
			}
						
			if (conexao != null) {
				conexao.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
		public void cadastrarUsuario(String n, String c, String e, String p) throws SQLException{
		 statementQuery = conexao.createStatement();
		 statementQuery.executeUpdate("INSERT INTO Usuarios (Nome, Email, Telefone, Senha) VALUES ('" + n +"','" + e +"','" + c + "','" + p +"')");
		
	}
	
	
}
