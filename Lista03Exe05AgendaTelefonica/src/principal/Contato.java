package principal;

public class Contato {
	
	private int codigo;
	private String nome;
	private String telefone;
	
	public Contato(int codigo, String nome, String telefone) {
		setCodigo(codigo);
		setNome(nome);
		setTelefone(telefone);
	}

	
	public int getCodigo() {
		return codigo;
	}

	
	public void setCodigo(int codigo) {
		if (codigo <0) {
			throw new IllegalArgumentException("O codigo não pode ser menor que zero !!!");
		}
		this.codigo = codigo;
	}

	
	public String getNome() {
		return nome;
	}

	
	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public String getTelefone() {
		return telefone;
	}

	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}
