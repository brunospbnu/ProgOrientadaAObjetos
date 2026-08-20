import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		
		String menuTexto = "\n ----- Menu Principal - Escolha uma opção: ----- \n" 
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
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Lista de Alugueis cadastrados: \n");
		for (int i = 0; i < alugueis.length; i++) {
			if (alugueis[i] == null) {
				break;
			}
			Tema temaAAnalisarAgora = new Tema();
			temaAAnalisarAgora = alugueis[i].getTema();
			String nomeTemaAMencionar = temaAAnalisarAgora.getNomeTema();
			Cliente clienteAAnalisarAgora = new Cliente();
			clienteAAnalisarAgora = alugueis[i].getCliente();
			String nomeClienteAMencionar = clienteAAnalisarAgora.getNome();
			
			System.out.println((i+1) + ") Data: " + formato.format(alugueis[i].getData()) 
												+ " \n Hora Inicio: " + alugueis[i].getHorainicio() 
												+ " \n Hora Fim: " + alugueis[i].getHoraFim() 
												+ " \n Tema: " + nomeTemaAMencionar 
												+ " \n Cliente: " + nomeClienteAMencionar
												+ " \n Endereço do Evento: " + alugueis[i].getEndereço());
		}
		
	}

	private void listarTemas() {
		System.out.println("Lista de Temas cadastrados: \n");
		for (int i = 0; i < temas.length; i++) {
			if (temas[i] == null) {
				break;
			}
			System.out.println((i+1)+ ") Nome do Tema :" + temas[i].getNomeTema() + " | Valor Aluguel:  " + temas[i].getValorAluguel() + " | Cor da Toalha: " +
					temas[i].getCorToalha());
			Item[] itensDoTema = temas[i].getListaDeItens();
			for (int j = 0; j < itensDoTema.length-1; j++) {
				if (itensDoTema[j] == null) {
					break;
				}
				String nomeItemAtual = itensDoTema[j].getNome();
				int quantItemAtual = itensDoTema[j].getQnt();
				System.out.println("Item Sequencial nº " + (j+1) + ") Nome: " + nomeItemAtual + " - Quantidade = " + quantItemAtual);
			}
			System.out.println("");
				}
			System.out.println("\n Fim da lista \n ");
		
	}

	private void listarClientes() {
		System.out.println("Lista de clientes cadastrados: \n");
		for (int i = 0; i < quantAtualClientes; i++) {
			System.out.println((i+1)+ ") Nome: " + clientes[i].getNome() + " - " + clientes[i].getTelefone() + "\n Data Cadastro: " +
								clientes[i].getDataPrimeiroCadastro());
		}
		System.out.println("\n Fim da lista \n ");
		
	}

	private void inserirAluguel() {
		System.out.println(" ---- Cadastro de Aluguel ---- \n Informe a data do evento (DD/MM/AAAA): ");
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String dataEscolhida = teclado.next();
		boolean dataValida = false;
		Date dataConvertida = null;
		while (!dataValida) {
			
			try {
				dataConvertida = formato.parse(dataEscolhida);
				System.out.println("Data capturada com sucesso: " + formato.format(dataConvertida));
				dataValida = true;
				} 
			
			catch (ParseException e) {
				System.out.println("Erro: Formato de data inválido! Use o padrão dd/mm/aaaa.");
				dataEscolhida = teclado.next();
				
			}
		}
		
		System.out.print("Informe a hora de inicio do evento, de 0 até 23: ");
		int horaInicioEscolhida = teclado.nextInt();
		while (horaInicioEscolhida < 0 || horaInicioEscolhida > 23) {
			System.out.println("A hora de inicio deve estar entre 0 e 23 - Informe corretamente: ");
			horaInicioEscolhida = teclado.nextInt();
		}
		System.out.println("Hora INICIO definida !");
		
		
		System.out.println("Informe a hora de fim do evento, de 0 até 23");
		int horaFimEscolhida = teclado.nextInt();
		while (horaFimEscolhida < 0 || horaFimEscolhida >23) {
			System.out.println("A hora de inicio deve estar entre 0 e 23 - Informe corretamente: ");
			horaFimEscolhida = teclado.nextInt();
		}
		System.out.println("Hora FIM definida !");
		
		
		System.out.println("Selecione o tema conforme a lista abaixo: ");
		listarTemas();
		System.out.print("Informe o número do Tema escolhido: ");
		int temaEscolhido = teclado.nextInt();
		temaEscolhido = temaEscolhido - 1;
		Tema temaAtual = temas[temaEscolhido];
		System.out.println("Tema definido !");
		
		
		System.out.println("Selecione o cliente conforme a lista abaixo: ");
		listarClientes();
		System.out.print("Informe o número do Cliente escolhido: ");
		int clienteEscolhido = teclado.nextInt();
		clienteEscolhido = clienteEscolhido - 1;
		Cliente clienteAtual = clientes[clienteEscolhido];
		System.out.println("Cliente definido !");
		
		
		System.out.print("Informe o endereço do evento em texto livre: ");
		String endereçoDigitado = teclado.next();
		while (endereçoDigitado == null || endereçoDigitado.isEmpty() || endereçoDigitado.length() < 3) {
			System.out.print("Endereço inválido, informe um com 3 letras ou mais: ");
			endereçoDigitado = teclado.next();
		}
		
		
		Aluguel aluguelAtual = new Aluguel();
		aluguelAtual.setData(dataConvertida);
		aluguelAtual.setHorainicio(horaInicioEscolhida);
		aluguelAtual.setHoraFim(horaFimEscolhida);
		aluguelAtual.setTema(temaAtual);
		aluguelAtual.setCliente(clienteAtual);
		aluguelAtual.setEndereço(endereçoDigitado);
		
		alugueis[quantAtualAluguel] = aluguelAtual;
		quantAtualAluguel++;
		
		System.out.println("ALUGUEL CADASTRADO !!! ");
		
	}

	private void inserirTema() {
		System.out.print("----- Cadastro de Tema para os alugueis ----- \n Digite o nome do Tema: ");
		String nomeTema = teclado.next();
		while (nomeTema.length() <3) {
			System.out.print("O nome do Tema deve ter 3 letras ou mais - Informe um corretamente: ");
			nomeTema = teclado.next();
		}
		
		System.out.print("Digite a cor da Toalha: ");
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
		
		
		System.out.println("Iniciando o cadastro dos Itens do Tema: ");
		Item[] itensAdicionados = new Item[20];
		int quantItensAdicionados = 0;
		int perguntaAdicionarOutro = 0;
		
		System.out.print("Deseja adicionar um item? \n 1 - SIM \n 2 - NÃO \n");
		perguntaAdicionarOutro = teclado.nextInt();
		
		while (perguntaAdicionarOutro == 1) {
			System.out.print("Informe o nome do item: ");
			String nomeItemAAdicionar = teclado.next();
			while (nomeItemAAdicionar.length() < 3) {
				System.out.print("Deve ter pelo menos 3 letras - Informe corretamente: ");
				nomeItemAAdicionar = teclado.next();
			}
			System.out.print("Informe a quantidade do item: ");
			int quantItemAtual = teclado.nextInt();
			while (quantItemAtual <=0) {
				System.out.print("A quantidade deve ser maior do que ZERO - Informe corretamente: ");
				quantItemAtual = teclado.nextInt();
			}
			Item itemAtual = new Item();
			itemAtual.setNome(nomeItemAAdicionar);
			itemAtual.setQnt(quantItemAtual);
			itensAdicionados[quantItensAdicionados] = itemAtual;
			quantItensAdicionados++;
			System.out.println("Item Adicionado !!!");
			System.out.print("Deseja adicionar outro item? \n 1 - SIM \n 2 - NÃO \n");
			perguntaAdicionarOutro = teclado.nextInt();
			while (perguntaAdicionarOutro > 2  || perguntaAdicionarOutro < 1) {
				System.out.print("Opção invalida - Informe corretamente (1 ou 2): ");
				perguntaAdicionarOutro = teclado.nextInt();
			}
			
		}
		
		Tema temaAtual = new Tema();
		temaAtual.setNomeTema(nomeTema);
		temaAtual.setCorToalha(corToalha);
		temaAtual.setValorAluguel(valorAluguel);
		temaAtual.setListaDeItens(itensAdicionados);
		temas[quantAtualTema] = temaAtual;
		quantAtualTema++;
		
		System.out.println("TEMA ADICIONADO !!! ");
		
	}

	private void inserirCliente() {
		
		System.out.print("Digite o nome do cliente: ");
		String nome = teclado.next();
		while (nome.length() <3) {
			System.out.print("O nome do cliente deve ter 3 letras ou mais - Informe um corretamente: ");
			nome = teclado.next();
		}
		
		System.out.print("Digite o telefone do cliente: ");
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
		
		System.out.println("Cliente cadastrado !!!");
		
	}

	public static void main(String[] args) {
		new GerenciarFesta();
	}
}
