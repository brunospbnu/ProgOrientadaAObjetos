package principal;

import java.util.ArrayList;
import java.util.List;

import excecoes.CampoVazioException;
import excecoes.Maior3CaracteresException;

public class ContaBancaria {
	private String numero;
	private double saldo;
	private Cliente titular;
	private List<Movimento> movimentos;
	
	public ContaBancaria(String nmCOntaInformado, Cliente titular) throws IllegalArgumentException, CampoVazioException, Maior3CaracteresException{
		setNumero(nmCOntaInformado);
		setTitular(titular);
		movimentos = new ArrayList<Movimento>();
		setSaldo(0);
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		if (numero == null|| numero.isBlank()) {
			throw new CampoVazioException("Numero da Conta");
		}
		this.numero = numero;
	}
	
	public Cliente getTitular() {
		return titular;
	}
	
	public void setTitular(Cliente titular) {
		if (titular == null) {
			throw new CampoVazioException("Titular");
		}
		this.titular = titular;
	}

	public double getSaldo() {
		return saldo;
	}

	
	
	protected void validarSaldo(double saldo) throws IllegalArgumentException {
		if (saldo < 0) {
	        throw new IllegalArgumentException("Saldo informado deve ser positivo");
	    }
	}
	
	
	protected void setSaldo(double saldo) {
		validarSaldo(saldo);
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
		if (ContaDestino == null) {
			throw new CampoVazioException("Conta bancária de destino");
		}
		sacar(valor);
		ContaDestino.depositar(valor);
	}
	
	public List<Movimento> getMovimentos() {
		return movimentos;
	}
	
	public void incluirMovimento(Movimento m) {
		movimentos.add(m);
	}
	
	
}
