
public class Tema {
	private Item[] listaDeItens;
	private float valorAluguel;
	private String corToalha;
	private String nomeTema;
	
	public Item[] getListaDeItens() {
		return listaDeItens;
	}
	public void setListaDeItens(Item[] listaDeItens) {
		if (listaDeItens != null) {
			this.listaDeItens = listaDeItens;
		} else {
			System.out.println("Erro no cadastro da lista de itens - Dado informado de forma incorreta");
		}
		
	}
	public float getValorAluguel() {
		return valorAluguel;
	}
	public void setValorAluguel(float valorAluguel) {
		if (valorAluguel > 0) {
			this.valorAluguel = valorAluguel;
		} else {
			System.out.println("O valor do Aluguel deve ser maior do que ZERO");
		}
		
	}
	public String getCorToalha() {
		return corToalha;
	}
	public void setCorToalha(String corToalha) {
		if (corToalha != null && !corToalha.isEmpty() && corToalha.length() >= 3) {
			this.corToalha = corToalha;
		}
		else {
			System.out.println("O nome da cor não pode estar vazio e deve conter mais de 3 digitos");
		}
	}
	
	public String getNomeTema() {
		return nomeTema;
	}
	
	public void setNomeTema(String nomeTema) {
		if (nomeTema != null && !nomeTema.isEmpty() && nomeTema.length() >= 3) {
			this.nomeTema = nomeTema;
		} else {
			System.out.println("O nome do tema não pode estar vazio de deve conter 3 letras ou mais");
		}
		
	}
}
