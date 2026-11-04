package principal;

import java.time.LocalDate;

public class Caminhao extends Veiculo {
	
	
	private double capacidadeToneladas;

	
	public Caminhao(String placaInformada, String modeloInformado, double valorDiariaBaseInformado,
			LocalDate dtInicioInformada, LocalDate dtFimInformada, double capTonInformada) throws IllegalArgumentException {
		
		super(placaInformada, modeloInformado, valorDiariaBaseInformado, dtInicioInformada, dtFimInformada);
		setCapacidadeToneladas(capTonInformada);
		
	}

	
	public double getCapacidadeToneladas() {
		return capacidadeToneladas;
	}

	
	public void setCapacidadeToneladas(double capacidadeToneladas) throws IllegalArgumentException {
		if (capacidadeToneladas <= 0) {
			throw new IllegalArgumentException("A capacidade deve ser maior que zero !!!");
		}
		this.capacidadeToneladas = capacidadeToneladas;
	}


	@Override
	public double calcularAluguel() {
		double valor = 0;
		int capacidadeTonEmInt = (int) capacidadeToneladas;
		valor = getValorDiariaBase() + (capacidadeTonEmInt * 100);
		return valor;
	}


	@Override
	public String imprimirInformacoes() {
		String texto = "Caminhão) Placa: " + getPlaca() + " - Modelo: " + getModelo() + " - Data Inicio Aluguel: " 
				+ getDataInicioLocacao().format(formatador) + " - Data Fim Aluguel: " + getDataFimLocacao().format(formatador) 
				+ " - Capacidade: " + getCapacidadeToneladas() + " toneladas - Valor do Aluguel: R$ " + calcularAluguel();
		return texto;
	}
	
}
