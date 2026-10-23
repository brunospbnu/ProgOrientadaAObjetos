package principal;

import java.time.LocalDate;

public class Livro extends ItemBiblioteca {

	public Livro(LocalDate dataEmprestimo) {
		
		super(dataEmprestimo, LocalDate.now().plusDays(14), 0.75);
	}
	
}
