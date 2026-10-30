package principal;

public abstract class Funcionario {
	
	private String nome;
	private int matricula;
	
	public Funcionario(String nomeInformado, int matriculaInformada) {
		setNome(nomeInformado);
		setMatricula(matriculaInformada);
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	
	public String exibirDados() {
		String texto = "";
		
		//TODO fazer metodo.
		
		return texto;
	}
	
	
	public abstract double calcularSalario();
	
	
}
