package principal;

public class FuncionarioComissionado extends Funcionario{

	private double salarioBase;
	private double totalVendas;
	private double percentualComissao;
	
	
	public FuncionarioComissionado(String nomeInformado, int matriculaInformada, double salarioBaseInformado, double totalVendasInfo, double percComissInfo) {
		super(nomeInformado, matriculaInformada);
		setSalarioBase(salarioBaseInformado);
		setTotalVendas(totalVendasInfo);
		setPercentualComissao(percComissInfo);
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public double getTotalVendas() {
		return totalVendas;
	}

	public void setTotalVendas(double totalVendas) {
		this.totalVendas = totalVendas;
	}

	public double getPercentualComissao() {
		return percentualComissao;
	}

	public void setPercentualComissao(double percentualComissao) {
		this.percentualComissao = percentualComissao;
	}
	
	@Override
	public double calcularSalario() {
		// TODO Auto-generated method stub
		return 0;
	}

}
