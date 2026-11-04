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
		double valor = 0;
		if (getDataInicioLocacao().plusDays(6).isBefore(getDataFimLocacao())) {
			if (this.temCilindradas) {
				valor = getValorDiariaBase() * 0.95;
			}
			else {
				valor = getValorDiariaBase() * 0.9;
			}
		}
		else {
			valor = getValorDiariaBase();
		}
		return valor;
	}


	@Override
	public String imprimirInformacoes() {
		String temCilindradas = "";
		
		if (this.temCilindradas) {
			temCilindradas = "SIM";
		}
		else {
			temCilindradas = "NÃO";
		}
		
		String texto = "Moto) Placa: " + getPlaca() + " - Modelo: " + getModelo() + " - Data Inicio Aluguel: " 
				+ getDataInicioLocacao().format(formatador) + " - Data Fim Aluguel: " + getDataFimLocacao().format(formatador) 
				+ " - Tem cilindradas? : " + temCilindradas + " - Valor do Aluguel: R$ " + calcularAluguel();
		
		return texto;
	}
	
}
