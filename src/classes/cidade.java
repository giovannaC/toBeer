package classes;

/**
 * @author curso
 * @version 1.0
 * @created 01-jun-2017 15:12:54
 */
public class cidade extends estado {

	private int cidadeId;
	private String cidadeNome;
	private int estadoId;

	public cidade(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public int getcidadeId(){
		return cidadeId;
	}

	/**
	 * C�digo de Identifica��o do estado
	 */
	public int getestadoId(){
		return estadoId;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setcidadeId(int newVal){
		cidadeId = newVal;
	}

	/**
	 * C�digo de Identifica��o do estado
	 * 
	 * @param newVal
	 */
	public void setestadoId(int newVal){
		estadoId = newVal;
	}

	public String getcidadeNome(){
		return cidadeNome;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setcidadeNome(String newVal){
		cidadeNome = newVal;
	}

}