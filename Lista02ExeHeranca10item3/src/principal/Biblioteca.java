package principal;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
	private List<ItemBiblioteca> emprestimos;
	
	public Biblioteca() {
		setEmprestimos(new ArrayList<ItemBiblioteca>());
	}

	public List<ItemBiblioteca> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<ItemBiblioteca> emprestimos) {
		this.emprestimos = emprestimos;
	}
	
	public void addEmprestimo() {
		
		//TODO fazer metodo.
	}
	
	public String listarEmprestimos() {
		String texto = "";
		
		//TODO fazer listagem em texto.
		
		return texto;
	}
	
	public double devolucao() {
		double multaDevida = 0;
		
		//TODO fazer metodo.
		
		return multaDevida;
	}
	
}
