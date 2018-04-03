package classes;

public class pessoa {
	
	public int idPessoa;
	public int idEndereco;
	public String nomePessoa;
	public String nascimentoPessoa;
	public String telPessoa;
	public String genPessoa;
	private String senhaPessoa;

	public pessoa() {
		// TODO Auto-generated constructor stub
	}

	public pessoa(int codigo, int endereco, String nome, String nascimento, String telefone, String genero, String senha){
		idPessoa = codigo;
		idEndereco = endereco;
		nomePessoa = nome;
		nascimentoPessoa = nascimento;
		telPessoa = telefone;
		genPessoa = genero;
		senhaPessoa = senha;
	}
	
	public int getIdPessoa(){
		return idPessoa;
	}

	public void setIdPessoa(int codigo){
		idPessoa = codigo;
	}
	
	public int getIdEndereco(){
		return idEndereco;
	}

	public void setIdEndereco(int endereco){
		idEndereco = endereco;
	}
	
	public String getNomePessoa(){
		return nomePessoa;
	}

	public void setNomePessoa(String nome){
		nomePessoa = nome;
	}
	
	public String getNascimentoPessoa(){
		return nascimentoPessoa;
	}

	public void setNascimentoPessoa(String nascimento){
		nascimentoPessoa = nascimento;
	}
	
	public String getTelPessoa(){
		return nascimentoPessoa;
	}

	public void setTelPessoa(String telefone){
		telPessoa = telefone;
	}

	public String getGenPessoa(){
		return genPessoa;
	}

	public void setGenPessoa(String genero){
		genPessoa = genero;
	}
	
	public String getSenhaPessoa(){
		return senhaPessoa;
	}

	public void setSenhaPessoa(String senha){
		senhaPessoa = senha;
	}
}
