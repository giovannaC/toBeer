package conexao;

import java.sql.Connection;
import java.sql.DriverManager;


public class connect {
	
	public Connection con;
	//private Connection oConn;
	
	public connect() {
		// TODO Auto-generated constructor stub
	}
	
	// Função para conectar com o banco de dados
	public Connection abrirBDConn() {
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/tobeer";
			con = DriverManager.getConnection(url, "root", "Ginha9201");
			
			System.out.println("Conexao efetuada com sucesso!");
			
			return con;	
		}
		
		catch(Exception e){
			System.out.println("Erro de abrir a conexao de dados.");
			e.printStackTrace();
			return null;
		}
		
	}
	
	public void fecharBD(){
		
		try{
			con.close();
			System.out.println("Conexao finalizada com sucesso!");
		}
		
		catch(Exception e){
			System.out.println("Erro ao fechar a conexao com o BD." + e.getMessage());
		}
		
	}

}
