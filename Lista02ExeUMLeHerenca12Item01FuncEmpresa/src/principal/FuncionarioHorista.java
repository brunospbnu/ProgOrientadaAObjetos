package principal;

public class FuncionarioHorista extends Funcionario {

	private int horasTrabalhadas;
	private double valorHora;
	
	public FuncionarioHorista(String nomeInformado, int matriculaInformada, int horasTrab, double valorHora) throws IllegalArgumentException {
		super(nomeInformado, matriculaInformada);
		setHorasTrabalhadas(horasTrab);
		setValorHora(valorHora);
	}

	public int getHorasTrabalhadas() {
		return horasTrabalhadas;
	}


	public void setHorasTrabalhadas(int horasTrabalhadas) throws IllegalArgumentException {
		if (horasTrabalhadas <= 0) {
			throw new IllegalArgumentException("As horas trabalhadas devem ser maiores que 0 !!!");
		}
		this.horasTrabalhadas = horasTrabalhadas;
	}


	public double getValorHora() {
		return valorHora;
	}


	public void setValorHora(double valorHora) throws IllegalArgumentException {
		if (valorHora <= 0) {
			throw new IllegalArgumentException("O valor da hora deve ser maior do que 0 !!!");
		}
		this.valorHora = valorHora;
	}
	
	
	@Override
	public double calcularSalario() {
		double salario = getValorHora() * getHorasTrabalhadas();
		return salario;
	}

	
}
