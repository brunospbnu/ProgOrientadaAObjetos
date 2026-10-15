package teste;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import principal.Cliente;

class TesteProjeto {

	@Test
	void test() {
		assertTrue(true);
		assertEquals("Bruno", "Bruno");
		// fail("Not yet implemented");
	}
	
	// precisa ter sempre o @Test para que o teste seja rodado.
	@Test
	void testarSetCliente() {
		Cliente c1 = new Cliente("Luciana", "Rua Antonio da Veiga");
		assertEquals(c1.getNome(), "Luciana");
		assertEquals(c1.getEndereco(), "Rua Antonio da Veiga");
	}
}
