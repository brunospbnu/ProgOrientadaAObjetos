package principal;

import java.time.LocalDate;

public class Revista extends ItemBiblioteca {

	public Revista(LocalDate dataEmprestimo) {
		
		super(dataEmprestimo, dataEmprestimo.plusDays(7), 0.30);
	}

}
