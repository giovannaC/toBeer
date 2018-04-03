package classes;


public class endereco {

	public int idEndereco;
	public int idTipoLogradouro;
	public String enderecoLogradouro;
	public int enderecoNumero;
	public String bairro;
	public int idCidade;
	public String enderecoComplemento;
	public String cep;

	public endereco() {
		// TODO Auto-generated constructor stub
	}

	public endereco(int codigo, int logradouro, String nome, int num, String obairro, int cidade, String ocomplemento, String ocep ){
		idEndereco = codigo;
		idTipoLogradouro = logradouro;
		enderecoLogradouro = nome;
		enderecoNumero = num;
		bairro = obairro;
		idCidade = cidade;
		enderecoComplemento = ocomplemento;
		cep = ocep;
		

	}

	public int getIdEndereco(){
		return idEndereco;
	}

	public void setIdEndereco(int codigo){
		idEndereco = codigo;
	}

	public int getIdTipoLogradouro(){
		return idTipoLogradouro;
	}

	public void setIdTipoLogradouro(int logradouro){
		idTipoLogradouro = logradouro;
	}

	public String getEnderecoLogradouro(){
		return enderecoLogradouro;
	}

	public void setEnderecoLogradouro(String nome){
		enderecoLogradouro = nome;
	}

	public int getEnderecoNumero(){
		return enderecoNumero;
	}

	public void setEnderecoNumero(int num){
		enderecoNumero = num;
	}

	public String getBairro(){
		return bairro;
	}

	public void setBairro(String obairro){
		bairro = obairro;
	}

	public int getIdCidade(){
		return idCidade;
	}

	public void setIdCidade(int cidade){
		idCidade = cidade;
	}

	public String getEnderecoComplemento(){
		return enderecoComplemento;
	}

	public void setEnderecoComplemento(String ocomplemento){
		enderecoComplemento = ocomplemento;
	}

	public String getCep(){
		return cep;
	}

	public void setCep(String ocep){
		cep = ocep;
	}


}
