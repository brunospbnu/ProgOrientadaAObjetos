package principal;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class TesteProjeto {

	@Test
	void cadastroItens() {
		LocalDate data = LocalDate.parse("2026-10-26");
		
		Livro l1 = new Livro(data);
		Revista r1 = new Revista(data);
		Dvd d1 = new Dvd(data);
		
		//teste do livro 1:
		
		//Data Emprestimo:
		assertEquals(LocalDate.parse("2026-10-26"), l1.getDataEmprestimo());
		//Data Prevista para devolução:
		assertEquals(LocalDate.parse("2026-11-09"), l1.getDataPrevistaDevolucao());
		//Valor da multa por dia
		assertEquals(0.75, l1.getValorMultaDia());
		
		//teste da revista 1:
		
		//Data Emprestimo:
		assertEquals(LocalDate.parse("2026-10-26"), r1.getDataEmprestimo());
		//Data Prevista para devolução:
		assertEquals(LocalDate.parse("2026-11-02"), r1.getDataPrevistaDevolucao());
		//Valor da multa por dia
		assertEquals(0.30, r1.getValorMultaDia());
		
		//teste do dvd1
		
		//Data Emprestimo:
		assertEquals(LocalDate.parse("2026-10-26"), d1.getDataEmprestimo());
		//Data Prevista para devolução:
		assertEquals(LocalDate.parse("2026-10-29"), d1.getDataPrevistaDevolucao());
		//Valor da multa por dia
		assertEquals(1.20, d1.getValorMultaDia());
	}
	
	
	@Test
	void ItensLista() {
		LocalDate data = LocalDate.parse("2026-10-26");
		
		Livro l1 = new Livro(data);
		Revista r1 = new Revista(data);
		Dvd d1 = new Dvd(data);
		
		Biblioteca b = new Biblioteca();
		
		b.addEmprestimo(d1);
		b.addEmprestimo(r1);
		b.addEmprestimo(l1);
		
		
		assertEquals(d1, b.getEmprestimos().get(0));
		assertEquals(r1, b.getEmprestimos().get(1));
		assertEquals(l1, b.getEmprestimos().get(2));
		
	}
	
	
	@Test
	void listarItensString() {
		LocalDate data = LocalDate.parse("2026-10-26");
		
		Livro l1 = new Livro(data);
		Revista r1 = new Revista(data);
		Dvd d1 = new Dvd(data);
		
		Biblioteca b = new Biblioteca();
		
		b.addEmprestimo(d1);
		b.addEmprestimo(r1);
		b.addEmprestimo(l1);
		
		// System.out.println(b.listarEmprestimos());
		
		assertEquals("Lista de emprestimos: \n"
				+ " Item: Dvd - Data do emprestimo: 26/10/2026 - Data Prevista para Devolução: 29/10/2026 - Valor da multa por dia: R$ 1.2\n"
				+ " Item: Revista - Data do emprestimo: 26/10/2026 - Data Prevista para Devolução: 02/11/2026 - Valor da multa por dia: R$ 0.3\n"
				+ " Item: Livro - Data do emprestimo: 26/10/2026 - Data Prevista para Devolução: 09/11/2026 - Valor da multa por dia: R$ 0.75\n"
				+ " Fim da lista !!!", b.listarEmprestimos());
	}
	
	
	@Test
	void testarAtrasosDevolucao() {
		LocalDate data = LocalDate.parse("2026-10-26");
		
		Livro l1 = new Livro(data);
		Revista r1 = new Revista(data);
		Dvd d1 = new Dvd(data);
		
		Biblioteca b = new Biblioteca();
		
		b.addEmprestimo(d1);
		b.addEmprestimo(r1);
		b.addEmprestimo(l1);
		
		// teste de DVD emprestado em 26/10/2026, Data Prevista para Devolução: 29/10/2026 ------ devolvido em 05/11/2026. 7 dias atraso. multa de 8,40
		LocalDate dataDevDvd = LocalDate.parse("2026-11-05");
		assertEquals(8.40, b.devolucao(d1, dataDevDvd));
		
		// teste de Revista emprestada em 26/10/2026, Data Prevista para Devolução: 02/11/2026 ----- devolvido em 05/11/2026. 3 dias de atraso. multa de 0.90
		LocalDate dataDevRev = LocalDate.parse("2026-11-05");
		assertEquals(0.8999999999999999, b.devolucao(r1, dataDevRev));
		
		// teste de Livro emprestado em 26/10/2026, Data Prevista para Devolução: 09/11/2026 ----- devolvido em 15/11/2026. 6 dias de atraso. multa de 4,5
		LocalDate dataDevLiv = LocalDate.parse("2026-11-15");
		assertEquals(4.5, b.devolucao(l1, dataDevLiv));
		
	}

}
