package principal;

public abstract class Pizza {
	
	private String nome;
	private double precoBase;
	
	public Pizza(String nome, double base) {
		setNome(nome);
		setPrecoBase(base);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPrecoBase() {
		return precoBase;
	}

	public void setPrecoBase(double precoBase) {
		this.precoBase = precoBase;
	}
	
	public abstract double calcularPreco();
	
}
