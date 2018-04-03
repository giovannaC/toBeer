package classes;

public class pub {
	
	public int idBar;
	public String nomeBar;
	public int idEndereco;
	public String openBar;
	public String closeBar;
	public String descricaoBar;
	public float classBar;
	public String telefoneBar;
	public String senhaBar;

	public pub() {
		// TODO Auto-generated constructor stub
	}

	public pub(int codigo, String nome, int endereco, String open, String close, String descricao, float classificacao, String telefone, String senha) {
		idBar = codigo;
		nomeBar = nome;
		idEndereco = endereco;
		openBar = open;
		closeBar = close;
		descricaoBar = descricao;
		classBar = classificacao;
		telefoneBar = telefone;
		senhaBar = senha;
	}
	
	public int getIdBar(){
		return idBar;
	}

	public void setIdBar(int codigo){
		idBar = codigo;
	}
	
	public String getNomeBar(){
		return nomeBar;
	}

	public void setNomeBar(String nome){
		nomeBar = nome;
	}
	
	public int getIdEndereco(){
		return idEndereco;
	}

	public void setIdEndereco(int codigo){
		idEndereco = codigo;
	}
	
	public String getOpenBar(){
		return openBar;
	}

	public void setOpenBar(String open){
		openBar = open;
	}
	
	public String getCloseBar(){
		return closeBar;
	}

	public void setCloseBar(String close){
		closeBar = close;
	}
	
	public String getDescricaoBar(){
		return descricaoBar;
	}

	public void setDescricaoBar(String descricao){
		descricaoBar = descricao;
	}
	
	public float getClassBar(){
		return classBar;
	}

	public void setClassBar(float classificacao){
		classBar = classificacao;
	}
	
	public String getTelefoneBar(){
		return telefoneBar;
	}

	public void setTelefoneBar(String telefone){
		telefoneBar = telefone;
	}
	
	public String getSenhaBar(){
		return senhaBar;
	}

	public void setSenhaBar(String senha){
		senhaBar = senha;
	}
}
