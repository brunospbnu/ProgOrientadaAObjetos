package principal;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
	
	private List<Funcionario> funcionarios;

	
	public Empresa() throws IllegalArgumentException {
		funcionarios = new ArrayList<Funcionario>();
	}
	
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) throws IllegalArgumentException {
		if (funcionarios == null) {
			throw new IllegalArgumentException("A lista não pode estar vazia !!!");
		}
		this.funcionarios = funcionarios;
	}
	
	public void addFuncionario(Funcionario funcInformado) throws IllegalArgumentException {
		if (funcInformado == null) {
			throw new IllegalArgumentException("O funcionário não pode ser nulo !!!");
		}
		funcionarios.add(funcInformado);
	}
	
	public String exibirDadosTodos() {
		String texto = "Lista de todos os funcionários: \n";
		for (Funcionario funcionario : funcionarios) {
			texto += funcionario.exibirDados() + "\n";
		}
		if (funcionarios.isEmpty()) {
			texto += "\n\n A lista de funcionários está vazia !!! \n";
		}
		texto += "\n Fim da Lista !!!";
		return texto;
	}
	
	public double calcularTotalFolha() throws IllegalArgumentException {
		double total = 0;
		if (funcionarios.isEmpty()) {
			throw new IllegalArgumentException("Não há funcionários cadastrados !!!");
		}
		for (Funcionario funcionario : funcionarios) {
			total += funcionario.calcularSalario();
		}
		return total;
	}
	
	
}
