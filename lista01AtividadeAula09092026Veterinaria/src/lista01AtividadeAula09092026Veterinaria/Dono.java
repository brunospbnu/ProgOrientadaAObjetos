package lista01AtividadeAula09092026Veterinaria;

public class Dono {
	private String nome;
	private String telefone;
	
	public Dono(String nomeInformado, String telefoneInformado) throws Exception {
		setNome(nomeInformado);
		setTelefone(telefoneInformado);
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nomeInformado) throws Exception{
		if (nomeInformado == null || nomeInformado.isBlank() || nomeInformado.length() < 3) {
			throw new Exception("ERRO: O nome não pode estar vazio e deve ter mais de 3 letras !!!");
		} 
		nome = nomeInformado;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefoneInformado) throws Exception{
		if (telefoneInformado ==  null || telefoneInformado.isEmpty()) {
			throw new Exception("ERRO: Telefone vazio: O telefone não pode estar vazio !!!");
		}
		if (!telefoneInformado.matches("^[0-9]+$")) {
			throw new Exception("ERRO: Informe somente números para o telefone, não utilize parenteses e nenhum tipo de traço");
		}
		if (telefoneInformado.length() != 11) {
			throw new Exception("ERRO: Telefone inválido: O telefone deve conter exatamente 11 números (somente números) sendo os 2 primeiros o DDD do estado !!!");
		}
		telefone = telefoneInformado;
	}
	
	
}
