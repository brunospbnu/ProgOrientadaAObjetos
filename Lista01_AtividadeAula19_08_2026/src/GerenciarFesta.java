import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class GerenciarFesta {
	// Removido: Scanner teclado;
	private List<Cliente> clientes;
	private List<Tema> temas;
	private List<Aluguel> alugueis;
	/*
	Variaveis desnecessárias para ArrayList
	
	private int quantAtualClientes;
	private int quantAtualTema;
	private int quantAtualAluguel;
	
	*/
	
	public GerenciarFesta() {
		// Removido: teclado = new Scanner(System.in);
		clientes = new ArrayList<Cliente>();
		temas = new ArrayList<Tema>();
		alugueis = new ArrayList<Aluguel>();
		
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
			System.out.println(menuTexto + "\n Digite a opção: ");
			String strigOpcao = JOptionPane.showInputDialog(menuTexto + "\n Digite a opção: ");
			opcao = Integer.parseInt(strigOpcao);
			
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
				JOptionPane.showMessageDialog(null," Sistema Encerrado ");
				break;

			default:
				System.out.println(" Opção Inválida !!! ");
				JOptionPane.showMessageDialog(null," Opção Inválida !!! ");
				break;
			}
		} while (opcao != 0);
	}
	
	private void listarAlugueis() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String listaDeAlugueis = "Lista de Alugueis cadastrados: \n";
		for (int i = 0; i < alugueis.size(); i++) {
			/* 
			 	O if somente é necessário quando o vetor tem um valor já definido, para evitar imprimir null, para Array não precisa:
			  	
			  	if (alugueis[i] == null) {
				break;
			}
			*/
			
			Tema temaAAnalisarAgora = alugueis.get(i).getTema();
			String nomeTemaAMencionar = temaAAnalisarAgora.getNomeTema();
			Cliente clienteAAnalisarAgora = alugueis.get(i).getCliente();
			String nomeClienteAMencionar = clienteAAnalisarAgora.getNome();
			
			listaDeAlugueis = listaDeAlugueis + (i+1) + ") Data: " + formato.format(alugueis.get(i).getData()) 
												+ " \n Hora Inicio: " + alugueis.get(i).getHorainicio() 
												+ " \n Hora Fim: " + alugueis.get(i).getHoraFim() 
												+ " \n Tema: " + nomeTemaAMencionar 
												+ " \n Cliente: " + nomeClienteAMencionar
												+ " \n Endereço do Evento: " + alugueis.get(i).getEndereço();
		}
		
		JOptionPane.showMessageDialog(null, listaDeAlugueis);
	}
	
	/* 
	 Se dois metodos tiverem o mesmo nome, um sem parametro e outro com, o Java vai saber qual utilizar com base no parametro passado ou não.
	 Isso se chama Polimorfismo de métodos ou sobrecarga de métodos.
	*/
	private void listarTemas() {
		String listaDeTemas = "Lista de Temas cadastrados: \n";
		for (int i = 0; i < temas.size(); i++) {
			
			/*
			if (temas[i] == null) {
				break;
			}
			*/
			
			listaDeTemas = listaDeTemas + ((i+1)+ ") Nome do Tema :" + temas.get(i).getNomeTema() + " | Valor Aluguel:  " + temas.get(i).getValorAluguel() + " | Cor da Toalha: " +
					temas.get(i).getCorToalha() + "\n");
			
			List<Item> itensDoTema = temas.get(i).getListaDeItens();
			
			for (int j = 0; j < itensDoTema.size(); j++) {
				
				/*
				if (itensDoTema[j] == null) {
					break;
				}
				*/
				
				String nomeItemAtual = itensDoTema.get(j).getNome();
				int quantItemAtual = itensDoTema.get(j).getQnt();
				
				listaDeTemas = listaDeTemas + "Item Sequencial nº " + (j+1) + ") Nome: " + nomeItemAtual + " - Quantidade = " + quantItemAtual + "\n";
			}
			
			listaDeTemas = listaDeTemas + "\n";
				}
		listaDeTemas = listaDeTemas + "\n Fim da lista \n ";
		
		JOptionPane.showMessageDialog(null, listaDeTemas);
		
	}
	
	@SuppressWarnings("unused")
	private void listarUmTema (int indice) {
		System.out.println((indice+1)+ ") Nome do Tema :" + temas.get(indice).getNomeTema() + " | Valor Aluguel:  " + temas.get(indice).getValorAluguel() + " | Cor da Toalha: " +
				temas.get(indice).getCorToalha());
		List<Item> itensDoTema = temas.get(indice).getListaDeItens();
		
		for (int j = 0; j < itensDoTema.size(); j++) {
			/*
			if (itensDoTema[j] == null) {
				break;
			}
			*/
			String nomeItemAtual = itensDoTema.get(j).getNome();
			int quantItemAtual = itensDoTema.get(j).getQnt();
			System.out.println("Item Sequencial nº " + (j+1) + ") Nome: " + nomeItemAtual + " - Quantidade = " + quantItemAtual);
		}
	}

	private void listarClientes() {
		String listaDeClientes = "Lista de clientes cadastrados: \n";
		for (int i = 0; i < clientes.size(); i++) {
			listaDeClientes = listaDeClientes + "\n" + (i+1)+ ") Nome: " + clientes.get(i).getNome() + " - " + clientes.get(i).getTelefone() + "\n Data Cadastro: " +
								clientes.get(i).getDataPrimeiroCadastro();
		}
		listaDeClientes = listaDeClientes + "\n Fim da lista \n ";
		
		JOptionPane.showMessageDialog(null, listaDeClientes);
	}
	
	@SuppressWarnings("unused")
	private void listarUmCliente (int indiceDoCliente) {
		System.out.println((indiceDoCliente+1)+ ") Nome: " + clientes.get(indiceDoCliente).getNome() + " - " + clientes.get(indiceDoCliente).getTelefone() + "\n Data Cadastro: " +
				clientes.get(indiceDoCliente).getDataPrimeiroCadastro());
	}

	private void inserirAluguel() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String dataEscolhida = JOptionPane.showInputDialog(" ---- Cadastro de Aluguel ---- \n Informe a data do evento (DD/MM/AAAA): ");
		boolean dataValida = false;
		Date dataConvertida = null;
		while (!dataValida) {
			
			try {
				dataConvertida = formato.parse(dataEscolhida);
				JOptionPane.showMessageDialog(null, "Data capturada com sucesso: " + formato.format(dataConvertida));
				System.out.println("Data capturada com sucesso: " + formato.format(dataConvertida));
				dataValida = true;
				} 
			
			catch (ParseException e) {
				dataEscolhida = JOptionPane.showInputDialog("Erro: Formato de data inválido! Use o padrão dd/mm/aaaa.");
				
			}
		}
		
		System.out.print("Informe a hora de inicio do evento, de 0 até 23: ");
		String stringHoraEscolhida = JOptionPane.showInputDialog("Informe a hora de inicio do evento, de 0 até 23: ");
		int horaInicioEscolhida = Integer.parseInt(stringHoraEscolhida);
		
		while (horaInicioEscolhida < 0 || horaInicioEscolhida > 23) {
			System.out.println("A hora de inicio deve estar entre 0 e 23 - Informe corretamente: ");
			stringHoraEscolhida = JOptionPane.showInputDialog("A hora de inicio deve estar entre 0 e 23 - Informe corretamente: ");
			horaInicioEscolhida = Integer.parseInt(stringHoraEscolhida);
		}
		System.out.println("Hora INICIO definida !");
		JOptionPane.showMessageDialog(null, "Hora INICIO definida !");
		
		
		System.out.println("Informe a hora de fim do evento, de 0 até 23");
		String stringHoraFimEscolhida = JOptionPane.showInputDialog("Informe a hora de fim do evento, de 0 até 23");
		int horaFimEscolhida = Integer.parseInt(stringHoraFimEscolhida);
		while (horaFimEscolhida < 0 || horaFimEscolhida >23) {
			stringHoraFimEscolhida = JOptionPane.showInputDialog("A hora de inicio deve estar entre 0 e 23 - Informe corretamente: ");
			horaFimEscolhida = Integer.parseInt(stringHoraFimEscolhida);
		}
		System.out.println("Hora FIM definida !");
		JOptionPane.showMessageDialog(null,"Hora FIM definida !");
		
		
		
		System.out.println("Selecione o tema conforme a lista -  ");
		listarTemas();
		System.out.print("Informe o número do Tema escolhido: ");
		String stringTemaEscolhido = JOptionPane.showInputDialog("Selecione o tema conforme a lista - Informe o número do Tema escolhido: ");
		int temaEscolhido = Integer.parseInt(stringTemaEscolhido);
		temaEscolhido = temaEscolhido - 1;
		Tema temaAtual = temas.get(temaEscolhido);
		System.out.println("Tema definido !");
		JOptionPane.showMessageDialog(null, "Tema Definido !");
		
		
		
		System.out.println("Selecione o cliente conforme a lista - ");
		listarClientes();
		System.out.print("Informe o número do Cliente escolhido: ");
		String stringClienteEscolhido = JOptionPane.showInputDialog("Selecione o cliente conforme a lista - Informe o número do Cliente escolhido:");
		int clienteEscolhido = Integer.parseInt(stringClienteEscolhido);
		clienteEscolhido = clienteEscolhido - 1;
		Cliente clienteAtual = clientes.get(clienteEscolhido);
		System.out.println("Cliente definido !");
		JOptionPane.showMessageDialog(null, "Cliente definido !");
		
		
		System.out.print("Informe o endereço do evento em texto livre: ");
		String endereçoDigitado = JOptionPane.showInputDialog("Informe o endereço do evento em texto livre: ");
		while (endereçoDigitado == null || endereçoDigitado.isEmpty() || endereçoDigitado.length() < 3) {
			System.out.print("Endereço inválido, informe um com 3 letras ou mais: ");
			endereçoDigitado = JOptionPane.showInputDialog("Endereço inválido, informe um com 3 letras ou mais: ");
		}
		
		
		Aluguel aluguelAtual = new Aluguel();
		aluguelAtual.setData(dataConvertida);
		aluguelAtual.setHorainicio(horaInicioEscolhida);
		aluguelAtual.setHoraFim(horaFimEscolhida);
		aluguelAtual.setTema(temaAtual);
		aluguelAtual.setCliente(clienteAtual);
		aluguelAtual.setEndereço(endereçoDigitado);
		
		alugueis.add(aluguelAtual);
		
		// quantAtualAluguel++;
		
		System.out.println("ALUGUEL CADASTRADO !!! ");
		JOptionPane.showMessageDialog(null, "ALUGUEL CADASTRADO !!! ");
		
	}

	private void inserirTema() {
		System.out.print("----- Cadastro de Tema para os alugueis ----- \n Digite o nome do Tema: ");
		String nomeTema = JOptionPane.showInputDialog("----- Cadastro de Tema para os alugueis ----- \n Digite o nome do Tema: ");
		while (nomeTema.length() <3) {
			System.out.print("O nome do Tema deve ter 3 letras ou mais - Informe um corretamente: ");
			nomeTema = JOptionPane.showInputDialog("O nome do Tema deve ter 3 letras ou mais - Informe um corretamente: ");
		}
		
		System.out.print("Digite a cor da Toalha: ");
		String corToalha = JOptionPane.showInputDialog("Digite a cor da Toalha: ");
		while (corToalha.length() < 3) {
			System.out.print("A cor deve ter pelo menos 3 letras - Informe corretamente: ");
			corToalha = JOptionPane.showInputDialog("A cor deve ter pelo menos 3 letras - Informe corretamente: ");
		}
		
		System.out.print("Digite o valor do Aluguel: ");
		String stringValorAluguel = JOptionPane.showInputDialog("Digite o valor do Aluguel: ");
		float valorAluguel = Float.parseFloat(stringValorAluguel);
		while (valorAluguel <= 0) {
			System.out.print("O valor do aluguel deve ser maior que ZERO - Informe corretamente: ");
			stringValorAluguel = JOptionPane.showInputDialog("O valor do aluguel deve ser maior que ZERO - Informe corretamente: ");
			valorAluguel = Float.parseFloat(stringValorAluguel);
		}
		
		
		System.out.println("Iniciando o cadastro dos Itens do Tema: ");
		JOptionPane.showMessageDialog(null, "Iniciando o cadastro dos Itens do Tema: ");
		
		List<Item> itensAdicionados = new ArrayList<Item>();
		// int quantItensAdicionados = 0;
		int perguntaAdicionarOutro = 0;
		
		System.out.print("Deseja adicionar um item? \n 1 - SIM \n 2 - NÃO \n");
		String stringPerguntaAdicionarOutro = JOptionPane.showInputDialog("Deseja adicionar um item? \n 1 - SIM \n 2 - NÃO \n");
		
		perguntaAdicionarOutro = Integer.parseInt(stringPerguntaAdicionarOutro);
		
		while (perguntaAdicionarOutro == 1) {
			System.out.print("Informe o nome do item: ");
			String nomeItemAAdicionar = JOptionPane.showInputDialog("Informe o nome do item: ");
			while (nomeItemAAdicionar.length() < 3) {
				System.out.print("Deve ter pelo menos 3 letras - Informe corretamente: ");
				nomeItemAAdicionar = JOptionPane.showInputDialog("Deve ter pelo menos 3 letras - Informe corretamente: ");
			}
			System.out.print("Informe a quantidade do item: ");
			String stringQuantidadeItamAtual = JOptionPane.showInputDialog("Informe a quantidade do item: ");
			int quantItemAtual = Integer.parseInt(stringQuantidadeItamAtual);
			while (quantItemAtual <=0) {
				System.out.print("A quantidade deve ser maior do que ZERO - Informe corretamente: ");
				stringQuantidadeItamAtual = JOptionPane.showInputDialog("A quantidade deve ser maior do que ZERO - Informe corretamente: ");
				quantItemAtual = Integer.parseInt(stringQuantidadeItamAtual);
			}
			Item itemAtual = new Item();
			itemAtual.setNome(nomeItemAAdicionar);
			itemAtual.setQnt(quantItemAtual);
			itensAdicionados.add(itemAtual);
			
			// quantItensAdicionados++;
			
			System.out.println("Item Adicionado !!!");
			System.out.print("Deseja adicionar outro item? \n 1 - SIM \n 2 - NÃO \n");
			stringPerguntaAdicionarOutro = JOptionPane.showInputDialog("Item Adicionado !!! \n Deseja adicionar outro item? \n 1 - SIM \n 2 - NÃO \n");
			perguntaAdicionarOutro = Integer.parseInt(stringPerguntaAdicionarOutro);
			while (perguntaAdicionarOutro > 2  || perguntaAdicionarOutro < 1) {
				System.out.print("Opção invalida - Informe corretamente (1 ou 2): ");
				stringPerguntaAdicionarOutro = JOptionPane.showInputDialog("Opção invalida - Informe corretamente (1 ou 2): ");
				perguntaAdicionarOutro = Integer.parseInt(stringPerguntaAdicionarOutro);
			}
			
		}
		
		Tema temaAtual = new Tema();
		temaAtual.setNomeTema(nomeTema);
		temaAtual.setCorToalha(corToalha);
		temaAtual.setValorAluguel(valorAluguel);
		temaAtual.setListaDeItens(itensAdicionados);
		
		temas.add(temaAtual);
		
		// quantAtualTema++;
		
		System.out.println("TEMA ADICIONADO !!! ");
		JOptionPane.showMessageDialog(null, "TEMA ADICIONADO !!! ");
		
	}

	private void inserirCliente() {
		
		System.out.print("Digite o nome do cliente: ");
		String nome = JOptionPane.showInputDialog("Digite o nome do cliente: ");
		while (nome.length() <3) {
			System.out.print("O nome do cliente deve ter 3 letras ou mais - Informe um corretamente: ");
			nome = JOptionPane.showInputDialog("O nome do cliente deve ter 3 letras ou mais - Informe um corretamente: ");
		}
		
		System.out.print("Digite o telefone do cliente: ");
		String telefone = JOptionPane.showInputDialog("Digite o telefone do cliente: ");
		while (telefone.length() < 11) {
			System.out.print("O telefone deve conter 11 digitos - Informe um corretamente: ");
			telefone = JOptionPane.showInputDialog("O telefone deve conter 11 digitos - Informe um corretamente: ");
		}
		
		Cliente c1 = new Cliente();
		c1.setNome(nome);
		c1.setTelefone(telefone);
		c1.setDataPrimeiroCadastro(new Date());
		
		clientes.add(c1);
		
		// quantAtualClientes++;
		
		System.out.println("Cliente cadastrado !!!");
		
	}

	public static void main(String[] args) {
		new GerenciarFesta();
	}
}
