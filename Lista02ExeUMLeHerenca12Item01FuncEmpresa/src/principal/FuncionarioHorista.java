package principal;

public class FuncionarioHorista extends Funcionario {

	private int horasTrabalhadas;
	private double valorHora;
	
	public FuncionarioHorista(String nomeInformado, int matriculaInformada, int horasTrab, double valorHora) {
		super(nomeInformado, matriculaInformada);
		setHorasTrabalhadas(horasTrab);
		setValorHora(valorHora);
	}

	public int getHorasTrabalhadas() {
		return horasTrabalhadas;
	}


	public void setHorasTrabalhadas(int horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}


	public double getValorHora() {
		return valorHora;
	}


	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}
	
	
	@Override
	public double calcularSalario() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
