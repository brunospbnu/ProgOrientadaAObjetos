package principal;

public class Onibus extends Veiculo {
	private int quantPassageiros;
	private double porcEficiencia;
	
	public Onibus(String placaInformada, double tanque, double consumoInformado, int quantPassageirosInformada) throws IllegalArgumentException {
		super(placaInformada, tanque, consumoInformado);
		setQuantPassageiros(quantPassageirosInformada);
		setPorcEficiencia(quantPassageirosInformada);
	}

	
	public int getQuantPassageiros() {
		return quantPassageiros;
	}

	public void setQuantPassageiros(int quantPassageiros) throws IllegalArgumentException {
		if (quantPassageiros <= 0 || quantPassageiros >= 200) {
			throw new IllegalArgumentException("A quantidade de passagerios deve ser maior do que zero e menor que 200 !!!");
		}
		this.quantPassageiros = quantPassageiros;
	}



	public double getPorcEficiencia() {
		return porcEficiencia;
	}

	public void setPorcEficiencia(int quantPassegairosInformada) {
			porcEficiencia = 100.00 - ((quantPassegairosInformada / 10) * 5);
	
	}
	
	
	@Override
	public double calcAutonomia() {
		double autonomia = getTanque() * getConsumoBase() * (getPorcEficiencia() /100.00);
		return autonomia;
	}

	@Override
	public double calcCustoViagem(double kmViagem, double precoComb) {
		double litroNecessario;
		litroNecessario = kmViagem / getConsumoBase() * ((100 + (Math.abs(getPorcEficiencia() - 100))) /100.00);
		double custo = litroNecessario * precoComb;
		return custo;
	}

}
