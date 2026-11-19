package serializacao;

import java.io.Serializable;

public class Veiculo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6071161516845119808L;
	private String placa;
	private String nome;

	public Veiculo(String paca, String nome) {
		setPlaca(paca);
		setNome(nome);
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
