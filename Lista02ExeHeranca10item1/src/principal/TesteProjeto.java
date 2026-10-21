package principal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TesteProjeto {
	
	/*	@Test
		void testarProduto() {
		Produto p = new Produto ("Nome", 20, 4);
		assertEquals(p.getNome(), "Nome");
		assertEquals(p.getPreco(), 20);
		assertEquals(p.getMesesGarantia(), 4);
		}
	 */

	
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
	@Test
	void testarNotebook() {
		Notebook n = new Notebook("Notebook", 5000, 3, 10, false);
		assertEquals(n.getNome(), "Notebook");
		assertEquals(n.getPreco(), 5000);
		assertEquals(n.getMesesGarantia(), 3);
		assertEquals(n.getRam(), 10);
		assertTrue(!n.isSsd());
		
		n.setRam(16);
		n.setSsd(true);
		assertEquals(n.getMesesGarantia(), 9);
		assertEquals(n.desconto(), 400);
		
	}
	@Test
	void testarCampanha() {
		Notebook n1 = new Notebook("Note", 3000, 3, 16, false);
		Notebook n2 = new Notebook("Note", 1000, 2, 8, true);
		Smartphone s1 = new Smartphone(500, 1, 256, true);
		
		Campanha campanha = new Campanha();
		campanha.addProduto(n1); // tem que ter 9 garantia (+6 pois tem 16 gb de ram) e preço 3000 ( não tem desconto pois não tem 5G).
		campanha.addProduto(n2); // 2 garantia ( sem aumento pois tem menos de 16gb de ram) e preço de 920  (tem desconto de 8% pois tem 5G).
		campanha.addProduto(s1); // 4 garantia (+3 meses porque tem 256 gb de ram) e preço de 475 (desconto de 5% porque tem 5G).
		
		assertEquals(campanha.precoTotal(), 4395); //soma de todos os preços acima.
		
		String texto = "Note\nR$3000.0 - Garantia: 9\nNote\nR$920.0 - Garantia: 2\nSmartphone\n"
						+ "R$475.0 - Garantia: 4\n";
		
		
		assertEquals(campanha.imprimir(), texto);
		System.out.println(campanha.imprimir() + "\n\n" + texto);
	}

}
