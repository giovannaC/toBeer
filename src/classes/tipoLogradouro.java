package classes;

public class tipoLogradouro {
	
	public int idTipoLogradouro;
	public String nomeTipoLogradouro;

	public tipoLogradouro() {
		// TODO Auto-generated constructor stub
	}

	public tipoLogradouro(int codigo, String nome) {
		idTipoLogradouro = codigo;
		nomeTipoLogradouro = nome;
	}
	
	public int getIdTipoLogradouro(){
		return idTipoLogradouro;
	}

	public void setIdTipoLogradouro(int codigo){
		idTipoLogradouro = codigo;
	}
	
	public String getNomeTipoLogradouro(){
		return nomeTipoLogradouro;
	}

	public void setNomeTipoLogradouro(String nome){
		nomeTipoLogradouro = nome;
	}
	
}
