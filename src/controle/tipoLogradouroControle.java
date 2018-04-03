package controle;

import java.sql.ResultSet;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import conexao.connect;

public class tipoLogradouroControle {

	public void insereDados(String nome){
		
		connect banco = new connect();
		
		try{
			Connection ExConn = (Connection)banco.abrirBDConn();
			Statement stmt = (Statement)ExConn.createStatement();
		
			String sql = "insert into TIPOLOGRADOURO (TIPOLOGRADOURONOME) values ('" + nome + "');";
		
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
	
	public void excluiDados(int  id){
		
		connect banco = new connect();
		try{
			Connection exConn = (Connection) banco.abrirBDConn();
			Statement stmt = (Statement) exConn.createStatement();
			
			String sqlEnter = "set foreign_key_checks = 0;";
			stmt.execute(sqlEnter);
			String sqlDelete = "delete from TIPOLOGRADOURO where TIPOLOGRADOUROID = " + id + ";";
			
			boolean rs = stmt.execute(sqlDelete);
			System.out.printf((!rs)?"Os dados foram excluidos com sucesso!!":"" + "Dados não foram excluidos com sucesso!!");
			
			stmt.close();
			banco.fecharBD();
		}
		catch(Exception e){
			System.out.printf("Os dados não foram encontrados!! "+ e.getMessage());
		}
		
	}
	
	public ResultSet buscaDados(){
			
			connect banco = new connect();
			try{
				Connection exConn = (Connection) banco.abrirBDConn();
				Statement stmt = (Statement) exConn.createStatement();
				String sqlBusca = "select * from TIPOLOGRADOURO;";
				
				ResultSet rs = stmt.executeQuery(sqlBusca);
				
				return rs;
			}
			catch(Exception e){
				return null;
			}
	}
	
	public ResultSet buscaDados(int id){
		connect banco = new connect();
		try{
			Connection exConn = (Connection) banco.abrirBDConn();
			Statement stmt = (Statement) exConn.createStatement();
			String sqlBusca = "select * from TIPOLOGRADOURO where TIPOLOGRADOUROID = " + id + ";";
			
			ResultSet rs = stmt.executeQuery(sqlBusca);
			while(rs.next()){
				System.out.printf( "BUSCA TIPOLOGRADURO" + rs.getString("TIPOLOGRADOURONOME"));
				
			}
			return rs;
		}
		catch(Exception e){
			return null;
		}
	}

	public int buscaId(String nome){
		int i = 0;
		connect banco = new connect();
		try{
			Connection exConn = (Connection) banco.abrirBDConn();
			Statement stmt = (Statement) exConn.createStatement();
			String sqlBusca = "select * from TIPOLOGRADOURO where TIPOLOGRADOURONOME = '" + nome + "';";
			
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
	
	public String buscaNome(int id){
		String i = null;
		connect banco = new connect();
		try{
			Connection exConn = (Connection) banco.abrirBDConn();
			Statement stmt = (Statement) exConn.createStatement();
			String sqlBusca = "select * from TIPOLOGRADOURO where TIPOLOGRADOUROID = " + id + ";";
			
			ResultSet rs = stmt.executeQuery(sqlBusca);
			while(rs.next()){
				System.out.println(rs.getInt(1));
			
				i =  rs.getString("TIPOLOGRADOURONOME");
			}
			return i;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public void alteraDados(String nome, int idTipoLogradouro){
		
		connect banco = new connect();
		try{
			Connection exConn = (Connection) banco.abrirBDConn();
			Statement stmt = (Statement) exConn.createStatement();
			
			String sqlEnter = "set foreign_key_checks = 0;";
			stmt.execute(sqlEnter);
			String sqlUpdate = "update TIPOLOGRADOURO set TIPOLOGRADOURONOME = '" + nome + "'"
					+ " where TIPOLOGRADOUROID = " + idTipoLogradouro + ";";
			
			int retorno = stmt.executeUpdate(sqlUpdate);
			
			if(retorno == 1){
				System.out.printf("Dados atualizados!");
			}
			
			stmt.close();
			banco.fecharBD();
		}
		catch(Exception e){
			System.out.printf("Dados não atualizados!!");
		}
	}
	
}
