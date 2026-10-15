package principal;

public class ContaEspecial extends ContaBancaria{
	
	private double limiteCredito;
	
	public ContaEspecial(String nmCOntaInformado, Cliente titular, double limiteInformado) throws IllegalArgumentException {
		super(nmCOntaInformado, titular);
		setLimiteCredito(limiteInformado);
	}

	public double getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(double limiteCredito) throws IllegalArgumentException{
		if (limiteCredito < 0) {
			throw new IllegalArgumentException("O limite não pode ser menor que 0");
		}
		this.limiteCredito = limiteCredito;
	}
	
	@Override
	public void sacar(double valor) throws IllegalArgumentException {
		if (valor <= 0) {
			throw new IllegalArgumentException("O valor a ser sacado deve ser positivo");
		}
		double saldoAtual = getSaldo();
		// Você calcula o novo saldo (que pode dar negativo)
		double novoSaldo = saldoAtual - valor;
		// Quando você chama setSaldo(novoSaldo), o Java vai rodar o setSaldo do pai,
	    // MAS a mágica do Polimorfismo faz ele usar a sua validação da ContaEspecial!
		this.setSaldo(novoSaldo);
	}
	
	@Override
	protected void validarSaldo(double saldo) throws IllegalArgumentException{
	    // A Conta Especial tem uma regra diferente: permite negativo, até o limite
	    if (saldo < -limiteCredito) {
	        throw new IllegalArgumentException("Saldo ultrapassa o limite de crédito disponível!");
	    }
	}
	
	
}
