package controle;

import java.sql.ResultSet;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import conexao.connect;


public class pessoaControle {
	
	public void insereDados(int endereco, String nome, String nascimento, String telefone, String genero, String senha){
		
		connect banco = new connect();
		try{
			Connection ExConn = (Connection)banco.abrirBDConn();
			Statement stmt = (Statement)ExConn.createStatement();
			
			String sql = "insert into PESSOA (ENDERECOID, PESSOANOME, PESSOADATANASCIMENTO, PESSOATELEFONE, PESSOAGENERO, PESSOASENHA) values "
					+ "("+ endereco +", '" + nome + "', '" + nascimento + "', '"+ telefone +"', '"+ genero +"', '"+ senha +"');";
			
			
			System.out.println(sql);
			
			boolean res = stmt.execute(sql);
			System.out.printf((!res)?"Dados inseridos com sucesso." :"" + "Os dados não puderam ser inseridos.");
			
			stmt.close();
			banco.fecharBD();
			
		}
		
		catch(Exception e){
			System.out.printf(e.getMessage());
			
		}
	}
	
	public void excluiDados(int  id){
		
		connect banco = new connect();
		try{
			Connection exConn = (Connection) banco.abrirBDConn();
			Statement stmt = (Statement) exConn.createStatement();
			
			String sqlDelete = "delete from PESSOA where PESSOAID = " + id + ";";
			
			boolean rs = stmt.execute(sqlDelete);
			System.out.printf((!rs)?"Os dados foram excluidos com sucesso!!":"" + "Dados não foram excluidos com sucesso!!");
			
			stmt.close();
			banco.fecharBD();
		}
		catch(Exception e){
			System.out.printf("Os dados não foram encontrados!! " + e.getMessage());
		}
		
	}
	
	public ResultSet buscaDados(){
		
		connect banco = new connect();
		try{
			Connection exConn = (Connection) banco.abrirBDConn();
			Statement stmt = (Statement) exConn.createStatement();
			String sqlBusca = "select * from PESSOA;";
			
			ResultSet rs = stmt.executeQuery(sqlBusca);
			
			return rs;
		}
		catch(Exception e){
			return null;
		}
	}
	
public ResultSet buscaDados(int idPessoa){
		
		connect banco = new connect();
		try{
			Connection exConn = (Connection) banco.abrirBDConn();
			Statement stmt = (Statement) exConn.createStatement();
			String sqlBusca = "select * from PESSOA where PESSOAID = "+ idPessoa +";";
			
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
			String sqlBusca = "select * from PESSOA where PESSOANOME = '" + nome + "';";
			
			ResultSet rs = stmt.executeQuery(sqlBusca);
			while(rs.next()){
				System.out.printf(" " + rs.getInt(1));
				
				i =  rs.getInt(1);
			}
			return i;

		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return -1;
		}
	}

	
	public ResultSet buscaDados(String telefone){
		connect banco = new connect();
		try{
			Connection exConn = (Connection) banco.abrirBDConn();
			Statement stmt = (Statement) exConn.createStatement();
			String sqlBusca = "select * from PESSOA where PESSOATELEFONE = '" + telefone + "';";
			
			ResultSet rs = stmt.executeQuery(sqlBusca);
			while(rs.next()){
				System.out.println(sqlBusca);
				System.out.printf("BUSCADADOSPESSOA:" + rs.getString("PESSOANOME"));
				
			}
			return rs;

		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public boolean loginPessoa(String telefone, String senha){
		int i = 0;
		boolean flag = false;
		connect banco = new connect();
		try{
			Connection exConn = (Connection) banco.abrirBDConn();
			Statement stmt = (Statement) exConn.createStatement();
			String sqlBusca = "select * from PESSOA where PESSOATELEFONE = '" + telefone + "' AND PESSOASENHA = '"+ senha +"';";
			
			ResultSet rs = stmt.executeQuery(sqlBusca);
			while(rs.next()){
				System.out.printf("LOGINPESSOA = "+ rs.getInt(1));
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

	public void alteraDados(int endereco, String nome, String nascimento, String telefone, String genero, String senha, int idPessoa){
		
		connect banco = new connect();
		try{
			Connection exConn = (Connection) banco.abrirBDConn();
			Statement stmt = (Statement) exConn.createStatement();
			
			String sqlEnter = "set foreign_key_checks = 0;";
			stmt.execute(sqlEnter);
			String sqlUpdate = "update PESSOA set ENDERECOID = "+ endereco +", PESSOANOME = '"+ nome +"', PESSOADATANASCIMENTO = '"+ nascimento +"'"
					+ ", PESSOATELEFONE = '"+ telefone +"', PESSOAGENERO = '"+ genero +"', PESSOASENHA = '"+ senha +"' where PESSOAID = " + idPessoa + ";";
			
			int retorno = stmt.executeUpdate(sqlUpdate);
			
			if(retorno == 1){
				System.out.printf("Dados atualizados!");
			}
			
			stmt.close();
			banco.fecharBD();
		}
		catch(Exception e){
			System.out.printf( "Dados não atualizados!!");
		}
	}

}
