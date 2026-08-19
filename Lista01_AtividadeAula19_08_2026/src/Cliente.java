import java.util.Date;

public class Cliente {
	private String telefone;
	private String nome;
	private Date dataPrimeiroCadastro;
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		if (telefone != null && !telefone.isEmpty() && telefone.length() == 11) {
			this.telefone = telefone;
		}
		else {
			System.out.println("O telefone não pode estar vazio e deve conter 11 digitos (código de area = 2 / número = 9), somente números");
		}
		
	}
	
	public Date getDataPrimeiroCadastro() {
		return dataPrimeiroCadastro;
	}
	
	public void setDataPrimeiroCadastro(Date dataPrimeiroCadastro) {
		if (dataPrimeiroCadastro != null ) {
			this.dataPrimeiroCadastro = dataPrimeiroCadastro;
		}
		else {
		System.out.println("A data do cadastro não pode estar vazia");
		}
		
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		if (nome != null && !nome.isEmpty() && nome.length() >= 3) {
			this.nome = nome;
		}
		else {
			System.out.println("O nome não pode estar vazio e deve conter 3 letras ou mais");
		}
		
		
	}
	
	
}
