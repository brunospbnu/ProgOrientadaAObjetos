package teste;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import principal.Cliente;
import principal.ContaBancaria;
import principal.ContaEspecial;

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
	
	@Test
	void sacarValorPositivoContaBase() {
		ContaBancaria conta = new ContaBancaria("001",new Cliente("Bruno", "Rua Camboriu"));
		conta.depositar(100);
		conta.sacar(50);
		assertEquals(50, conta.getSaldo());
	}
	
	@Test
	void sacarValorNegativoContaBase() {
		ContaBancaria conta = new ContaBancaria("001",new Cliente("Bruno", "Rua Camboriu"));
		conta.depositar(100);
		
		IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, 
				() -> {
						conta.sacar(150);
						});
		
		assertEquals("Valor deve ser menor que o saldo da conta. Saldo atual R$ 100.0", excecao.getMessage());
		conta.sacar(50);
		assertEquals(50, conta.getSaldo());
	}
	
	@Test
	void sacarValorMaiorSaldoDentroLimite() {
		ContaEspecial conta = new ContaEspecial("001",new Cliente("Bruno", "Rua Camboriu"),100);
		
		assertEquals(0, conta.getSaldo());
		
		conta.depositar(20);
		
		IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, 
				() -> {
						conta.sacar(130);
						});
		
		assertEquals("Saldo ultrapassa o limite de crédito disponível!", excecao.getMessage());
		conta.sacar(50);
		assertEquals(-30, conta.getSaldo());
	}
}
