
public class Pessoa {
	private String nome;
	private int idade;
	private int altura;
	private boolean maiorIdade; // esse é um comentario
	
	// metodos acessores:
	
	//get - leitura:
	
	public String getNome() {
		return nome;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public int getAltura() {
		return altura;
	}
	
	public boolean getMaiorIdade() {
		if (idade > 18) {
			maiorIdade = true;
		}
		else {
			maiorIdade = false;
		}
		return maiorIdade;
	}
	
	//set - alteração
	
	public void setNome(String nome) {
		if (nome.trim().equals("") || nome.trim().length() < 3) {
			System.out.println("Nome Inválido");
		}
		else {
			this.nome = nome;
		}
		
	}
	
	}