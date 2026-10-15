package Exceções;

public class Maior3CaracteresException extends IllegalArgumentException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Maior3CaracteresException(String nomeCampo) {
		super (nomeCampo + " deve ser maior do que 3 caracteres");
	}
}
