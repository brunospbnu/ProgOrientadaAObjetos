package principal;

import java.time.LocalDate;

public class Moto extends Veiculo {
	
	
	private boolean temCilindradas;

	
	public Moto(String placaInformada, String modeloInformado, double valorDiariaBaseInformado,
			LocalDate dtInicioInformada, LocalDate dtFimInformada, boolean temCilindradasInfo) throws IllegalArgumentException {
		
		super(placaInformada, modeloInformado, valorDiariaBaseInformado, dtInicioInformada, dtFimInformada);
		setTemCilindradas(temCilindradasInfo);
	}

	
	public boolean isTemCilindradas() {
		return temCilindradas;
	}

	
	public void setTemCilindradas(boolean temCilindradas) {
		this.temCilindradas = temCilindradas;
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
