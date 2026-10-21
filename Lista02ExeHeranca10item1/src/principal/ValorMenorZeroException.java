package principal;

public class ValorMenorZeroException extends IllegalArgumentException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ValorMenorZeroException(String campo) {
		super(campo + " deve ser maior ou igual a zero.");
	}

}