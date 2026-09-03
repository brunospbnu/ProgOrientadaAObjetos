import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/*
Exercício Bibblioteca:

Uma biblioteca deseja desenvolver um sistema simples para organizar seus livros e empréstimos.
A biblioteca possui vários livros cadastrados. Cada livro possui um código e um título.
Os clientes da biblioteca também são cadastrados no sistema. Cada cliente possui um código, um nome e um e-mail.
Quando um cliente realiza um empréstimo, deve ser registrada a data do empréstimo. Um empréstimo pertence a apenas um cliente e este pode possuir vários livros. 
Para representar os livros associados a um empréstimo, deve ser utilizada uma coleção do tipo List.

Faça o diagrama de classes, a implementação das classes modelo e da classe Principal.

 */

public class SistemaBiblioteca {
	List<Emprestimo> emprestimos;
	List<Cliente> clientes;
	List<Livro> livros;
	

	public SistemaBiblioteca() {
		emprestimos = new ArrayList<Emprestimo>();
		clientes = new ArrayList<Cliente>();
		livros = new ArrayList<Livro>();
		
		String textoDoMenu = "----- MENU PRINCIPAL - Escolha uma opção ------ \n"
							+ "1 - Cadastrar Livro \n" 
							+ "2 - Cadastrar Cliente\n"
							+ "3 - Cadastrar Cadastrar Empréstimo\n"
							+ "4 - Listar Livros\n"
							+ "5 - Listar Clientes\n"
							+ "6 - Listar Empréstimos\n"
							+ "0 - Encerrar Sistema\n";
		String opcaoEmString;
		int opcao = -1;
		
		do {
			
			opcaoEmString = JOptionPane.showInputDialog(textoDoMenu);
			
			try {
				opcao = Integer.parseInt(opcaoEmString);
				
			} catch (Exception e) {
				
			}
			
			switch (opcao) {
			case 1:
				cadastrarLivro();
				break;
			case 2:
				cadastrarCliente();
				break;
			case 3:
				cadastarEmprestimo();
				break;
			case 4:
				listarLivros();
				break;
			case 5:
				listarClientes();
				break;
			case 6:
				listarEmprestimos();
				break;
			case 0:
				JOptionPane.showMessageDialog(null, "Sistema Encerrado !!!");
				break;

			default:
				JOptionPane.showMessageDialog(null, "Opção invalida - Retornando ao Menu Principal !!!");
				break;
			}
		} while (opcao != 0);
				
	}
	
	private void cadastrarLivro() {
		
		int codigoInformado = 0;
		
		while (codigoInformado <= 0) {
			try {
				String codigoInformadoEmString = JOptionPane.showInputDialog("Informe o código do Livro - Número inteiro:");
				codigoInformado = Integer.parseInt(codigoInformadoEmString);
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Código Inválido - Retornando à solicitação de código");
			}
		}
		
		String tituloInformado = JOptionPane.showInputDialog("Informe o Título do Livro:");
		
		Livro livroAtual = new Livro(codigoInformado,tituloInformado);
		
		livros.add(livroAtual);
	}
	
	private void cadastrarCliente() {
		
		int codigoInformado = 0;
		
		while (codigoInformado <= 0) {
			try {
				String codigoInformadoEmString = JOptionPane.showInputDialog("Informe o código do Cliente - Número inteiro:");
				codigoInformado = Integer.parseInt(codigoInformadoEmString);
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Código Inválido - Retornando à solicitação de código");
			}
		}		
		
		String nomeInformado = JOptionPane.showInputDialog("Informe o nome do Cliente:");
		
		String emailInformado = JOptionPane.showInputDialog("Informe o e-mail do Cliente:");
		
		
		Cliente clienteAtual = new Cliente(codigoInformado, nomeInformado, emailInformado);
		
		clientes.add(clienteAtual);
	}
	
	private void cadastarEmprestimo() {
		// TODO fazer metodo.
	}
	
	private void listarLivros() {
		
		String listaAExibir = "Lista de Livros:\n";
		
		for (int i = 0; i < livros.size(); i++) {
			listaAExibir = listaAExibir + (i+1) + "º) " + livros.get(i).imprimirDados();
		}
		
		JOptionPane.showMessageDialog(null, listaAExibir);
	}
	
	private void listarClientes() {
		
		String listaAExibir = "Lista de Clientes:\n";
		
		for (int i = 0; i < clientes.size(); i++) {
			listaAExibir = listaAExibir + (i+1) + "º) " + clientes.get(i).imprimirDados();
		}
		
		JOptionPane.showMessageDialog(null, listaAExibir);
	}
	
	private void listarEmprestimos() {
		// TODO fazer metodo.
	}
	
	
	public static void main(String[] args) {
		new SistemaBiblioteca();
	}
}
