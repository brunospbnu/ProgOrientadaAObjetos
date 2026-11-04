package principal;

import java.time.LocalDate;

public class Caminhao extends Veiculo {
	
	
	private double capacidadeToneladas;

	
	public Caminhao(String placaInformada, String modeloInformado, double valorDiariaBaseInformado,
			LocalDate dtInicioInformada, LocalDate dtFimInformada, double capTonInformada) {
		super(placaInformada, modeloInformado, valorDiariaBaseInformado, dtInicioInformada, dtFimInformada);
		setCapacidadeToneladas(capTonInformada);
	}

	
	public double getCapacidadeToneladas() {
		return capacidadeToneladas;
	}

	
	public void setCapacidadeToneladas(double capacidadeToneladas) {
		this.capacidadeToneladas = capacidadeToneladas;
	}


	@Override
	public double calcularAluguel() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public String imprimirInformacoes() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
