package principal;

import java.time.LocalDate;

public class Carro extends Veiculo{
	
	
	private int quantPortas;

	
	public Carro(String placaInformada, String modeloInformado, double valorDiariaBaseInformado,
			LocalDate dtInicioInformada, LocalDate dtFimInformada, int qntPortasInformada) {
		super(placaInformada, modeloInformado, valorDiariaBaseInformado, dtInicioInformada, dtFimInformada);
		setQuantPortas(qntPortasInformada);
	}
	
	
	public int getQuantPortas() {
		return quantPortas;
	}

	
	public void setQuantPortas(int quantPortas) {
		this.quantPortas = quantPortas;
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
