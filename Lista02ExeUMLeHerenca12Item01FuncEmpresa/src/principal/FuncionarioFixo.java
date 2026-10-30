package principal;

public class FuncionarioFixo extends Funcionario {
	
	private double salarioBase;
	
	public FuncionarioFixo(String nomeInformado, int matriculaInformada, double salarioBaseInformado) {
		super(nomeInformado, matriculaInformada);
		setSalarioBase(salarioBaseInformado);
	}

	
	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}
	
	
	@Override
	public double calcularSalario() {
		// TODO Auto-generated method stub
		return 0;
	}


	
}
