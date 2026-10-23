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
	
}
