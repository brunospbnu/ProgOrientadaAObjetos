package principal;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class TesteProjeto {

	@Test
	void testeProjeto() {
		
		Locadora l = new Locadora();
		
		Carro c1 = new Carro("COO1I29", "HB20", 100, LocalDate.of(2026, 01, 01), LocalDate.of(2026, 1, 6), 4);
		
		Moto m1 = new Moto("MOO1I29", "Honda CG 160", 50, LocalDate.of(2026, 01, 01), LocalDate.of(2026, 1, 6), false);
		Moto m2 = new Moto("MOO1I30", "Honda CG 160", 50, LocalDate.of(2026, 01, 01), LocalDate.of(2026, 1, 6), true);
		Moto m3 = new Moto("MOO1I31", "Honda CG 160", 50, LocalDate.of(2026, 01, 01), LocalDate.of(2026, 1, 7), false);
		Moto m4 = new Moto("MOO1I32", "Honda CG 160", 50, LocalDate.of(2026, 01, 01), LocalDate.of(2026, 1, 7), true);
		Moto m5 = new Moto("MOO1I33", "Honda CG 160", 50, LocalDate.of(2026, 01, 01), LocalDate.of(2026, 1, 8), false);
		Moto m6 = new Moto("MOO1I34", "Honda CG 160", 50, LocalDate.of(2026, 01, 01), LocalDate.of(2026, 1, 8), true);
		
		
		Caminhao t1 = new Caminhao("TOO1I29", "Mercedes-Benz L-1113", 200, LocalDate.of(2026, 01, 01), LocalDate.of(2026, 1, 6), 1.3);
		Caminhao t2 = new Caminhao("TOO1I30", "Mercedes-Benz L-1113", 200, LocalDate.of(2026, 01, 01), LocalDate.of(2026, 1, 6), 2.1);
		
		
		l.addVeiculo(c1);
		l.addVeiculo(m1);
		l.addVeiculo(m2);
		l.addVeiculo(m3);
		l.addVeiculo(m4);
		l.addVeiculo(m5);
		l.addVeiculo(m6);
		l.addVeiculo(t1);
		l.addVeiculo(t2);
		
		//Testando cadastro de placa e modelo:
		
		assertEquals("COO1I29", c1.getPlaca());
		assertEquals("HB20", c1.getModelo());
		
		assertEquals("MOO1I29",m1.getPlaca());
		assertEquals("Honda CG 160", m1.getModelo());
		
		assertEquals("TOO1I29",t1.getPlaca());
		assertEquals("Mercedes-Benz L-1113", t1.getModelo());
		
		//Testando valor base do aluguel:
		
		assertEquals(100, c1.getValorDiariaBase());
		assertEquals(50, m1.getValorDiariaBase());
		assertEquals(200 , t1.getValorDiariaBase());
		
		//Testando cadastro das informações adicionais:
		assertEquals(4 , c1.getQuantPortas());
		assertEquals(false , m1.isTemCilindradas());
		assertEquals(1.3, t1.getCapacidadeToneladas());
		
		
		
		//Testando calculos e dados:
		
		assertEquals("Lista de Veículos: \n"
				+ "Carro) Placa: COO1I29 - Modelo: HB20 - Data Inicio Aluguel: 01/01/2026 - Data Fim Aluguel: 06/01/2026 - Quantidade de Portas: 4 - Valor do Aluguel: R$ 150.0\n"
				
				+ "Moto) Placa: MOO1I29 - Modelo: Honda CG 160 - Data Inicio Aluguel: 01/01/2026 - Data Fim Aluguel: 06/01/2026 - Tem cilindradas? : NÃO - Valor do Aluguel: R$ 50.0\n"
				+ "Moto) Placa: MOO1I30 - Modelo: Honda CG 160 - Data Inicio Aluguel: 01/01/2026 - Data Fim Aluguel: 06/01/2026 - Tem cilindradas? : SIM - Valor do Aluguel: R$ 50.0\n"
				+ "Moto) Placa: MOO1I31 - Modelo: Honda CG 160 - Data Inicio Aluguel: 01/01/2026 - Data Fim Aluguel: 07/01/2026 - Tem cilindradas? : NÃO - Valor do Aluguel: R$ 50.0\n"
				+ "Moto) Placa: MOO1I32 - Modelo: Honda CG 160 - Data Inicio Aluguel: 01/01/2026 - Data Fim Aluguel: 07/01/2026 - Tem cilindradas? : SIM - Valor do Aluguel: R$ 50.0\n"
				+ "Moto) Placa: MOO1I33 - Modelo: Honda CG 160 - Data Inicio Aluguel: 01/01/2026 - Data Fim Aluguel: 08/01/2026 - Tem cilindradas? : NÃO - Valor do Aluguel: R$ 45.0\n"
				+ "Moto) Placa: MOO1I34 - Modelo: Honda CG 160 - Data Inicio Aluguel: 01/01/2026 - Data Fim Aluguel: 08/01/2026 - Tem cilindradas? : SIM - Valor do Aluguel: R$ 47.5\n"
				
				+ "Caminhão) Placa: TOO1I29 - Modelo: Mercedes-Benz L-1113 - Data Inicio Aluguel: 01/01/2026 - Data Fim Aluguel: 06/01/2026 - Capacidade: 1.3 toneladas - Valor do Aluguel: R$ 300.0\n"
				+ "Caminhão) Placa: TOO1I30 - Modelo: Mercedes-Benz L-1113 - Data Inicio Aluguel: 01/01/2026 - Data Fim Aluguel: 06/01/2026 - Capacidade: 2.1 toneladas - Valor do Aluguel: R$ 400.0\n"
				+ "\n"
				+ " Fim da lista !!! ", l.impInfoTodos());
		
		assertEquals("Veiculo com maior valor pago: \n"
				+ "Caminhão) Placa: TOO1I30 - Modelo: Mercedes-Benz L-1113 - Data Inicio Aluguel: 01/01/2026 - Data Fim Aluguel: 06/01/2026 - Capacidade: 2.1 toneladas - Valor do Aluguel: R$ 400.0\n", l.impMaiorValorPagoEVeiculo());
		
		
		assertEquals("A quantidade de veículos é: 9\n"
				+ " O valor total de alugueis é: R$ 1142.5", l.impQuantVeiculosEValorTot());
	}

}
