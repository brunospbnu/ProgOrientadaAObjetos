package principal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TesteProjeto {

	@Test
	void testarProduto() {
		Produto p = new Produto ("Nome", 20, 4);
		assertEquals(p.getNome(), "Nome");
		assertEquals(p.getPreco(), 20);
		assertEquals(p.getMesesGarantia(), 4);
	}
	
	@Test
	void testarSmartphone() {
		//aqui não passamos o nome para o construtor pois a classe que foi feita não pede o nome, ela coloca direto como "Smartphone".
		Smartphone s = new Smartphone(1000, 4, 250, true);
		assertEquals(s.getNome(), "Smartphone");
		assertEquals(s.getPreco(), 1000);
		assertEquals(s.getMesesGarantia(), 4);
		assertEquals(s.getArmazenamento(), 250);
		assertTrue(s.isBanda5G());
		
		s.setArmazenamento(256);
		assertEquals(s.getMesesGarantia(), 7);
		assertEquals(s.desconto(), 50);
		assertEquals(s.precoComDesconto(), 950);
	}
	
	void testarNotebook() {
		Notebook n = new Notebook("Notebook", 5000, 3, 10, false);
		assertEquals(n.getNome(), "Notebook");
		assertEquals(n.getPreco(), 5000);
		assertEquals(n.getMesesGarantia(), 3);
		assertEquals(n.getRam(), 10);
		assertTrue(n.isSsd());
		
	}

}
