package principal;

import java.time.LocalDate;

public class Livro extends ItemBiblioteca {

	public Livro(LocalDate dataEmprestimo) {
		
		super(dataEmprestimo, dataEmprestimo.plusDays(14), 0.75);
	}
	
}
