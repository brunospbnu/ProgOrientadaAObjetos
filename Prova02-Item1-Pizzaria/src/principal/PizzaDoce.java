package principal;

public class PizzaDoce extends Pizza {

	private double cobertura;
	
	public PizzaDoce(String nome, double base, double cobertura) {
		super(nome, base);
		setCobertura(cobertura);
	}

	public double getCobertura() {
		return cobertura;
	}

	public void setCobertura(double cobertura) {
		this.cobertura = cobertura;
	}

	@Override
	public double calcularPreco() {
		double preco = getPrecoBase() + getCobertura();
		return preco;
	}

}
