package principal;

import javax.swing.JOptionPane;

public class Menu {
	
	private String textoMenu;
	private int opcao;
	private Controle controle;
	
	public static void main(String[] args) {
		new Menu();
	}
	
	
	public Menu() {
		textoMenu = "\nMenu --- Programa para controle de estoque: " +
				"\n 1 - Cadastrar produto" +
				"\n 2 - Listar estoque"+
				"\n 3 - Registrar entrada"+
				"\n 4 - Registrar Saída"+
				"\n 0 - Sair do Programa";
		opcao = -1;
		controle = new Controle();
		executar();
	}
	
	public void executar() {
		

		do {
			String opcaoEmString = JOptionPane.showInputDialog(textoMenu);
			try {
				opcao = Integer.parseInt(opcaoEmString);
			} catch (Exception e) {
				// Deixado vazio pois vai cair no default lá em baixo.
			}
			switch (opcao) {
			
			case 0:
				JOptionPane.showMessageDialog(null, "Sistema encerrado !!!");
				break;
				
			case 1:
				cadastrar();
				break;
				
			case 2:
				listar();
				break;
				
			case 3:
				entrada();
				break;
				
			case 4:
				saida();
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção Inválida - Tente novamente !!!");
				break;
			}
			
		} while (opcao != 0);
	}


	private void saida() {
		// TODO Auto-generated method stub
		
	}


	private void entrada() {
		// TODO Auto-generated method stub
		
	}


	private void listar() {
		// TODO Auto-generated method stub
		
	}


	private void cadastrar() {
		// TODO Auto-generated method stub
		
	}
}
