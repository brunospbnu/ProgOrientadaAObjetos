package teste;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import principal.Cliente;
import principal.ContaBancaria;
import principal.Movimento;
import principal.TipoMovimento;

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
	void registroDeMovimentacoes() {
		ContaBancaria conta = new ContaBancaria("001",new Cliente("Bruno", "Rua Camboriu"));
		conta.depositar(1000);
		
		IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, 
				() -> {
						conta.sacar(1001);
						});
		
		assertEquals("Valor deve ser menor que o saldo da conta. Saldo atual R$ 1000.0", excecao.getMessage());
		conta.sacar(250);
		List<Movimento> movimentosAnalisados = conta.getMovimentos();
		
		assertEquals(750, conta.getSaldo());
		assertEquals(TipoMovimento.CREDITO, movimentosAnalisados.get(0).getTipoMovimento());
		assertEquals(1000, movimentosAnalisados.get(0).getValor());
		assertEquals(TipoMovimento.DEBITO, movimentosAnalisados.get(1).getTipoMovimento());
		assertEquals(250, movimentosAnalisados.get(1).getValor());
	}
	
}
