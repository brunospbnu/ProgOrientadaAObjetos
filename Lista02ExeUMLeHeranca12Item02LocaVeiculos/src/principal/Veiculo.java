package principal;

import java.time.LocalDate;

public abstract class Veiculo {
	
	
	private String placa;
	private String modelo;
	private double valorDiariaBase;
	private LocalDate dataInicioLocacao;
	private LocalDate dataFimLocacao;
	
	
	public Veiculo(String placaInformada, String modeloInformado, double valorDiariaBaseInformado, LocalDate dtInicioInformada, LocalDate dtFimInformada) {
		setPlaca(placaInformada);
		setModelo(modeloInformado);
		setValorDiariaBase(valorDiariaBaseInformado);
		setDataInicioLocacao(dtInicioInformada);
		setDataFimLocacao(dtFimInformada);
	}

	
	public String getPlaca() {
		return placa;
	}

	
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	
	public String getModelo() {
		return modelo;
	}

	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	
	public double getValorDiariaBase() {
		return valorDiariaBase;
	}

	
	public void setValorDiariaBase(double valorDiariaBase) {
		this.valorDiariaBase = valorDiariaBase;
	}

	
	public LocalDate getDataInicioLocacao() {
		return dataInicioLocacao;
	}

	
	public void setDataInicioLocacao(LocalDate dataInicioLocacao) {
		this.dataInicioLocacao = dataInicioLocacao;
	}

	
	public LocalDate getDataFimLocacao() {
		return dataFimLocacao;
	}
	

	public void setDataFimLocacao(LocalDate dataFimLocacao) {
		this.dataFimLocacao = dataFimLocacao;
	}
	
	
	public abstract double calcularAluguel();
	
	
	public abstract String imprimirInformacoes();
	
}
