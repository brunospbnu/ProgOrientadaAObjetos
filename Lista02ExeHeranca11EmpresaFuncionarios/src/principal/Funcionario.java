package principal;

public abstract class Funcionario {
	
	private String nome;
	private double salarioBase;
	
	public Funcionario(String nome, double salarioBase) throws IllegalArgumentException {
		setNome(nome);
		setSalarioBase(salarioBase);
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) throws IllegalArgumentException {
		if (nome.isBlank() || nome.length() < 3) {
			throw new IllegalArgumentException("O nome não pode estar em branco e deve ter 3 letras ou mais!!!");
		}
		this.nome = nome;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) throws IllegalArgumentException {
		if (salarioBase <=0) {
			throw new IllegalArgumentException(" O salário deve ser maior do que zero !!!");
		}
		this.salarioBase = salarioBase;
	}
	
	public abstract double calcularSalario();
	
}
