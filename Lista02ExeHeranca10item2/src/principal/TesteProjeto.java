package principal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TesteProjeto {

	@Test
	void testandoCarros() {
		Carro c1 = new Carro("PlacaC1", 20, 10, false); //placa, tanque, consumo, acLigado?
		Carro c2 = new Carro("PlacaC2", 30, 10, true);
		
		assertEquals("PlacaC1", c1.getPlaca());
		assertEquals(20, c1.getTanque());
		assertEquals(10, c1.getConsumoBase());
		assertEquals(false, c1.isAcLigado());
		assertEquals(200, c1.calcAutonomia()); // autonomia 20 * 10 = 200
		assertEquals(245, c1.calcCustoViagem(350, 7)); // custo viagem exemplo 350 km e 7 reais o litro: sem ar, logo eficiencia 100%: 350 km / 10 km/l = 35 litros  * 7 = 245.
		
		
		assertEquals("PlacaC2", c2.getPlaca());
		assertEquals(30, c2.getTanque());
		assertEquals(10, c2.getConsumoBase());
		assertEquals(true, c2.isAcLigado());
		assertEquals(270, c2.calcAutonomia()); // autonomia 30 * 10 = 300 - 10% = 270.
		assertEquals(272.2222222222222, c2.calcCustoViagem(350, 7)); // custo viagem exemplo: 350 km - gasolina 7 reais o litro: com ar ligado eficiencia de 90%: 9 km/l, logo: 350 / 9 = 38,88 * 7 = 272,2222222222222
		

	}
	
	@Test
	void testandoOnibus() {
		Onibus o1 = new Onibus("PlacaO1", 20, 10, 9);
		Onibus o2 = new Onibus("PlacaO2", 30, 10, 20);
		
		assertEquals("PlacaO1", o1.getPlaca());
		assertEquals(20, o1.getTanque());
		assertEquals(10, o1.getConsumoBase());
		assertEquals(9, o1.getQuantPassageiros());
		assertEquals(200, o1.calcAutonomia()); //autonomia: 20 * 10 * 1 (100%) = 200.
		assertEquals(245, o1.calcCustoViagem(350, 7)); // custo viagem exemplo: 350 km - gasolina 7 reais o litro: com 9 passageiros eficiencia 100%: 350 km  / 10 km/l = 35 * 7 =  245
		
		
		assertEquals("PlacaO2", o2.getPlaca());
		assertEquals(30, o2.getTanque());
		assertEquals(10, o2.getConsumoBase());
		assertEquals(20, o2.getQuantPassageiros());
		assertEquals(270, o2.calcAutonomia()); // autonomia: 30 * 10  = 300 * 0,90 (90%) = 270
		assertEquals(272.2222222222222, o2.calcCustoViagem(350, 7)); // custo viagem exemplo: 350 km - gasolina 7 reais o litro: 90% de eficiencia = 9 km/l : 350 / 9 = 38,88888888888889 * 7 = 272,2222222222222
		
	}
	@Test
	void testaLista() {
		
		Empresa e1 = new Empresa();
		
		Carro c1 = new Carro("PlacaC1", 20, 10, false); //placa, tanque, consumo, acLigado?
		Carro c2 = new Carro("PlacaC2", 30, 15, true);
		Onibus o1 = new Onibus("PlacaO1", 20, 10, 9);
		Onibus o2 = new Onibus("PlacaO2", 30, 15, 20);
		
		e1.addVeiculo(c1);
		e1.addVeiculo(c2);
		e1.addVeiculo(o1);
		e1.addVeiculo(o2);
		
		// System.out.println(e1.listarVeiculos());
		
		
		assertEquals("Lista de Veículos\n"
				+ " Categoria: Carro - Placa: PlacaC1 - Litros no Tanque 20.0 - Consumo Base: 10.0 - Estado do AR: DESLIGADO\n"
				+ " Categoria: Carro - Placa: PlacaC2 - Litros no Tanque 30.0 - Consumo Base: 15.0 - Estado do AR: LIGADO\n"
				+ " Categoria: Onibus - Placa: PlacaO1 - Litros no Tanque 20.0 - Consumo Base: 10.0 - Quantidade de passageiros: 9 - Eficiencia Atual: 100.0%\n"
				+ " Categoria: Onibus - Placa: PlacaO2 - Litros no Tanque 30.0 - Consumo Base: 15.0 - Quantidade de passageiros: 20 - Eficiencia Atual: 90.0%\n"
				+ "Fim da lista !!!",e1.listarVeiculos());
	}
	@Test
	void testaCalcVeiculoMaisBaratoViagem() {
		
		Empresa e1 = new Empresa();
		
		Carro c1 = new Carro("PlacaC1", 20, 10, true); //placa, tanque, consumo, acLigado?
		Carro c2 = new Carro("PlacaC2", 30, 10, true);
		Onibus o1 = new Onibus("PlacaO1", 20, 10, 9); //deve ser o mais barato
		Onibus o2 = new Onibus("PlacaO2", 30, 10, 40); //colocados mais pasageiros diminui a economia e aumenta o custo.
		
		e1.addVeiculo(c1);
		e1.addVeiculo(c2);
		e1.addVeiculo(o1);
		e1.addVeiculo(o2);
		
		assertEquals(o1, e1.calcVeiculoMaisBaratoViagem(350, 7)); //
	}

}
