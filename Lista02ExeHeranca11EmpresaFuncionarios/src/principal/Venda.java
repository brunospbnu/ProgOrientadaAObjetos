package principal;

public class Venda {
	
	private double valor;
	
	public Venda(double valor) throws IllegalArgumentException {
		setValor(valor);
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) throws IllegalArgumentException {
		if (valor <= 0) {
			throw new IllegalArgumentException("O valor da venda deve ser maior que zero !!!");
		}
		this.valor = valor;
	}
	
	
}
