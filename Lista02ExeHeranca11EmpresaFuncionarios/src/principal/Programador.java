package principal;

import java.util.ArrayList;
import java.util.List;

public class Programador extends Funcionario{
	
	private List<String> linguagens;
	
	public Programador(String nome, double salarioBase) throws IllegalArgumentException {
		super(nome, salarioBase);
		linguagens = new ArrayList<String>();
	}
	
	
	public List<String> getLinguagens() {
		return linguagens;
	}
	
	public void incluirLinguagem(String lingInformada) throws IllegalArgumentException {
		if (lingInformada == null) {
			throw new IllegalArgumentException("A linguagem informada não pode estar vazia !!!");
		}
		linguagens.add(lingInformada);
	}
	
	public void removerLinguagem(String lingInformada) throws IllegalArgumentException {
		if (lingInformada == null) {
			throw new IllegalArgumentException("A linguagem informada não pode estar vazia !!!");
		}
		
		boolean remover = linguagens.remove(lingInformada);
		
		if (!remover) {
			throw new IllegalArgumentException("Item não encontrado!!!");
		}
	}


	@Override
	public double calcularSalario() {
		double salarioFinal = getSalarioBase();
		
		for (int i = 0; i < linguagens.size(); i++) {
			if (linguagens.get(i).equalsIgnoreCase("JAVA")) {
				salarioFinal += (getSalarioBase() * 0.20);
				return salarioFinal;
			}
		}
		return salarioFinal;
		
	}
	
	

}
