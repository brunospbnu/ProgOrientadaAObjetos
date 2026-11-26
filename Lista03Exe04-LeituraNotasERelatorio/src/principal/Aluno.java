package principal;

public class Aluno {
	private String nome;
	private double nota;
	private boolean aprovado;
	
	public Aluno(String nome, double nota) throws IllegalArgumentException {
		setNome(nome);
		setNota(nota);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) throws IllegalArgumentException {
		if (nota < 0 || nota > 10) {
			throw new IllegalArgumentException("Nota informada inválida");
		}
		this.nota = nota;
	}

	public boolean isAprovado() {
		return aprovado;
	}

	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}
}
