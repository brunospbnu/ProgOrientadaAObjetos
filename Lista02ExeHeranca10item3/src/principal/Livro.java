package principal;

import java.time.LocalDate;

public class Livro extends ItemBiblioteca {

	public Livro(LocalDate dataEmprestimo, LocalDate dataPrevistaDevolucao, double valorMultaDia) {
		super(dataEmprestimo, dataPrevistaDevolucao, valorMultaDia);
	}
	
}
