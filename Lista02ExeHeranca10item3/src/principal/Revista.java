package principal;

import java.time.LocalDate;

public class Revista extends ItemBiblioteca {

	public Revista(LocalDate dataEmprestimo, LocalDate dataPrevistaDevolucao, double valorMultaDia) {
		super(dataEmprestimo, dataPrevistaDevolucao, valorMultaDia);
	}

}
