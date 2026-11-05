package principal;

public class PizzaSalgada extends Pizza {

	private double bordaRecheada;
	
	public PizzaSalgada(String nome, double base, double borda) {
		super(nome, base);
		setBordaRecheada(borda);
	}

	public double getBordaRecheada() {
		return bordaRecheada;
	}

	public void setBordaRecheada(double bordaRecheada) {
		this.bordaRecheada = bordaRecheada;
	}

	@Override
	public double calcularPreco() {
		double preco = getPrecoBase() + getBordaRecheada();
		return preco;
	}
	
}
