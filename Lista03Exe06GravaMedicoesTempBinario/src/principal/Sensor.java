package principal;

public class Sensor {
	
	private int codigo;
	private double temperatura;
	private boolean validada;
	
	public Sensor(int codigo, double temperatura, boolean validada) {
		setCodigo(codigo);
		setTemperatura(temperatura);
		setValidada(validada);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	public boolean isValidada() {
		return validada;
	}

	public void setValidada(boolean validada) {
		this.validada = validada;
	}
	
	
}
