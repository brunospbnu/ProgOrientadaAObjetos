package principal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestePlantacao {

	@Test
	void testePlantacao() {
		
		Plantacao sitioPrimavera = new Plantacao("Sitio Primavera");
		
		PlantioMorango albion = new PlantioMorango("Albion", 100, 0.8); // Produz 80 KG
		PlantioMelancia crimsonSweet = new PlantioMelancia("Crimson Sweet", 20, 2, 5); // Produz 200 KG
		
		sitioPrimavera.adicionarPlantio(albion);
		sitioPrimavera.adicionarPlantio(crimsonSweet);
		
		assertEquals("Albion", sitioPrimavera.getPlantios().get(0).getVaridade());
		assertEquals("Crimson Sweet", sitioPrimavera.getPlantios().get(1).getVaridade());
		
		assertEquals(100, sitioPrimavera.getPlantios().get(0).getQuantidadeMudas());
		assertEquals(20, sitioPrimavera.getPlantios().get(1).getQuantidadeMudas());
		
		//Teste da produção de cada Pantio Especifico.
		assertEquals(80, albion.calcularProducao());
		assertEquals(200, crimsonSweet.calcularProducao());
		
		//Teste da produção total estimada = 280 KG
		assertEquals(280, sitioPrimavera.calcularProducaoTotal());
		
	}

}
