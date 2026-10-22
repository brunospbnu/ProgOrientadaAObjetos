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
	
	public void addVeiculo(Veiculo veiculoInformado) throws IllegalArgumentException{
		if (veiculoInformado == null) {
			throw new IllegalArgumentException("O veiculo não pode ser nulo !!!");
		}
		veiculos.add(veiculoInformado);
	}
	
	public String listarVeiculos() {
		String lista = "Lista de Veículos";
		for (Veiculo veiculo : veiculos) {
			lista += "\n Categoria: " + veiculo.getClass().getName() + " - Placa: " + veiculo.getPlaca() 
					+ " - Litros no Tanque " + veiculo.getTanque() + " - Consumo Base: " + veiculo.getConsumoBase();
			if (veiculo instanceof Carro) {
				Carro carro = (Carro) veiculo;
				String estadoDoAr = "";
				if (carro.isAcLigado()) {
					estadoDoAr = "LIGADO";
				}
				else {
					estadoDoAr = "DESLIGADO";
				}
				lista += " - Estado do AR: " + estadoDoAr;
			}
			else if (veiculo instanceof Onibus) {
				Onibus onibus = (Onibus) veiculo;
				lista += " - Quantidade de passageiros: " + onibus.getQuantPassageiros()
						+ " - Eficiencia Atual: " + onibus.getPorcEficiencia() + "%";
			}
		}
		
		lista += "Fim da lista";
		
		return lista;
	}
	
	public Veiculo calcVeiculoMaisBaratoViagem(double distanciaKm, double preco) {
		Veiculo melhorVeiculo = veiculos.get(0);
		for (Veiculo veiculo : veiculos) {
			if (veiculo.calcCustoViagem(distanciaKm, preco) < melhorVeiculo.calcCustoViagem(distanciaKm, preco)) {
				melhorVeiculo = veiculo;
			}
			}
		return melhorVeiculo;
	}
}
