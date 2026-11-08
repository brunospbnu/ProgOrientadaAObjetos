package principal;

public abstract class Plantio {
	
	private String varidade;
	private int quantidadeMudas;
	
	public Plantio(String variedade, int quantidadeMudas) throws IllegalArgumentException {
		setVaridade(variedade);
		setQuantidadeMudas(quantidadeMudas);
	}

	public String getVaridade() {
		return varidade;
	}

	public void setVaridade(String varidade) {
		this.varidade = varidade;
	}

	public int getQuantidadeMudas() {
		return quantidadeMudas;
	}

	public void setQuantidadeMudas(int quantidadeMudas) throws IllegalArgumentException {
		if (quantidadeMudas <= 0) {
			throw new IllegalArgumentException("A quantidade de mudas deve ser maior que zero !!!");
		}
		this.quantidadeMudas = quantidadeMudas;
	}
	
	public abstract double calcularProducao();
}
