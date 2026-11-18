package principal;

public class PlantioMelancia extends Plantio {
	
	private int frutosPorMuda;
	private double pesoMedioFruto;
	
	public PlantioMelancia(String variedade, int quantidadeMudas, int frutosPorMuda, double pesoMedioFruto) throws IllegalArgumentException {
		super(variedade, quantidadeMudas);
		setFrutosPorMuda(frutosPorMuda);
		setPesoMediaFruto(pesoMedioFruto);
	}

	public int getFrutosPorMuda() {
		return frutosPorMuda;
	}

	public void setFrutosPorMuda(int frutosPorMuda) throws IllegalArgumentException {
		if (frutosPorMuda <= 0) {
			throw new IllegalArgumentException("A quantidade de frutos por muda deve ser maior que zero !!!");
		}
		this.frutosPorMuda = frutosPorMuda;
	}

	public double getPesoMediaFruto() {
		return pesoMedioFruto;
	}

	public void setPesoMediaFruto(double pesoMedioFruto) throws IllegalArgumentException {
		if (pesoMedioFruto <= 0) {
			throw new IllegalArgumentException("O peso medio do fruto deve ser maior que zero !!!");
		}
		this.pesoMedioFruto = pesoMedioFruto;
	}

	@Override
	public double calcularProducao() {
		double producao = getQuantidadeMudas() * getFrutosPorMuda() * getPesoMediaFruto();
		return producao;
	}
	
	
}
