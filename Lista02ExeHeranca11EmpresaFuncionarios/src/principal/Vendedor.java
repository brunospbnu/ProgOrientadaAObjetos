package principal;

import java.util.List;

public class Vendedor extends Funcionario {
	
	private double percentualComissao;
	private List<Venda> vendas;

	public Vendedor(String nome, double salarioBase, double percentualComissao) throws IllegalArgumentException {
		super(nome, salarioBase);
		setPercentualComissao(percentualComissao);
	}

	
	public double getPercentualComissao() {
		return percentualComissao;
	}


	public void setPercentualComissao(double percentualComissao) throws IllegalArgumentException {
		if (percentualComissao <= 0) {
			throw new IllegalArgumentException("O percentual da comissão deve ser maior que zero !!!");
		}
		this.percentualComissao = percentualComissao;
	}

	public List<Venda> getVendas() {
		return vendas;
	}
	
	public void incluirVenda(Venda vendaRealizada) throws IllegalArgumentException {
		if (vendaRealizada == null) {
			throw new IllegalArgumentException("A venda não pode estar vazia !!!");
		}
		vendas.add(vendaRealizada);
	}
	
	@Override
	public double calcularSalario() {
		double salarioFinal = getSalarioBase();
		
		for (int i = 0; i < vendas.size(); i++) {
			salarioFinal += (vendas.get(i).getValor() * (getPercentualComissao() / 100));
		}
		
		return salarioFinal;
	}



}
