package principal;

import java.util.ArrayList;
import java.util.List;

public class Locadora {
	
	
	private List<Veiculo> veiculos;
	
	
	public Locadora() throws IllegalArgumentException {
		veiculos = new ArrayList<Veiculo>();
	}


	public List<Veiculo> getVeiculos() {
		return veiculos;
	}


	public void setVeiculos(List<Veiculo> veiculos) throws IllegalArgumentException {
		if (veiculos == null) {
			throw new IllegalArgumentException("A lista de veiculos não pode ser nula !!!");
		}
		this.veiculos = veiculos;
	}
	
	
	public void addVeiculo(Veiculo veiculoInformado) {
		//TODO fazer metodo.
	}
	
	
	public String impInfoTodos() {
		String texto = "";
		
		
		//TODO fazer metodo.
		
		
		return texto;
	}
	
	
	public String impMaiorValorPagoEVeiculo() {
		String texto = "";
		
		
		//TODO fazer metodo.
		
		
		return texto;
	}
	
	
	public String impQuantVeiculosEValorTot() {
		String texto = "";
		
		
		//TODO fazer metodo.
		
		
		return texto;
		
	}
}
