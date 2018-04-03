package controle;

import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import conexao.connect;

public class procuraControle {
	
	public void insereDados(String nomeBar, String nomeGrupo){
		
		connect banco = new connect();
		
		try{
			Connection ExConn = (Connection)banco.abrirBDConn();
			Statement stmt = (Statement)ExConn.createStatement();
		
			String sql = "insert into PROCURA (PROCURABAR, PROCURAGRUPO) values ('"+ nomeBar +"', '"+ nomeGrupo +"');";
		
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
			String sqlDelete = "delete from PROCURA where PROCURAID > 0;";
			
			rs = stmt.execute(sqlDelete);	
			System.out.printf("PROCURA excluido " + rs);
				
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
				String sqlBusca = "select * from PROCURA;";
				
				ResultSet rs = stmt.executeQuery(sqlBusca);
				while(rs.next()){
					System.out.printf("BUSCA PROCURA" + rs.getString("PROCURABAR"));
					
				}
				
				return rs;
			}
			catch(Exception e){
				return null;
			}
	}
	
	public ResultSet buscaDadosBar(String nomeBar){
		connect banco = new connect();
		try{
			Connection exConn = (Connection) banco.abrirBDConn();
			Statement stmt = (Statement) exConn.createStatement();
			String sqlBusca = "select * from PROCURA where PROCURABAR = '" + nomeBar + "';";
			
			ResultSet rs = stmt.executeQuery(sqlBusca);
			while(rs.next()){
				System.out.println("BUSCA PROCURABAR" + rs.getString("PROCURABAR"));
				
			}
			return rs;
		}
		catch(Exception e){
			return null;
		}
	}

	public ResultSet buscaDadosGrupo(String nomeGrupo){
		connect banco = new connect();
		try{
			Connection exConn = (Connection) banco.abrirBDConn();
			Statement stmt = (Statement) exConn.createStatement();
			String sqlBusca = "select * from PROCURA where PROCURAGRUPO = '" + nomeGrupo + "';";
			
			ResultSet rs = stmt.executeQuery(sqlBusca);
			while(rs.next()){
				System.out.println("BUSCA PROCURAGRUPO" + rs.getString("PROCURAGRUPO"));
				
			}
			return rs;
		}
		catch(Exception e){
			return null;
		}
	}
	
	public int buscaId(String nomeBar){
		int i = 0;
		connect banco = new connect();
		try{
			Connection exConn = (Connection) banco.abrirBDConn();
			Statement stmt = (Statement) exConn.createStatement();
			String sqlBusca = "select * from LOGIN where PROCURABAR = '" + nomeBar + "';";
			
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
	


}
