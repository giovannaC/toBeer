package controle;

import java.sql.ResultSet;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import conexao.connect;


public class grupoControle {
	
	public void insereDados(int pessoa, int bar, String nome, String senha, int maximo, String hora){
		
		connect banco = new connect();
		try{
			Connection ExConn = (Connection)banco.abrirBDConn();
			Statement stmt = (Statement)ExConn.createStatement();
			
			String sql = "insert into GRUPO (PESSOAID, BARID, GRUPONOME, GRUPOSENHA, GRUPOMAX, GRUPOHORARIO) values "
					+ "("+ pessoa +", "+ bar +", '"+ nome +"', '"+ senha +"', "+ maximo +", '"+ hora +"');";
			
			
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
			
			String sqlDelete = "delete from GRUPO where GRUPOID = " + id + ";";
			
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
			String sqlBusca = "select * from GRUPO;";
			
			ResultSet rs = stmt.executeQuery(sqlBusca);
			while(rs.next()){
				System.out.println(sqlBusca);
				System.out.printf("BUSCADADOSPESSOA:" + rs.getString("PESSOANOME"));
				
			}
			
			return rs;
		}
		catch(Exception e){
			return null;
		}
	}
	
	public ResultSet buscaDados(String nome){
		
		connect banco = new connect();
		try{
			Connection exConn = (Connection) banco.abrirBDConn();
			Statement stmt = (Statement) exConn.createStatement();
			String sqlBusca = "select * from GRUPO where GRUPONOME = '" + nome + "';";
			
			ResultSet rs = stmt.executeQuery(sqlBusca);
			while(rs.next()){
				System.out.println(sqlBusca);
				System.out.printf( "BUSCADADOSGRUPO:" + rs.getString("GRUPONOME"));
				
			}
			
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
			String sqlBusca = "select * from GRUPO where PESSOAID = " + idPessoa + ";";
			
			ResultSet rs = stmt.executeQuery(sqlBusca);
		//	while(rs.next()){
		//		System.out.println(sqlBusca);
		//		System.out.printf("BUSCADADOSPESSOA:" + rs.getString("PESSOANOME"));
		//		break;
		//	}
		//	if(rs == null){
		//		System.out.println("RS TA NULL GI");
		//	}
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
			String sqlBusca = "select * from GRUPO where GRUPONOME = '" + nome + "';";
			
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

	public void alteraDados(int pessoa, int bar, String nome, String senha, int maximo, String hora, int idGrupo){
		
		connect banco = new connect();
		try{
			Connection exConn = (Connection) banco.abrirBDConn();
			Statement stmt = (Statement) exConn.createStatement();
			
			String sqlUpdate = "update GRUPO set PESSOAID = "+ pessoa +", BARID = "+ bar +", GRUPONOME = '"+ nome +"', GRUPOSENHA = '"+ senha +"',"
					+ " GRUPOMAX = "+ maximo +", GRUPOHORARIO = '"+ hora +"' where GRUPOID = " + idGrupo + ";";
			
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
