package controle;

import java.sql.ResultSet;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import classes.encontro;
import conexao.connect;

public class encontroControle {
	
	public void insereDados(int bar, int pessoa, int grupo, String in, String out, String dirigir){
		
		connect banco = new connect();
		try{
			Connection ExConn = (Connection)banco.abrirBDConn();
			Statement stmt = (Statement)ExConn.createStatement();
			
			String sql = "insert into ENCONTRO (BARID, PESSOAID, GRUPOID, ENCONTROCHECKIN, ENCONTROCHECKOUT, ENCONTRODIRIGIR) values "
					+ "("+ bar +", "+ pessoa +", "+ grupo +", '"+ in +"', '"+ out +"', '"+ dirigir +"');";
			
			
			System.out.println(sql);
			
			boolean res = stmt.execute(sql);
			System.out.printf((!res)?"Dados inseridos com sucesso." :"" + "Os dados não puderam ser inseridos.");
			
			stmt.close();
			banco.fecharBD();
			
		}
		
		catch(Exception e){
			System.out.printf("Os dados não puderam ser inseridos!! " + e.getMessage());
			
		}
	}
	
	public void excluiDados(int idEncontro){
		
		connect banco = new connect();
		try{
			Connection exConn = (Connection) banco.abrirBDConn();
			Statement stmt = (Statement) exConn.createStatement();
			
			String sqlDelete = "delete from ENCONTRO where ENCONTROID = " + idEncontro + ";";
			
			boolean rs = stmt.execute(sqlDelete);
			System.out.printf((!rs)?"Os dados foram excluidos com sucesso!!":"" + "Dados não foram excluidos com sucesso!!");
			
			stmt.close();
			banco.fecharBD();
		}
		catch(Exception e){
			System.out.printf("Os dados não foram encontrados!!");
		}
		
	}
	
	public ResultSet buscaDados(){
		
		connect banco = new connect();
		try{
			Connection exConn = (Connection) banco.abrirBDConn();
			Statement stmt = (Statement) exConn.createStatement();
			String sqlBusca = "select * from ENCONTRO;";
			
			ResultSet rs = stmt.executeQuery(sqlBusca);
			
			return rs;
		}
		catch(Exception e){
			return null;
		}
	}
	
	public ResultSet buscaDadosPessoa(int idPessoa){
		
		connect banco = new connect();
		try{
			Connection exConn = (Connection) banco.abrirBDConn();
			Statement stmt = (Statement) exConn.createStatement();
			String sqlBusca = "select * from ENCONTRO where PESSOAID = "+ idPessoa + ";";
			
			ResultSet rs = stmt.executeQuery(sqlBusca);
			//while(rs.next()){
			//	System.out.println(rs.getInt(1));
			//}
			return rs;
		}
		catch(Exception e){
			return null;
		}
	}
	
	public ResultSet buscaDadosBar(int idBar){
		
		connect banco = new connect();
		try{
			Connection exConn = (Connection) banco.abrirBDConn();
			Statement stmt = (Statement) exConn.createStatement();
			String sqlBusca = "select * from ENCONTRO where BARID = "+ idBar + ";";
			
			ResultSet rs = stmt.executeQuery(sqlBusca);
			//while(rs.next()){
			//	System.out.println(rs.getInt(1));
			//}
			return rs;
		}
		catch(Exception e){
			return null;
		}
	}
	
	public int buscaId(int id){
		int i = 0;
		connect banco = new connect();
		try{
			Connection exConn = (Connection) banco.abrirBDConn();
			Statement stmt = (Statement) exConn.createStatement();
			String sqlBusca = "select * from ENCONTRO where PESSOAID = "+ id + ";";
			
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

	public void alteraDados(int bar, int pessoa, int grupo, String in, String out, String dirigir, encontro encontroClass){
		
		connect banco = new connect();
		try{
			Connection exConn = (Connection) banco.abrirBDConn();
			Statement stmt = (Statement) exConn.createStatement();
			
			String sqlUpdate = "update ENCONTRO set BARID = "+ bar +", GRUPOID = "+ grupo +", ENCONTROCHECKIN = '"+ in +"',"
					+ " ENCONTROCHECKOUT = '"+ out +"', ENCONTRODIRIGIR = '"+ dirigir +"'  where PESSOAID = " + encontroClass.getIdPessoa() + ";";
			
			int retorno = stmt.executeUpdate(sqlUpdate);
			
			if(retorno == 1){
				System.out.printf("Dados atualizados!");
			}
			
			stmt.close();
			banco.fecharBD();
		}
		catch(Exception e){
			System.out.printf("Dados não atualizados!! " + e.getMessage());
		}
	}


}
