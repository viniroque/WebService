package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Loja;

public class LojaDao {
	
	private Connection conexao;
	private Statement statement = null;
	private ResultSet sql = null;
	
	public Connection conexaoBDSqlServer() throws SQLException, ClassNotFoundException{

		 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		// Efetua a conexão com o BD
		conexao = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=master;user=vinicius;;integratedSecurity=true;");
		
		return conexao;
		
	}
	
	
	public List buscaLoja() throws SQLException {
		List <Loja> Lojas = new ArrayList<Loja>();
		statement = conexao.createStatement();
		sql = statement.executeQuery("select * from empresas");
		while(sql.next()) {
			Loja loja = new Loja();
			loja.setId(sql.getInt("id"));
			loja.setNome(sql.getString("nome"));
			Lojas.add(loja);
		}
	
		return Lojas;
		
	}
	
	
	public void close() throws SQLException {
		conexao.close();
	}

}
