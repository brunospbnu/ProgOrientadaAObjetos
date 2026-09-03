import java.util.ArrayList;
import java.util.List;

public class Comanda {
	private int numeroComanda;
	
	// Se fosse vetor: private Item_Comanda[] itensDaComanda;
	// Se fosse vetor: private int quantidadeDeProdutosNaComanda;
	
	private List<Item_Comanda> itens;
	
	
	public Comanda() {
		// Se fosse vetor: itensDaComanda = new Item_Comanda[50];
		//Mas vamos fazer uma lista maleavel de objetos / felxivel.
		itens = new ArrayList<Item_Comanda>();
		// Se fosse vetor seria : quantidadeDeProdutosNaComanda = 0;
	}
	
	
	public List<Item_Comanda> getItensDaComanda() {
		return itens;
	}
	
	public void setItensDaComanda(List<Item_Comanda> itensInformados) {
		if (itensInformados != null) {
			itens = itensInformados;
		} else {
			System.out.println("Os itens informandos não podem estar vazios !!! ");
		}
		
	}

	public int getNumeroComanda() {
		return numeroComanda;
	}

	public void setNumeroComanda(int numeroInformado) {
		if (numeroInformado > 0) {
			numeroComanda = numeroInformado;
		} else {
			System.out.println("Erro: O número informado deve ser maior do que zero !!! ");
		}
		
	}
	
	public void addItem(Item_Comanda itemInformado) {
		if (itemInformado != null) {
			itens.add(itemInformado);
		} else {
			System.out.println("O item deve ser informado !!! ");
		}
	}
	
	public String imprimirComanda() {
		System.out.println("Comanda nº " + numeroComanda);
		String dadosDaComanda = ("Comanda nº " + numeroComanda + " \nLista de Itens");
		for (int i = 0; i < itens.size(); i++) {
			dadosDaComanda = dadosDaComanda + "\n" + (i+1) + "º)" + itens.get(i).getProdutoNaComanda().getNomeProduto() + " Valor: R$" 
		+ itens.get(i).getProdutoNaComanda().getValorUnitario() + " - " + itens.get(i).getQuantidadeDoProduto();
			
			if (itens.get(i).getQuantidadeDoProduto() == 1) {
				dadosDaComanda = dadosDaComanda + " item";
			} else {
				dadosDaComanda = dadosDaComanda + " itens";
			}
		}
		
		/*
		 
		  Outra opção de FOR:
		 
		for (Item_Comanda item : itens) {
			dadosDaComanda = dadosDaComanda + "\n"  + item.getProdutoNaComanda().getNomeProduto() + " Valor: R$" 
					+ item.getProdutoNaComanda().getValorUnitario() + " - " + item.getQuantidadeDoProduto();
						
						if (item.getQuantidadeDoProduto() == 1) {
							dadosDaComanda = dadosDaComanda + " item";
						} else {
							dadosDaComanda = dadosDaComanda + " itens";
						}
		}
		
		*/
		
		return dadosDaComanda;
	}
	
}
