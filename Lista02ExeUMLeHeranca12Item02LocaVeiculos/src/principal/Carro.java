package principal;

import java.time.LocalDate;

public class Carro extends Veiculo{
	
	
	private int quantPortas;

	
	public Carro(String placaInformada, String modeloInformado, double valorDiariaBaseInformado,
			LocalDate dtInicioInformada, LocalDate dtFimInformada, int qntPortasInformada) throws IllegalArgumentException {
		
		super(placaInformada, modeloInformado, valorDiariaBaseInformado, dtInicioInformada, dtFimInformada);
		setQuantPortas(qntPortasInformada);
		
	}
	
	
	public int getQuantPortas() {
		return quantPortas;
	}

	
	public void setQuantPortas(int quantPortas) throws IllegalArgumentException {
		if (quantPortas < 1) {
			throw new IllegalArgumentException("A quantidade de portas não pode ser menor que 1 !!!");
		}
		this.quantPortas = quantPortas;
	}
	
	
	@Override
	public double calcularAluguel() {
		double valor = getValorDiariaBase() + 50;
		return valor;
	}

	
	@Override
	public String imprimirInformacoes() {
		String texto = "Carro) Placa: " + getPlaca() + " - Modelo: " + getModelo() + " - Data Inicio Aluguel: " 
						+ getDataInicioLocacao().format(formatador) + " - Data Fim Aluguel: " + getDataFimLocacao().format(formatador) 
						+ " - Quantidade de Portas: " + getQuantPortas() + " - Valor do Aluguel: R$ " + calcularAluguel();
		return texto;
	}


	
}
