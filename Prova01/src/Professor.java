public class Professor {
	
	private String nome;
	private String endereco;
	private String telefone;
	
	public Professor(String nome, String endereco, String telefone) throws IllegalArgumentException{
		setNome(nome);
		setEndereco(endereco);
		setTelefone(telefone);
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nomeInformado) throws IllegalArgumentException {
		if (nomeInformado == null || nomeInformado.isBlank() || nomeInformado.length() < 3) {
			throw new IllegalArgumentException("ERRO: O nome não pode estar vazio e deve ter mais de 3 letras !!!");
		} 
		nome = nomeInformado;
	
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String enderecoInformado) throws IllegalArgumentException {
		if (enderecoInformado == null || enderecoInformado.isBlank() || enderecoInformado.length() < 3) {
			throw new IllegalArgumentException("ERRO: O endereço não pode estar vazio e deve ter mais de 3 letras !!!");
		} 
		endereco = enderecoInformado;
	}
	
	public String getTelefone() throws IllegalArgumentException {
		return telefone;
	}
	
	public void setTelefone(String telefoneInformado) throws IllegalArgumentException {
		if (telefoneInformado ==  null || telefoneInformado.isEmpty()) {
			throw new IllegalArgumentException("ERRO: Telefone vazio: O telefone não pode estar vazio !!!");
		}
		if (telefoneInformado.length() != 11) {
			throw new IllegalArgumentException("ERRO: Telefone inválido: O telefone deve conter exatamente 11 números sendo os 2 primeiros o DDD do estado !!!");
		}
		telefone = telefoneInformado;
	}
	
	
	
	
}
