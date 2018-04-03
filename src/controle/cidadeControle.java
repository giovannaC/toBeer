package controle;

import java.sql.ResultSet;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import classes.cidade;
import conexao.connect;

public class cidadeControle {

	public void insereDados(String nome, int estado){
		connect banco = new connect();
		try{
			Connection ExConn = (Connection)banco.abrirBDConn();
			Statement stmt = (Statement)ExConn.createStatement();
			boolean res = true;
			if(buscaId(nome, estado) == false){
				String sql = "insert into CIDADE (CIDADENOME, ESTADOID) values ('" + nome + "', " + estado + ");";
			
				System.out.println(sql);
			
				res = stmt.execute(sql);
				System.out.printf((!res)?"Dados inseridos com sucesso." :"" + "Os dados não puderam ser inseridos.");
			}else{
				System.out.printf((!res)?"Dados já inseridos com sucesso." :"" + "Os dados não puderam ser inseridos.");
			}
			
					
			stmt.close();
			banco.fecharBD();
		}
		
		catch(Exception e){
			System.out.printf("Os dados não puderam ser inseridos!! " + e.getMessage());
			
		}
	}
	
	public void excluiDados(int  id){
		
		connect banco = new connect();
		try{
			Connection exConn = (Connection) banco.abrirBDConn();
			Statement stmt = (Statement) exConn.createStatement();
			
			String sqlEnter = "set foreign_key_checks = 0;";
			stmt.execute(sqlEnter);
			String sqlDelete = "delete from CIDADE where CIDADEID = " + id + ";";
			
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
			String sqlBusca = "select * from CIDADE;";
			
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
			String sqlBusca = "select * from CIDADE where CIDADEID = "+ id +";";
			
			ResultSet rs = stmt.executeQuery(sqlBusca);
			while(rs.next()){
				System.out.printf("BUSCA CIDADE = " + rs.getString("CIDADENOME"));
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
			String sqlBusca = "select * from CIDADE where CIDADENOME = '" + nome + "';";
			
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

public boolean buscaId(String nome, int estado){
	int i = 0;
	boolean flag = false;
	connect banco = new connect();
	try{
		Connection exConn = (Connection) banco.abrirBDConn();
		Statement stmt = (Statement) exConn.createStatement();
		String sqlBusca = "select * from CIDADE where CIDADENOME =  '" + nome + "' AND ESTADOID = "+ estado +";";
		
		ResultSet rs = stmt.executeQuery(sqlBusca);
		while(rs.next()){
			System.out.println(rs.getInt(1));
			
			i =  rs.getInt(1);
			if(i > 0){
				flag = true;
			}
		}
		return flag;
	}
	catch(Exception e){
		System.out.println(e.getMessage());
		return flag;
	}
}

	public void alteraDados(String nome, int estado, cidade cidadeClass){
		
		connect banco = new connect();
		try{
			Connection exConn = (Connection) banco.abrirBDConn();
			Statement stmt = (Statement) exConn.createStatement();
			
			String sqlUpdate = "update CIDADE set CIDADENOME = '" + nome + "', ESTADOID = " + estado + " where CIDADEID = " + cidadeClass.getcidadeId() + ";";
			
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
