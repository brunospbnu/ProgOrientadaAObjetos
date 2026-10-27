package principal;

import java.util.List;

public class Empresa {
	
	private String nome;
	private List<Funcionario> funcionarios;
	
	public Empresa(String nome) throws IllegalArgumentException {
		setNome(nome);
	}
	
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) throws IllegalArgumentException {
		if (nome.isBlank() || nome.length() <= 3) {
			throw new IllegalArgumentException("O nome não pode estar em branco e deve ter mais de 3 letras !!!");
		}
		this.nome = nome;
	}
	
	public void incluirFuncionario(Funcionario f) throws IllegalArgumentException{
		if (f== null) {
			throw new IllegalArgumentException("O funcionario não pode ser nulo !!!");
		}
		funcionarios.add(f);
	}
	
	public void removerFuncionario(Funcionario f) throws IllegalArgumentException {
		if (f== null) {
			throw new IllegalArgumentException("O funcionario não pode ser nulo !!!");
		}
		
		boolean remover = funcionarios.remove(f);
		
		if (!remover) {
			throw new IllegalArgumentException("Item não encontrado!!!");
		}
		
	}
	
	public double calcularCustosSalarios() {
		double soma = 0;
		
		//TODO fazer esse metodo.
		
		return soma;
	}
	
	
	
}
