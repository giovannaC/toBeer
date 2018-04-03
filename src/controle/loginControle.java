package controle;

import java.sql.ResultSet;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import classes.login;
import conexao.connect;

public class loginControle {

	public void insereDados(String telefone){
		
		connect banco = new connect();
		
		try{
			Connection ExConn = (Connection)banco.abrirBDConn();
			Statement stmt = (Statement)ExConn.createStatement();
		
			String sql = "insert into LOGIN (TELEFONE) values ('" + telefone + "');";
		
			System.out.println(sql);
		
			boolean res = stmt.execute(sql);
			System.out.printf((!res)?"Dados inseridos com sucesso." :"" + "Os dados não puderam ser inseridos.");
		
			stmt.close();
			banco.fecharBD();
		
			}
		catch(Exception e){
			System.out.printf("Os dados não puderam ser inseridos!!");
		}

	}
	
	public void excluiDados(){
		boolean rs = true;
		connect banco = new connect();
		try{
			Connection exConn = (Connection) banco.abrirBDConn();
			Statement stmt = (Statement) exConn.createStatement();
			
			String sqlEnter = "set foreign_key_checks = 0;";
			stmt.execute(sqlEnter);
			String sqlDelete = "delete from LOGIN where LOGINID > 0;";
			
			rs = stmt.execute(sqlDelete);	
			System.out.printf("LOGIN EXCLUIDOS " + rs);
				
			stmt.close();
			banco.fecharBD();
		}
		catch(Exception e){
			System.out.printf(e.getMessage() + rs);
		}
		
	}
	
	public ResultSet buscaDados(){
			
			connect banco = new connect();
			try{
				Connection exConn = (Connection) banco.abrirBDConn();
				Statement stmt = (Statement) exConn.createStatement();
				String sqlBusca = "select * from LOGIN;";
				
				ResultSet rs = stmt.executeQuery(sqlBusca);
				while(rs.next()){
					System.out.printf("BUSCA LOGIN" + rs.getString("TELEFONE"));
					
				}
				
				return rs;
			}
			catch(Exception e){
				return null;
			}
	}
	
	public ResultSet buscaDados(String telefone){
		connect banco = new connect();
		try{
			Connection exConn = (Connection) banco.abrirBDConn();
			Statement stmt = (Statement) exConn.createStatement();
			String sqlBusca = "select * from LOGIN where TELEFONE = '" + telefone + "';";
			
			ResultSet rs = stmt.executeQuery(sqlBusca);
			while(rs.next()){
				System.out.println("BUSCA LOGIN" + rs.getString("TELEFONE"));
				
			}
			return rs;
		}
		catch(Exception e){
			return null;
		}
	}

	public int buscaId(String telefone){
		int i = 0;
		connect banco = new connect();
		try{
			Connection exConn = (Connection) banco.abrirBDConn();
			Statement stmt = (Statement) exConn.createStatement();
			String sqlBusca = "select * from LOGIN where TELEFONE = '" + telefone + "';";
			
			ResultSet rs = stmt.executeQuery(sqlBusca);
			while(rs.next()){
				System.out.println(rs.getInt(1));
				
				i =  rs.getInt(1);
			}
			return i;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return -1;
		}
	}
	
	public void alteraDados(String telefone, login loginClass){
		
		connect banco = new connect();
		try{
			Connection exConn = (Connection) banco.abrirBDConn();
			Statement stmt = (Statement) exConn.createStatement();
			
			String sqlUpdate = "update LOGIN set TELEFONE = '" + telefone + "'"
					+ " where LOGINID = " + loginClass.getIdLogin() + ";";
			
			int retorno = stmt.executeUpdate(sqlUpdate);
			
			if(retorno == 1){
				System.out.println("Dados atualizados!");
			}
			
			stmt.close();
			banco.fecharBD();
		}
		catch(Exception e){
			System.out.printf("Dados não atualizados!!");
		}
	}

}
