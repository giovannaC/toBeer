package classes;

public class grupo {
	
	public int idGrupo;
	public int idPessoa;
	public String nomeGrupo;
	public String senhaGrupo;
	public int maxGrupo;
	public String horaGrupo;

	public grupo() {
		// TODO Auto-generated constructor stub
	}
	
	public grupo(int codigo, int pessoa, String nome, String senha, int maximo, String hora) {
		idGrupo = codigo;
		idPessoa = pessoa;
		nomeGrupo = nome;
		senhaGrupo = senha;
		maxGrupo = maximo;;
		horaGrupo = hora;
	}

	public int getIdGrupo(){
		return idGrupo;
	}

	public void setIdGrupo(int codigo){
		idGrupo = codigo;
	}
	
	public int getIdPessoa(){
		return idPessoa;
	}

	public void setIdPessoa(int pessoa){
		idPessoa = pessoa;
	}
	
	public String getNomeGrupo(){
		return nomeGrupo;
	}

	public void setNomeGrupo(String nome){
		nomeGrupo = nome;
	}
	
	public String getSenhaGrupo(){
		return senhaGrupo;
	}

	public void setSenhaGrupo(String senha){
		senhaGrupo = senha;
	}
	
	public int getMaxGrupo(){
		return maxGrupo;
	}

	public void setMaxGrupo(int maximo){
		maxGrupo = maximo;
	}
	
	public String getHoraGrupo(){
		return horaGrupo;
	}

	public void setHoraGrupo(String hora){
		horaGrupo = hora;
	}
	
}


