package controle;

import java.sql.ResultSet;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import conexao.connect;

public class estadoControle {

	public void insereDados(String nome, String sigla){
		
		connect banco = new connect();
		try{
			Connection ExConn = (Connection)banco.abrirBDConn();
			Statement stmt = (Statement)ExConn.createStatement();
			
			boolean res = true;
			
			if(buscaId(sigla) < 1){	
			
				String sql = "insert into ESTADO (ESTADONOME, ESTADOSIGLA) values ('" + nome + "', '" + sigla + "');";
			
				System.out.println(sql);
			
				res = stmt.execute(sql);
				System.out.printf((!res)?"Dados inseridos com sucesso." :"" + "Os dados não puderam ser inseridos.");
			}else{
				System.out.printf((!res)?"Dados inseridos já com sucesso." :"" + "Os dados não puderam ser inseridos.");
			}
			
			
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
			String sqlDelete = "delete from ESTADO where ESTADOID = " + id + ";";
			
			boolean rs = stmt.execute(sqlDelete);
			System.out.printf((!rs)?"Os dados foram excluidos com sucesso!!":""
					+ "Dados não foram excluidos com sucesso!!");
			
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
			String sqlBusca = "select * from ESTADO;";
			
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
			String sqlBusca = "select * from ESTADO where ESTADOID = " + id + ";";
			
			ResultSet rs = stmt.executeQuery(sqlBusca);
			while(rs.next()){
				System.out.printf("BUSCA ESTADO = " + rs.getString("ESTADOSIGLA"));
			}
			return rs;
		}
		catch(Exception e){
			return null;
		}
	}
	
	public int buscaId(String siglaEstado){
		int i = 0;
		
		connect banco = new connect();
		try{
			Connection exConn = (Connection) banco.abrirBDConn();
			Statement stmt = (Statement) exConn.createStatement();
			String sqlBusca = "select * from ESTADO where ESTADOSIGLA = '" + siglaEstado + "';";
			
			System.out.println(sqlBusca);
			
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

	public void alteraDados(String nome, String sigla, int idEstado){
		
		connect banco = new connect();
		try{
			Connection exConn = (Connection) banco.abrirBDConn();
			Statement stmt = (Statement) exConn.createStatement();
			
			String sqlUpdate = "update ESTADO set ESTADONOME = '" + nome + "'"
					+ " , ESTADO SIGLA = '" + sigla + "' where ESTADOID = " + idEstado + ";";
			
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
