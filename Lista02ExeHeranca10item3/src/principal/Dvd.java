package principal;

import java.time.LocalDate;

public class Dvd extends ItemBiblioteca {
	

	public Dvd(LocalDate dataEmprestimo) {
		
		super(dataEmprestimo, dataEmprestimo.plusDays(3), 1.20);
		
	}
	
}
