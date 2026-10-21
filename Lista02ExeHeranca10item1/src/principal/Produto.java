package principal;

public class Produto {

	private String nome;
	private double preco;
	private int mesesGarantia;

	public Produto(String nome, double preco, int mesesGarantia) {
		setNome(nome);
		setPreco(preco);
		setMesesGarantia(mesesGarantia);
	}

	public void setNome(String nome) throws IllegalArgumentException {
		if (nome == null || nome.isBlank()) {
			throw new IllegalArgumentException("Nome deve ser preenchido.");
		}
		this.nome = nome;
	}

	public void setPreco(double preco) throws ValorMenorZeroException {
		if (preco < 0) {
			throw new ValorMenorZeroException("Preço");
		}
		this.preco = preco;
	}

	public void setMesesGarantia(int mesesGarantia) throws ValorMenorZeroException {
		if (mesesGarantia < 0) {
			throw new ValorMenorZeroException("Quantidade de meses para garantia");
		}
		this.mesesGarantia = mesesGarantia;
	}

	public double getPreco() {
		return preco;
	}

	public int getMesesGarantia() {
		return mesesGarantia;
	}

	public String getNome() {
		return nome;
	}
	
	

}
