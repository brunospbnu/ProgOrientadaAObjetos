package principal;

import java.time.LocalDate;

public class Dvd extends ItemBiblioteca {
	

	public Dvd(LocalDate dataEmprestimo) {
		
		super(dataEmprestimo, LocalDate.now().plusDays(3), 1.20);
		
	}
	
}
