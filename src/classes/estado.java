package classes;

/**
 * @author curso
 * @version 1.0
 * @created 01-jun-2017 15:12:36
 */
public class estado {

	/**
	 * C�digo de Identifica��o do estado
	 */
	private int estadoId;
	private String estadoNome;
	private String estadoSigla;

	public estado(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * C�digo de Identifica��o do estado
	 */
	public int getestadoId(){
		return estadoId;
	}

	/**
	 * C�digo de Identifica��o do estado
	 * 
	 * @param newVal
	 */
	public void setestadoId(int newVal){
		estadoId = newVal;
	}

	public String getestadoNome(){
		return estadoNome;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setestadoNome(String newVal){
		estadoNome = newVal;
	}

	public String getestadoSigla(){
		return estadoSigla;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setestadoSigla(String newVal){
		estadoSigla = newVal;
	}

}