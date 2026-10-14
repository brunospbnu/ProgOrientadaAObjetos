
public class ContaBancaria {
	private String numero;
	private double saldo;
	private Cliente cliente;
	
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
		return cliente;
	}
	
	public void setTitular(Cliente titular) {
		cliente = titular;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void depositar(double valor) {
		saldo = saldo + valor;
	}
	
	public void sacar(double valor) {
		saldo = saldo - valor;
	}
	
	public void transferir(ContaBancaria ContaDestino, double valor) {
		sacar(valor);
		ContaDestino.depositar(valor);
	}
	
	
	
	
}
