
public class Cliente {
	private String nome;
	private String endereco;
	
	public Cliente(String nomeInformado, String endereco) throws CampoVazioException, Maior3CaracteresException {
		setNome(nomeInformado);
		setEndereco(nomeInformado);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws CampoVazioException, Maior3CaracteresException {
		if (nome == null || nome.isBlank()) {
			throw new CampoVazioException("Nome");
		}
		if (nome.length() <3) {
			throw new Maior3CaracteresException("Nome");
		}
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		if (endereco == null || endereco.isBlank()) {
			throw new CampoVazioException("Endereço");
		}
		if (endereco.length() <3) {
			throw new Maior3CaracteresException("Endereço");
		}
		this.endereco = endereco;
	}
}
