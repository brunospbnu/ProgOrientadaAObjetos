package principal;

public class Produto {
	
	private int codigo;
	private int qntDisponivel;
	private double preco;
	
	public Produto(int codigo, int quantidade, double preco) throws IllegalArgumentException {
		setCodigo(codigo);
		setQntDisponivel(quantidade);
		setPreco(preco);
	}

	
	// GETS E SETS -----------------------
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getQntDisponivel() {
		return qntDisponivel;
	}

	public void setQntDisponivel(int quantidade) throws IllegalArgumentException {
		if (quantidade < 0) {
			throw new IllegalArgumentException("A quantidade disponível não pode ser menor que zero !!!");
		}
		this.qntDisponivel = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) throws IllegalArgumentException {
		if (preco <= 0) {
			throw new IllegalArgumentException("O preço não pode ser igual e nem menor que zero !!!");
		}
		this.preco = preco;
	}
	
	
	// DEMAIS METODOS:
	
	
	public void addProduto(int qntAdicionar) throws IllegalArgumentException {
		if (qntAdicionar < 1) {
			throw new IllegalArgumentException("Não pode ser adicionado menos que 1 produto");
		}
		qntDisponivel += qntAdicionar;
	}
	
	public void removerProduto(int qntRemover) throws IllegalArgumentException {
		if (qntRemover < 1) {
			throw new IllegalArgumentException("Não pode ser removido menos que 1 produto");
		}
		qntDisponivel -= qntRemover;
	}
	
	
}
