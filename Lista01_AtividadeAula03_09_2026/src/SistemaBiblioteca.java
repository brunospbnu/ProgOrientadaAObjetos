import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
							+ "3 - Cadastrar Empréstimo\n"
							+ "4 - Listar Livros\n"
							+ "5 - Listar Clientes\n"
							+ "6 - Listar Empréstimos\n"
							+ "7 - Deletar Livro\n"
							+ "8 - Deletar Cliente\n"
							+ "9 - Deletar Empréstimo\n"
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
			case 7:
				deletarLivro();
				break;
			case 8:
				deletarCliente();
				break;
			case 9:
				deletarEmprestimo();
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
		
		if (clientes == null || clientes.isEmpty() || livros == null || livros.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Não há clientes OU Não há livros cadastrados - Retornando ao menu principal");
			
		}
		
		else {
			
			String[] vetorTempNomesClientes = new String [clientes.size()];
			
			for (int i = 0; i < clientes.size(); i++) {
				vetorTempNomesClientes[i] = clientes.get(i).getNomeCliente();
			}
			
			int opçao = JOptionPane.showOptionDialog(null, ("Selecione o cliente:"), "Escolha:", 0, JOptionPane.QUESTION_MESSAGE, null, vetorTempNomesClientes, vetorTempNomesClientes[0]);
			
			
			if (opçao == -1) {
				return;
			} 
			
			Emprestimo EmprestimoAAdicionar = new Emprestimo(clientes.get(opçao));
			
			
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			
			String dataEscolhida = JOptionPane.showInputDialog(" ---- Cadastro de Emprestimo ---- \n Informe a data do emprestimo (DD/MM/AAAA): ");
			
			boolean dataValida = false;
			
			Date dataConvertida = null;
			
			while (!dataValida) {
				
				try {
					dataConvertida = formato.parse(dataEscolhida);
					JOptionPane.showMessageDialog(null, "Data capturada com sucesso: " + formato.format(dataConvertida));
					System.out.println("Data capturada com sucesso: " + formato.format(dataConvertida));
					dataValida = true;
					} 
				
				catch (Exception e) {
					dataEscolhida = JOptionPane.showInputDialog("Erro: Formato de data inválido! Use o padrão dd/mm/aaaa.");
					
				}
			}
	
			EmprestimoAAdicionar.setDataEmprestimo(dataConvertida);
			
			
			String[] vetorTempLivros = new String [livros.size()];
			
			int adicionarOutro = 0;
			
			while (adicionarOutro == 0) {
				
				
				for (int i = 0; i < livros.size(); i++) {
					vetorTempLivros[i] = "Cód: " + livros.get(i).getCodigoLivro() + "Título: "+ livros.get(i).getTituloLivro();
				}
				
				opçao = JOptionPane.showOptionDialog(null, ("Selecione o Livro:"), "Escolha:", 0, JOptionPane.QUESTION_MESSAGE, null, vetorTempLivros, vetorTempLivros[0]);
				
				EmprestimoAAdicionar.addLivro(livros.get(opçao));
				
				
				String[] opcoesDaTelaAdicionarOutro = new String[2];
				opcoesDaTelaAdicionarOutro[0] = "SIM";
				opcoesDaTelaAdicionarOutro[1] = "NÃO";
				
				adicionarOutro = JOptionPane.showOptionDialog(null, "Deseja adicionar outro Livro? ", "Menu de escolha", 0, JOptionPane.QUESTION_MESSAGE, null, opcoesDaTelaAdicionarOutro, opcoesDaTelaAdicionarOutro);
						
			}
			
			emprestimos.add(EmprestimoAAdicionar);
		}
		
		
	
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
		String listaDeEmprestimos = "Lista de Empréstimos:\n";
		
		for (int i = 0; i < emprestimos.size(); i++) {
			listaDeEmprestimos += emprestimos.get(i).imprimirDados();
			
		}
		
		JOptionPane.showMessageDialog(null, listaDeEmprestimos);
	}
	
	private void deletarLivro() {
		
		if (livros == null || livros.isEmpty()) {
			
			JOptionPane.showMessageDialog(null, "Não há livros cadastrados !!!");
			return;
		}
		
		String[] vetorTempLivros = new String [livros.size()];
		
		for (int i = 0; i < livros.size(); i++) {
			vetorTempLivros[i] = livros.get(i).getTituloLivro();
		}
		
		int opçao = JOptionPane.showOptionDialog(null, ("Selecione o Livro para deletar feche em X para cancelar:"), "Escolha:", 0, JOptionPane.QUESTION_MESSAGE, null, vetorTempLivros, vetorTempLivros[0]);
		
		
		if (opçao == -1) {
			return;
		} 
		
		livros.remove(opçao);
		
	}
	
	private void deletarCliente() {
		
		
		if (clientes == null || clientes.isEmpty()) {
			
			JOptionPane.showMessageDialog(null, "Não há clientes cadastrados !!!");
			return;
		}

		String[] vetorTempClientes = new String [clientes.size()];
		
		for (int i = 0; i < clientes.size(); i++) {
			vetorTempClientes[i] = clientes.get(i).getNomeCliente();
		}
		
		int opçao = JOptionPane.showOptionDialog(null, ("Selecione o Cliente para deletar feche em X para cancelar:"), "Escolha:", 0, JOptionPane.QUESTION_MESSAGE, null, vetorTempClientes, vetorTempClientes[0]);
		
		
		if (opçao == -1) {
			return;
		} 
		
		clientes.remove(opçao);
		
	}
	
	private void deletarEmprestimo() {
		
		if (emprestimos == null || emprestimos.isEmpty()) {
			
			JOptionPane.showMessageDialog(null, "Não há empréstimos cadastrados !!!");
			return;
		}
		
		String[] vetorTempEmprestimos = new String [emprestimos.size()];
		
		for (int i = 0; i < emprestimos.size(); i++) {
			vetorTempEmprestimos[i] = "Cliente: " + emprestimos.get(i).getClienteDoEmprestimo().getNomeCliente() + "Data: " + emprestimos.get(i).getDataEmprestimo();
		}
		
		int opçao = JOptionPane.showOptionDialog(null, ("Selecione o Cliente para deletar feche em X para cancelar:"), "Escolha:", 0, JOptionPane.QUESTION_MESSAGE, null, vetorTempEmprestimos, vetorTempEmprestimos[0]);
		
		
		if (opçao == -1) {
			return;
		} 
		
		emprestimos.remove(opçao);
		
	}
	
	
	public static void main(String[] args) {
		new SistemaBiblioteca();
	}
}
