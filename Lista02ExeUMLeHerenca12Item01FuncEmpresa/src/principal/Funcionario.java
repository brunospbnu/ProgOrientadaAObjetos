package principal;

public abstract class Funcionario {
	
	private String nome;
	private int matricula;
	
	public Funcionario(String nomeInformado, int matriculaInformada) throws IllegalArgumentException {
		setNome(nomeInformado);
		setMatricula(matriculaInformada);
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) throws IllegalArgumentException {
		if (nome == null || nome.isBlank() || nome.length() < 3) {
			throw new IllegalArgumentException("O nome não pode estar em branco e deve ter 3 letras ou mais!!!");
		}
		this.nome = nome;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula)  throws IllegalArgumentException {
		if (matricula <= 0) {
			throw new IllegalArgumentException("O número de matrícula deve ser maior que 0 !!!");
		}
		this.matricula = matricula;
	}
	
	
	public String exibirDados() {
		String texto = "Nome: " + nome + " - Matrícula: " + matricula + " - Salário: R$ " + calcularSalario();
		return texto;
	}
	
	
	public abstract double calcularSalario();
	
	
}
