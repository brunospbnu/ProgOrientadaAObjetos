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
	
	
	public void addVeiculo(Veiculo veiculoInformado) throws IllegalArgumentException {
		if (veiculoInformado == null) {
			throw new IllegalArgumentException("O veículo a ser adicionado não pode ser nulo !!!");
		}
		veiculos.add(veiculoInformado);
	}
	
	
	public String impInfoTodos() {
		String texto = "Lista de Veículos: \n";
		for (Veiculo veiculo : veiculos) {
			texto += veiculo.imprimirInformacoes() + "\n";
		}
		texto += "\n Fim da lista !!! ";
		return texto;
	}
	
	
	public String impMaiorValorPagoEVeiculo() {
		String texto = "Veiculo com maior valor pago: \n";
		Veiculo veiculoMaiorValor = veiculos.get(0);
		boolean empate = false;
		
		for (int i = 0; i < veiculos.size(); i++) {
			Veiculo veiculoAtual = veiculos.get(i);
			if (veiculoAtual.calcularAluguel() > veiculoMaiorValor.calcularAluguel()) {
				veiculoMaiorValor = veiculoAtual;
			}
		}
		
		for (int i = 0; i < veiculos.size(); i++) {
			Veiculo veiculoAtual = veiculos.get(i);
			if (veiculoAtual.calcularAluguel() == veiculoMaiorValor.calcularAluguel() && veiculoAtual != veiculoMaiorValor) {
				empate = true;
			}
		}
		
		if (empate == true) {
			texto += "***OBS: Atenção, houve empate, mostrando apenas o primeiro veiculo maior da lista que foi encontrado \n";
		}
		
		
		texto += veiculoMaiorValor.imprimirInformacoes() + "\n";
		return texto;
	}
	
	
	public String impQuantVeiculosEValorTot() {
		double valorTotal = 0;
		for (Veiculo veiculoAtual : veiculos) {
			valorTotal += veiculoAtual.calcularAluguel();
		}
		String texto = "A quantidade de veículos é: " + veiculos.size() + "\n O valor total de alugueis é: R$ " + valorTotal;
		return texto;
		
	}
}
