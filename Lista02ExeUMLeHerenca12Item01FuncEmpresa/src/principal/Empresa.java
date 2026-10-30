package principal;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
	
	private List<Funcionario> funcionarios;

	
	public Empresa() {
		funcionarios = new ArrayList<Funcionario>();
	}
	
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	public void addfuncionario() {
		//TODO fazer metodo.
	}
	
	public String exibirtDadosTodos() {
		String texto = "";
		
		//TODO fazer metodo.
		
		return texto;
	}
	
	public double calcularTotalFolha() {
		double total = 0;
		
		//TODO fazer metodo.
		
		return total;
	}
	
	
}
