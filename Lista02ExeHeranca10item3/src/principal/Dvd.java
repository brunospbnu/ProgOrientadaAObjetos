package principal;

import java.time.LocalDate;

public class Dvd extends ItemBiblioteca {

	public Dvd(LocalDate dataEmprestimo, LocalDate dataPrevistaDevolucao, double valorMultaDia) {
		super(dataEmprestimo, dataPrevistaDevolucao, valorMultaDia);
	}
	
}
