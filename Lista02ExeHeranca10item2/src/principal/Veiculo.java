package principal;

public abstract class Veiculo {
	private String placa;
	private double capacidadeTanque;
	private double consumoBase;
	
	public Veiculo(String placaInformada, double tanque, double consumoInformado) throws IllegalArgumentException {
		setPlaca(placaInformada);
		setCapacidadeTanque(tanque);
		setConsumoBase(consumoInformado);
	}
	
	
	public String getPlaca() {
		return placa;
	}
	
	public void setPlaca(String placa) throws IllegalArgumentException {
		if (placa == null) {
			throw new IllegalArgumentException("A placa não pode estar vazia !!! ");
		}
		if (placa.length() != 7) {
			throw new IllegalArgumentException("A placa do carro deve ter obrigatoriamente 7 caracteres (podendo ser letras ou numeros) !!!");
		}
		this.placa = placa;
	}
	
	
	
	public double getTanque() {
		return capacidadeTanque;
	}
	
	public void setCapacidadeTanque(double tanque) throws IllegalArgumentException {
		if (tanque <=0) {
			throw new IllegalArgumentException("A capacidade do tanque deve ser maior que zero litros !!!");
		}
		this.capacidadeTanque = tanque;
	}
	
	
	
	public double getConsumoBase() {
		return consumoBase;
	}
	public void setConsumoBase(double consumoBase) throws IllegalArgumentException {
		if (consumoBase < 1) {
			throw new IllegalArgumentException("O consumo deve ser maior ou igual a 1 KM/L !!!");
		}
		this.consumoBase = consumoBase;
	}
	
	
	public abstract double calcAutonomia();
	
	
	
	public abstract double calcCustoViagem(double kmViagem, double precoComb);
	
}
