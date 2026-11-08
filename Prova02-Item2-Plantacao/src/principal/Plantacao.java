package principal;

import java.util.ArrayList;
import java.util.List;

public class Plantacao {
	
	private String nome;
	private List<Plantio> plantios;
	
	public Plantacao(String nome) {
		setPlantios(new ArrayList<Plantio>());
		setNome(nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Plantio> getPlantios() {
		return plantios;
	}

	public void setPlantios(List<Plantio> plantios) {
		this.plantios = plantios;
	}
	
	public void adicionarPlantio(Plantio plantio) {
		plantios.add(plantio);
	}
	
	public double calcularProducaoTotal() {
		double total = 0;
		for (Plantio plantio : plantios) {
			total += plantio.calcularProducao();
		}
		return total;
	}
	
}
