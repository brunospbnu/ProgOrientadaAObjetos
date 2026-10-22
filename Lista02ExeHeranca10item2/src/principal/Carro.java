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
		
		//TODO corrigir erro no método.
		
		double litroNecessario;
		
		if (acLigado) {
			litroNecessario = kmViagem / getConsumoBase() * 1.1;
		}
		else {
			litroNecessario = kmViagem / getConsumoBase();
		}
		
		double custo = litroNecessario * precoComb;
		
		return custo;
	}
}
