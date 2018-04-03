package controle;


import java.sql.ResultSet;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import conexao.connect;

public class enderecoControle {

	public void insereDados(int tipoLogradouro, int cidade, String enderecoLogradouro, int enderecoNumero, String enderecoComplemento, String enderecoBairro, String enderecoCep){
		
		connect banco = new connect();
		try{
			Connection ExConn = (Connection)banco.abrirBDConn();
			Statement stmt = (Statement)ExConn.createStatement();
			
			String sql = "insert into ENDERECO (TIPOLOGRADOUROID, CIDADEID, ENDERECOLOGRADOURO, ENDERECONUMERO, ENDERECOCOMPLEMENTO, ENDERECOBAIRRO, ENDERECOCEP) values "
					+ "("+ tipoLogradouro +", "+ cidade +", '"+ enderecoLogradouro +"', "+ enderecoNumero +", '"+ enderecoComplemento +"', '"+ enderecoBairro +"', '"+ enderecoCep +"');";
			
			
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
			
			String sqlEnter = "set foreign_key_checks = 0;";
			stmt.execute(sqlEnter);
			String sqlDelete = "delete from ENDERECO where ENDERECOID = " + id + ";";
			
			boolean rs = stmt.execute(sqlDelete);
			System.out.printf((!rs)?"Os dados foram excluidos com sucesso!!":"" + "Dados não foram excluidos com sucesso!!");
			
			stmt.close();
			banco.fecharBD();
		}
		catch(Exception e){
			System.out.printf("Os dados não foram encontrados!! "+e.getMessage());
		}
		
	}
	
	public ResultSet buscaDados(){
		
		connect banco = new connect();
		try{
			Connection exConn = (Connection) banco.abrirBDConn();
			Statement stmt = (Statement) exConn.createStatement();
			String sqlBusca = "select * from ENDERECO;";
			
			ResultSet rs = stmt.executeQuery(sqlBusca);
			
			return rs;
		}
		catch(Exception e){
			return null;
		}
	}
	
	public ResultSet buscaDados(int id){
		System.out.println("BUSCA DADOS DO ENDERECO");
		connect banco = new connect();
		try{
			Connection exConn = (Connection) banco.abrirBDConn();
			Statement stmt = (Statement) exConn.createStatement();
			String sqlBusca = "select * from ENDERECO where ENDERECOID = "+ id +";";
			System.out.println(sqlBusca);
			ResultSet rs = stmt.executeQuery(sqlBusca);
			while(rs.next()){
				System.out.printf(rs.getString("ENDERECOLOGRADOURO"));
			}
			return rs;
		}
		catch(Exception e){
			return null;
		}
	}
	
	public int buscaId(String enderecoLogradouro){
		int i = 0;
		connect banco = new connect();
		try{
			Connection exConn = (Connection) banco.abrirBDConn();
			Statement stmt = (Statement) exConn.createStatement();
			String sqlBusca = "select * from ENDERECO where ENDERECOLOGRADOURO = '" + enderecoLogradouro + "';";
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

	public void alteraDados(int tipoLogradouro, int cidade, String enderecoLogradouro, int enderecoNumero, String enderecoComplemento, String enderecoBairro, String enderecoCep, int idEndereco){
		
		connect banco = new connect();
		try{
			Connection exConn = (Connection) banco.abrirBDConn();
			Statement stmt = (Statement) exConn.createStatement();
			
			String sqlEnter = "set foreign_key_checks = 0;";
			stmt.execute(sqlEnter);
			String sqlUpdate = "update ENDERECO set TIPOLOGRADOUROID = "+ tipoLogradouro +", CIDADEID ="+ cidade 
					+", ENDERECOLOGRADOURO = '"+ enderecoLogradouro +"', ENDERECONUMERO = "+ enderecoNumero 
					+", ENDERECOCOMPLEMENTO = '"+ enderecoComplemento +"', ENDERECOBAIRRO = '"+ enderecoBairro 
					+"', ENDERECOCEP = '"+ enderecoCep +"' where ENDERECOID = " + idEndereco + ";";
			
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
