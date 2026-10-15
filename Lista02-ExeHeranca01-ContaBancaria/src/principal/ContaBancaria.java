package principal;

public class ContaBancaria {
	private String numero;
	private double saldo;
	private Cliente titular;
	
	public ContaBancaria(String nmCOntaInformado) {
		setNumero(nmCOntaInformado);
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public Cliente getTitular() {
		return titular;
	}
	
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void depositar(double valor) {
		if (valor <= 0 ) {
			throw new IllegalArgumentException("Valor deve ser maior que 0");
		}
		saldo = saldo + valor;
		//Poderia ser: 
		//this.setSaldo(this.getSaldo() +valor);
	}
	
	public void sacar(double valor) {
		if (valor <= 0 ) {
			throw new IllegalArgumentException("Valor deve ser maior que 0");
		}
		if (valor > saldo) {
			throw new IllegalArgumentException("Valor deve ser menor que o saldo da conta. Saldo atual R$ " + saldo);
		}
		saldo = saldo - valor;
	}
	
	public void transferir(ContaBancaria ContaDestino, double valor) {
		sacar(valor);
		ContaDestino.depositar(valor);
	}
	
	
	
	
}
