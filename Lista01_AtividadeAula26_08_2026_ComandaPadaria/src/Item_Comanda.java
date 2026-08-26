
public class Item_Comanda {
	private Produto produtoNaComanda;
	private int quantidadeDoProduto;
	
	public Produto getProdutoNaComanda() {
		return produtoNaComanda;
	}
	
	public void setProdutoNaComanda(Produto produtoInformado) {
		if (produtoInformado != null) {
			produtoNaComanda = produtoInformado;
		} else {
			System.out.println("Erro: O produto informando não pode estar vazio !!! ");
		}
		
	}
	
	public int getQuantidadeDoProduto() {
		return quantidadeDoProduto;
	}
	
	public void setQuantidadeDoProduto(int quantidadeInformada) {
		
		if (quantidadeInformada >= 0) {
			quantidadeDoProduto = quantidadeInformada;
		} else {
			System.out.println("Erro: A quantidade do produto não pode ser negativa !!! ");
		}
		
	}
}
