package principal;

public class Carro extends Veiculo {
	private boolean acLigado;
	
	Carro(String placaInformada, double capTanqueInformada, double consumoInformado, boolean acLigado) {
		super(placaInformada, capTanqueInformada, consumoInformado);
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calcCustoViagem() {
		// TODO Auto-generated method stub
		return 0;
	}
}
