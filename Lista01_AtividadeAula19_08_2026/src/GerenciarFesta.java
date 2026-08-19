import java.util.Date;
import java.util.Scanner;

public class GerenciarFesta {
	Scanner teclado;
	private Cliente[] clientes;
	private Tema[] temas;
	private Aluguel[] alugueis;
	private int quantAtualClientes;
	private int quantAtualTema;
	private int quantAtualAluguel;
	
	public GerenciarFesta() {
		teclado = new Scanner(System.in);
		clientes = new Cliente[20];
		temas = new Tema[20];
		alugueis = new Aluguel[20];
		
		String menuTexto = "\n Menu Principal - Escolha uma opção: \n" 
						+ "1 - inserir cliente \n"
						+ "2 - inserir tema\n"
						+ "3 - inserir aluguel\n"
						+ "4 - listar clientes\n"
						+ "5 - listar temas\n"
						+ "6 - listar alugueis\n"
						+ "0 = sair";
		
		int opcao = 0;
		
		do {
			System.out.println(menuTexto + ":");
			opcao = teclado.nextInt();
			
			switch (opcao) {
			case 1:
				inserirCliente();
				break;
			case 2:
				inserirTema();
				break;
			case 3:
				inserirAluguel();
				break;
			case 4:
				listarClientes();
				break;
			case 5:
				listarTemas();
				break;
			case 6:
				listarAlugueis();
				break;
			case 0:
				System.out.println(" Sistema Encerrado ");
				break;

			default:
				System.out.println(" Opção Inválida !!! ");
				break;
			}
		} while (opcao != 0);
	}
	
	private void listarAlugueis() {
		// TODO fazer o metodo para listar alugueis.
		
	}

	private void listarTemas() {
		// TODO fazer o metodo para listar temas.
		
	}

	private void listarClientes() {
		System.out.println("Lista de clientes cadastrados: \n");
		for (int i = 0; i < quantAtualClientes; i++) {
			System.out.println("Nome:" + clientes[i].getNome() + " - " + clientes[i].getTelefone() + "\n Data Cadastro: " +
								clientes[i].getDataPrimeiroCadastro());
		}
		System.out.println("\n Fim da lista \n ");
		
		if (quantAtualClientes == 0) {
			System.out.println("NÃO HÁ CLIENTES CADASTRADOS !!!");
		}
		
	}

	private void inserirAluguel() {
		// TODO Fazer o metodo para inserir alugueis.
		
	}

	private void inserirTema() {
		System.out.print("Cadastro de Tema para os alugueis\n Digite o nome do Tema: ");
		String nomeTema = teclado.next();
		while (nomeTema.length() <3) {
			System.out.print("O nome do Tema deve ter 3 letras ou mais - Informe um corretamente: ");
			nomeTema = teclado.next();
		}
		
		System.out.print("Digite a cor da Toalha");
		String corToalha = teclado.next();
		while (corToalha.length() < 3) {
			System.out.print("A cor deve ter pelo menos 3 letras - Informe corretamente: ");
			corToalha = teclado.next();
		}
		
		System.out.print("Digite o valor do Aluguel: ");
		float valorAluguel = teclado.nextFloat();
		while (valorAluguel <= 0) {
			System.out.print("O valor do aluguel deve ser maior que ZERO - Informe corretamente: ");
			valorAluguel = teclado.nextFloat();
		}
		
	
		//TODO terminar o metodo de inserir tema.
		
		
	}

	private void inserirCliente() {
		
		System.out.print("Digite o nome do cliente: ");
		String nome = teclado.next();
		while (nome.length() <3) {
			System.out.print("O nome do cliente deve ter 3 letras ou mais - Informe um corretamente: ");
			nome = teclado.next();
		}
		
		System.out.print("Digite o telefone do cliente");
		String telefone = teclado.next();
		while (telefone.length() < 11) {
			System.out.print("O telefone deve conter 11 digitos - Informe um corretamente: ");
			telefone = teclado.next();
		}
		
		Cliente c1 = new Cliente();
		c1.setNome(nome);
		c1.setTelefone(telefone);
		c1.setDataPrimeiroCadastro(new Date());
		
		clientes[quantAtualClientes] = c1;
		quantAtualClientes++;
		
	}

	public static void main(String[] args) {
		new GerenciarFesta();
	}
}
