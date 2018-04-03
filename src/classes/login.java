package classes;

public class login {
	
	public int idLogin;
	public String telefoneLogin;

	public login(int codigo, String telefone) {
		idLogin = codigo;
		telefoneLogin = telefone;
	}
	
	public int getIdLogin(){
		return idLogin;
	}

	public void setIdLogin(int codigo){
		idLogin = codigo;
	}

	public String getTelefone(){
		return telefoneLogin;
	}

	public void setTelefone(String telefone){
		telefoneLogin = telefone;
	}
}
