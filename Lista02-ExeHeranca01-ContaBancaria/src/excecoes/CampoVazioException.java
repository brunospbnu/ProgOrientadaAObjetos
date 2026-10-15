package excecoes;

public class CampoVazioException extends IllegalArgumentException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CampoVazioException(String nomeCampo) {
		super (nomeCampo + " não pode estar vazio");
	}
	
}
