package principal;

public class Carro extends Veiculo {
	private boolean acLigado;
	
	Carro(String placaInformada, double tanque, double consumoInformado, boolean acLigado) {
		super(placaInformada, tanque, consumoInformado);
		setAcLigado(acLigado);
	}

	public boolean isAcLigado() {
		return acLigado;
	}

	public void setAcLigado(boolean acLigado) {
		this.acLigado = acLigado;
	}

	@Override
	public double calcAutonomia() {
		double autonomia;
		if (acLigado) {
			autonomia = getTanque() * getConsumoBase() * 0.9;
		}
		else {
			autonomia = getTanque() * getConsumoBase();
		}
		return autonomia;
	}
	
	
	

	@Override
	public double calcCustoViagem(double kmViagem, double precoComb) {
		
		double consumoEfetivo;
		
		if (acLigado) {
			consumoEfetivo = getConsumoBase() * 0.9;
		}
		else {
			consumoEfetivo = getConsumoBase();
		}
		
		double custo = (kmViagem / consumoEfetivo) * precoComb;
		
		return custo;
	}
}
