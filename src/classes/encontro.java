package classes;

public class encontro {

	public int idBar;
	public int idPessoa;
	public int idGrupo; //se nao estiver em nenhum grupo esta variavel pode ser null(?)
	public String checkIn;
	public String checkOut;
	public String drive; //poderia se um boolean esse dirigir, e nao "sim" ou "nao"
	
	public encontro() {
		// TODO Auto-generated constructor stub
	}

	public encontro(int bar, int pessoa, int grupo, String in, String out, String dirigir) {
		idBar = bar;
		idPessoa = pessoa;
		idGrupo = grupo;
		checkIn = in;
		checkOut = out;
		drive = dirigir;
	}
	
	public int getIdBar(){
		return idBar;
	}

	public void setIdBar(int bar){
		idBar = bar;
	}
	
	public int getIdPessoa(){
		return idPessoa;
	}

	public void setIdPessoa(int pessoa){
		idPessoa = pessoa;
	}
	
	public int getIdGrupo(){
		return idGrupo;
	}

	public void setIdGrupo(int grupo){
		idGrupo = grupo;
	}
	
	public String getCheckIn(){
		return checkIn;
	}

	public void setCheckIn(String in){
		checkIn = in;
	}
	
	public String getCheckOut(){
		return checkOut;
	}

	public void setCheckOut(String out){
		checkOut = out;
	}
	
	public String getDrive(){
		return drive;
	}

	public void setDrive(String dirigir){
		drive = dirigir;
	}

}
