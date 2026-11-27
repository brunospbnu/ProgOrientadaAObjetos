package principal;

import java.awt.HeadlessException;
import java.io.IOException;

import javax.swing.JOptionPane;


/*
 * 
 * 07 - Atualização de estoque em arquivo binário:
 * 
 * Implemente um controle de estoque que armazene, para cada produto, o código (int), a 
 * quantidade disponível (int) e o preço unitário (double), nessa ordem. 
 * 
 * Inclua no menu as operações de cadastrar produto, listar o estoque, registrar entrada e registrar saída.
 * 
 * Impeça códigos duplicados e saídas superiores ao saldo. Ao registrar uma movimentação, 
 * localize o produto pelo código e atualize somente o campo da quantidade no próprio 
 * arquivo, preservando seu tamanho e os demais dados.
 * 
 */

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
		
		if (controle.getLocalArquivo() == null) {
			return;
		}
		
		try {
			controle.lerProdutos();
			JOptionPane.showMessageDialog(null, "Arquivo de dados importado da pasta !!!");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		do {
			String opcaoEmString = JOptionPane.showInputDialog(textoMenu);
			if (opcaoEmString == null) break;
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
		
		int codigo = 0;
		int qnt = 0;
		
		
		try {
			
			String codigoString = JOptionPane.showInputDialog("Informe o código do produto para registrar SAÍDA: ");
			codigo = Integer.parseInt(codigoString);
			
		} catch (HeadlessException e) {
			JOptionPane.showMessageDialog(null, "Não foi possivel encontrar o dispositivo de entrada de dados !!! ");
			return;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado informado não é um número valido !!! ");
			return;
		}
		
		
		try {
			
			String qntString = JOptionPane.showInputDialog("Informe a quantidade de SAÍDA: ");
			qnt = Integer.parseInt(qntString);
			
		} catch (HeadlessException e) {
			JOptionPane.showMessageDialog(null, "Não foi possivel encontrar o dispositivo de entrada de dados !!! ");
			return;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado informado não é um número valido !!! ");
			return;
		}
		
		try {
			controle.saidaProduto(codigo, qnt);
			JOptionPane.showMessageDialog(null, "SAÍDA registrada com sucesso.");
		} catch (IllegalArgumentException | IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return;
		}
		
	}


	private void entrada() {
		
		int codigo = 0;
		int qnt = 0;
		
		
		try {
			
			String codigoString = JOptionPane.showInputDialog("Informe o código do produto para registrar ENTRADA : ");
			codigo = Integer.parseInt(codigoString);
			
		} catch (HeadlessException e) {
			JOptionPane.showMessageDialog(null, "Não foi possivel encontrar o dispositivo de entrada de dados !!! ");
			return;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado informado não é um número valido !!! ");
			return;
		}
		
		
		try {
			
			String qntString = JOptionPane.showInputDialog("Informe a quantidade de ENTRADA: ");
			qnt = Integer.parseInt(qntString);
			
		} catch (HeadlessException e) {
			JOptionPane.showMessageDialog(null, "Não foi possivel encontrar o dispositivo de entrada de dados !!! ");
			return;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado informado não é um número valido !!!");
			return;
		}
		
		try {
			controle.entradaProduto(codigo, qnt);
			JOptionPane.showMessageDialog(null, "ENTRADA registrada com sucesso.");
		} catch (IllegalArgumentException | IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return;
		}
		
	}


	private void listar() {
		JOptionPane.showMessageDialog(null, controle.listarProdutos());
		
	}

	private void cadastrar() {
		
		int codigo = 0;
		int qntDisponivel = 0;
		double preco = 0;
		
		try {
			
			String codigoString = JOptionPane.showInputDialog("Informe o código do produto");
			codigo = Integer.parseInt(codigoString);
			
		} catch (HeadlessException e) {
			JOptionPane.showMessageDialog(null, "Não foi possivel encontrar o dispositivo de entrada de dados");
			return;
	
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado informado não é um número valido");
			return;
		}
		
		try {
			
			String qntDispString = JOptionPane.showInputDialog("Informe a quantidade disponível do produto");
			qntDisponivel = Integer.parseInt(qntDispString);
			
		} catch (HeadlessException e) {
			JOptionPane.showMessageDialog(null, "Não foi possivel encontrar o dispositivo de entrada de dados");
			return;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado informado não é um número valido");
			return;
		}
		
		try {
			
			String precoString = JOptionPane.showInputDialog("Informe o preço do produto");
			preco = Double.parseDouble(precoString);
			
		} catch (HeadlessException e) {
			JOptionPane.showMessageDialog(null, "Não foi possivel encontrar o dispositivo de entrada de dados");
			return;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado informado não é um número valido");
			return;
		}
		
		
		
		try {
			Produto p = new Produto(codigo, qntDisponivel, preco);
			controle.addProduto(p);
			JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return;
		}
		
	}
}
