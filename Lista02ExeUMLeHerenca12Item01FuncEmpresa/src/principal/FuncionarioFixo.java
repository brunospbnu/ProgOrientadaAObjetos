package principal;

public class FuncionarioFixo extends Funcionario {
	
	private double salarioBase;
	
	public FuncionarioFixo(String nomeInformado, int matriculaInformada, double salarioBaseInformado) throws IllegalArgumentException {
		super(nomeInformado, matriculaInformada);
		setSalarioBase(salarioBaseInformado);
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
	
	
	@Override
	public double calcularSalario() {
		double salario = getSalarioBase();
		return salario;
	}


	
}
