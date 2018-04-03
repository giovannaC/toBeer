package controle;

import java.sql.ResultSet;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import conexao.connect;

public class pubControle {

	public void insereDados(String nome, int endereco, String open, String close, String descricao, float classificacao, String telefone, String senha){
		
		connect banco = new connect();
		try{
			Connection ExConn = (Connection)banco.abrirBDConn();
			Statement stmt = (Statement)ExConn.createStatement();
			
			String sql = "insert into BAR (ENDERECOID, BARNOME, BAROPEN, BARCLOSE, BARDESCRICAO, BARCLASSIFICACAO, BARTELEFONE, BARSENHA) values"
					+ " ("+ endereco +", '"+ nome +"', '"+ open +"', '"+ close +"', '"+ descricao +"', '"+ classificacao +"', '"+ telefone +"', '"+ senha +"');";
			
			
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
			
			String sqlDelete = "delete from BAR where BARID = " + id + ";";
			
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
			String sqlBusca = "select * from BAR;";
			
			ResultSet rs = stmt.executeQuery(sqlBusca);
			
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
			String sqlBusca = "select * from BAR where BARTELEFONE = '" + telefone + "';";
			
			ResultSet rs = stmt.executeQuery(sqlBusca);
		//	while(rs.next()){
		//		System.out.println(sqlBusca);
		//		System.out.printf("BUSCADADOSPESSOA:" + rs.getString("PESSOANOME"));
		//		
		//	}
			return rs;
		}
		catch(Exception e){
			return null;
		}
	}
	
	public ResultSet buscaDadosId(int idBar){
		
		connect banco = new connect();
		try{
			Connection exConn = (Connection) banco.abrirBDConn();
			Statement stmt = (Statement) exConn.createStatement();
			String sqlBusca = "select * from BAR where BARID = " + idBar + ";";
			
			ResultSet rs = stmt.executeQuery(sqlBusca);
			while(rs.next()){
				System.out.println(sqlBusca);
				System.out.printf("BUSCADADOSID:" + rs.getString("BARNOME"));
				
			}
			return rs;
		}
		catch(Exception e){
			return null;
		}
	}
	
	public ResultSet buscaDadosNome(String nome){
		
		connect banco = new connect();
		try{
			Connection exConn = (Connection) banco.abrirBDConn();
			Statement stmt = (Statement) exConn.createStatement();
			String sqlBusca = "select * from BAR where BARNOME = '" + nome + "';";
			
			ResultSet rs = stmt.executeQuery(sqlBusca);

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
			String sqlBusca = "select * from BAR where BARNOME = '" + nome + "';";
			
			ResultSet rs = stmt.executeQuery(sqlBusca);
			
			while(rs.next()){
				System.out.println(sqlBusca);	
				i =  rs.getInt(1);
			}
			
			return i;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return -1;
		}
	}
	
	public boolean loginBar(String telefone, String senha){
		int i = 0;
		boolean flag = false;
		connect banco = new connect();
		try{
			Connection exConn = (Connection) banco.abrirBDConn();
			Statement stmt = (Statement) exConn.createStatement();
			String sqlBusca = "select * from BAR where BARTELEFONE = '" + telefone + "' AND BARSENHA = '"+ senha +"';";
			
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
	
	
	public void alteraDados(String nome, int endereco, String open, String close, String descricao, float classificacao, String telefone, String senha, int idBar){
		
		connect banco = new connect();
		try{
			Connection exConn = (Connection) banco.abrirBDConn();
			Statement stmt = (Statement) exConn.createStatement();
			
			String sqlEnter = "set foreign_key_checks = 0;";
			stmt.execute(sqlEnter);
			String sqlUpdate = "update BAR set BARNOME = '" + nome + "', ENDERECOID = "+ endereco +", BAROPEN = '"+ open +"', BARCLOSE = '"+ close +"',"
					+ " BARDESCRICAO = '"+ descricao +"', BARCLASSIFICACAO = '"+ classificacao +"', BARTELEFONE = '"+ telefone 
					+"', BARSENHA = '"+ senha +"' where BARID = " + idBar + ";";
			
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
