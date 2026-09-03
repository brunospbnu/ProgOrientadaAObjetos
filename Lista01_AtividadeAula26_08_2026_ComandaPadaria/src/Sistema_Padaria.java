import javax.swing.JOptionPane;

public class Sistema_Padaria {
	/*
	
	Para futura utilização:
	
	private Scanner teclado;
	private Comanda[] comandas;
	private Produto[] produtos;
	private int quantidadeAtualComandas;
	private int quantidadeAtualProdutos;
	
	*/
	
	
	public Sistema_Padaria() {
		
		String nome = JOptionPane.showInputDialog("Digite o nome do produto");
		String valorEmString = JOptionPane.showInputDialog("Digite o preço do produto");
		
		float valorFloat = Float.parseFloat(valorEmString);
		
		Produto p1 = new Produto(nome, valorFloat);
		
		
		Produto p2 = new Produto("Leite", 4);
		
		
		Item_Comanda item1 = new Item_Comanda();
		item1.setProdutoNaComanda(p1);
		item1.setQuantidadeDoProduto(6);
		
		Item_Comanda item2 = new Item_Comanda();
		item2.setProdutoNaComanda(p2);
		item2.setQuantidadeDoProduto(12);
		
		Comanda c1 = new Comanda();
		c1.setNumeroComanda(1);
		c1.addItem(item1);
		c1.addItem(item2);
		
		Item_Comanda item3 = new Item_Comanda();
		item3.setProdutoNaComanda(p2);
		item3.setQuantidadeDoProduto(6);
		
		Comanda c2 = new Comanda();
		c2.setNumeroComanda(2);
		c2.addItem(item3);
		
		JOptionPane.showMessageDialog(null, c1.imprimirComanda());
		JOptionPane.showMessageDialog(null, c2.imprimirComanda());
		

		
		
		/*
		
		teclado = new Scanner(System.in);
		comandas = new Comanda[50];
		produtos = new Produto[50];
		
		String menu = "\n Menu Principal - Escolha uma opção:" +
						"1 - Cadastrar Produto" +
						"2 - XXXXXX" +
						"3 - XXXXX" +
						"4 - XXXXX" +
						"5 - XXXXX" +
						"0 - XXXXX";
		//TODO fazer menu.
		
		int opcao;
		
		do {
			System.out.println(menu);
			opcao = teclado.nextInt();
			switch (opcao) {
			case 1:
				//TODO fazer opções e seus métodos.
				break;
				
			case 0 :
				System.out.println("Programa Encerrado !!!");
				break;
			default:
				break;
			}
			
		} while (opcao != 0);
		
		*/
	}
	
	
	
	public static void main(String[] args) {
		new Sistema_Padaria();
	}
}
