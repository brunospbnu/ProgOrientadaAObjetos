package principal;

public class PlantioMorango extends Plantio {
	
	private double kgPorMuda;
	
	public PlantioMorango(String variedade, int quantidadeMudas, double kgPorMuda) throws IllegalArgumentException {
		super(variedade, quantidadeMudas);
		setKgPorMuda(kgPorMuda);
	}

	public double getKgPorMuda() {
		return kgPorMuda;
	}

	public void setKgPorMuda(double kgPorMuda) throws IllegalArgumentException {
		if (kgPorMuda <= 0) {
			throw new IllegalArgumentException("O valor de KG por muda deve ser maior que zero !!!");
		}
		this.kgPorMuda = kgPorMuda;
	}

	@Override
	public double calcularProducao() {
		double producao = getQuantidadeMudas() * getKgPorMuda();
		return producao;
	}

}
