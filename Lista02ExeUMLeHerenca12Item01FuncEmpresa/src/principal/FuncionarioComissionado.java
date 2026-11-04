package principal;

public class FuncionarioComissionado extends Funcionario{

	private double salarioBase;
	private double totalVendas;
	private double percentualComissao;
	
	
	public FuncionarioComissionado(String nomeInformado, int matriculaInformada, double salarioBaseInformado, double totalVendasInfo, double percComissInfo) throws IllegalArgumentException {
		super(nomeInformado, matriculaInformada);
		setSalarioBase(salarioBaseInformado);
		setTotalVendas(totalVendasInfo);
		setPercentualComissao(percComissInfo);
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) throws IllegalArgumentException {
		if (salarioBase <=0) {
			throw new IllegalArgumentException("O salário deve ser maior do que zero !!!");
		}
		this.salarioBase = salarioBase;
	}

	public double getTotalVendas() {
		return totalVendas;
	}

	public void setTotalVendas(double totalVendas) throws IllegalArgumentException {
		if (totalVendas <=0) {
			throw new IllegalArgumentException("O total de vendas deve ser maior do que zero !!!");
		}
		this.totalVendas = totalVendas;
	}

	public double getPercentualComissao() {
		return percentualComissao;
	}

	public void setPercentualComissao(double percentualComissao) throws IllegalArgumentException {
		if (percentualComissao <= 0) {
			throw new IllegalArgumentException("O percentural de comissão deve ser maior do que zero !!!");
		}
		this.percentualComissao = percentualComissao /100;
	}
	
	@Override
	public double calcularSalario() {
		double salario = getSalarioBase() + (getTotalVendas() * getPercentualComissao());
		return salario;
	}

}
