package principal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Veiculo {
	
	DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private String placa;
	private String modelo;
	private double valorDiariaBase;
	private LocalDate dataInicioLocacao;
	private LocalDate dataFimLocacao;
	
	
	public Veiculo(String placaInformada, String modeloInformado, double valorDiariaBaseInformado
			, LocalDate dtInicioInformada, LocalDate dtFimInformada) throws IllegalArgumentException {
		setPlaca(placaInformada);
		setModelo(modeloInformado);
		setValorDiariaBase(valorDiariaBaseInformado);
		setDataInicioLocacao(dtInicioInformada);
		setDataFimLocacao(dtFimInformada);
	}

	
	public String getPlaca() {
		return placa;
	}

	
	public void setPlaca(String placa) throws IllegalArgumentException {
		if (placa == null || placa.isBlank() || placa.length() != 7) {
			throw new IllegalArgumentException("A placa deve ter exatamente 7 digitos, e não pode estar em Branco");
		}
		this.placa = placa;
	}

	
	public String getModelo() {
		return modelo;
	}

	
	public void setModelo(String modelo) throws IllegalArgumentException {
		if (modelo == null || modelo.isBlank() || modelo.length() < 2) {
			throw new IllegalArgumentException("O nome do modelo não pode estar vazio e deve ter 2 letras ou mais");
		}
		this.modelo = modelo;
	}

	
	public double getValorDiariaBase() {
		return valorDiariaBase;
	}

	
	public void setValorDiariaBase(double valorDiariaBase)  throws IllegalArgumentException {
		if (valorDiariaBase <= 0) {
			throw new IllegalArgumentException("O valor da diária deve ser maior que zero !!!");
		}
		this.valorDiariaBase = valorDiariaBase;
	}

	
	public LocalDate getDataInicioLocacao() {
		return dataInicioLocacao;
	}

	
	public void setDataInicioLocacao(LocalDate dataInicioLocacao) throws IllegalArgumentException {
		if (dataInicioLocacao == null) {
			throw new IllegalArgumentException("A data não pode ser nula !!!");
		}
		this.dataInicioLocacao = dataInicioLocacao;
	}

	
	public LocalDate getDataFimLocacao() {
		return dataFimLocacao;
	}
	

	public void setDataFimLocacao(LocalDate dataFimLocacao) throws IllegalArgumentException {
		if (dataFimLocacao == null) {
			throw new IllegalArgumentException("A data não pode ser nula !!!");
		}
		if (dataFimLocacao.isBefore(dataInicioLocacao)) {
			throw new IllegalArgumentException("A data fim não pode ser antes da data inicio da locação !!!");
		}
		this.dataFimLocacao = dataFimLocacao;
	}
	
	public long calcularDiasUso() {
	    return getDataFimLocacao().toEpochDay() - getDataInicioLocacao().toEpochDay();
	}
	
	
	public abstract double calcularAluguel();
	
	
	public abstract String imprimirInformacoes();
	
}
