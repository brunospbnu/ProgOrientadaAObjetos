package principal;

public class ContaEspecial extends ContaBancaria{
	
	private double limiteCredito;
	
	public ContaEspecial(String nmCOntaInformado, double limiteInformado) {
		super(nmCOntaInformado);
		setLimiteCredito(limiteInformado);
	}

	public double getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}
	
	@Override
	public void sacar(double valor) {
		double saldo = getSaldo();
		if (saldo + limiteCredito - valor >= 0) {
			saldo = saldo - valor;
		}
		setSaldo(saldo);
	}
	
	
}
