package serializacao;

import java.io.Serializable;

public class ContaBancaria implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 377231888186889593L;
	private String numeroConta;
	private String nome;
	private int saldo;
	private transient String dadoTemporario; // o transient é para que o dado não seja salvo no arquivo.

	public ContaBancaria(String numeroConta, String nome, int saldo) {
		setNumeroConta(numeroConta);
		setNome(nome);
		setSaldo(saldo);
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public String getDadoTemporario() {
		return dadoTemporario;
	}

	public void setDadoTemporario(String dadoTemporario) {
		this.dadoTemporario = dadoTemporario;
	}
	
}
