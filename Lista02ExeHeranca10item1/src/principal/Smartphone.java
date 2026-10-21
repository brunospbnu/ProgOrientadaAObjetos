package principal;

public class Smartphone extends Produto {

	private int armazenamento;
	private boolean banda5G;

	public Smartphone(double preco, int mesesGarantia, int armazenamento, boolean banda5G) {
		super("Smartphone", preco, mesesGarantia);
		setArmazenamento(armazenamento);
		setBanda5G(banda5G);
	}

	public void setArmazenamento(int armazenamento) {
		if (armazenamento < 0) {
			throw new ValorMenorZeroException("Armazenamento");
		}
		this.armazenamento = armazenamento;
	}

	public void setBanda5G(boolean banda5g) {
		banda5G = banda5g;
	}

	public boolean isBanda5G() {
		return banda5G;
	}

	public int getArmazenamento() {
		return armazenamento;
	}
	
	@Override
	public double desconto() {
		if (banda5G) {
			return getPreco() * 0.05; 
		}
		return 0;
	}
	
	public double precoComDesconto() {
		if (banda5G) {
			return getPreco() * 0.95; 
		}
		return getPreco();
	}
	
	@Override
	public int getMesesGarantia() {
		if (this.armazenamento >= 256) {
			return super.getMesesGarantia() + 3;
		}
		return super.getMesesGarantia();
	}
}

