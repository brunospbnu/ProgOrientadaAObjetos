package principal;

public class Onibus extends Veiculo {
	private int quantPassageiros;
	private double porcEficiencia;
	
	public Onibus(String placaInformada, double capTanqueInformada, double consumoInformado, int quantPassageirosInformada) throws IllegalArgumentException {
		super(placaInformada, capTanqueInformada, consumoInformado);
		setQuantPassageiros(quantPassageirosInformada);
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
			porcEficiencia = (quantPassegairosInformada / 10) * 5;
	
	}
	
	
	
	
	@Override
	public double calcAutonomia() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calcCustoViagem() {
		// TODO Auto-generated method stub
		return 0;
	}

}
