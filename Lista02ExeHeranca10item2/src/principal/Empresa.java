package principal;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
	private List<Veiculo> veiculos;
	
	
	public Empresa() {
		setVeiculos(new ArrayList<Veiculo>());
	}


	public List<Veiculo> getVeiculos() {
		return veiculos;
	}


	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
	
	public void addVeiculo(Veiculo veiculoInformado) {
		//TODO fazer esse metodo.
	}
	
	public String listarVeiculos() {
		String lista = "";
		
		//TODO fazer preenchimento da lista.
		
		
		return lista;
	}
	
	public Veiculo calcVeiculoMaisBaratoViagem(double distanciaKm, double preco) {
		Veiculo melhorVeiculo = null;
		
		//TODO fazer parte do metodo que analisa e define o melhor veiculo.
		
		
		return melhorVeiculo;
	}
}
