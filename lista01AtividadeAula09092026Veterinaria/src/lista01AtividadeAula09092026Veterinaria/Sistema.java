package lista01AtividadeAula09092026Veterinaria;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Sistema {
	Veterinario veterinario;
	String nomeInicialVeterinario;
	List<Animal> animais;
	
	public Sistema() throws Exception {
		nomeInicialVeterinario = "Nome não definido";
		veterinario = new Veterinario(nomeInicialVeterinario);
		String textoMenu = "MENU PRINCIPAL - Escolha uma Opção:\n \n" +
				" 1   - Veterinário: Definir / alterar nome\n" +
				" 2   - Veterinário: Visualizar nome\n" +
				" 3   - Animal: Listar todos os animais\n" +
				" 4   - Animal: Adicionar\n" +
				" 5   - Animal: Remover\n" +
				" 6   - Animal: Alterar dados\n" +
				" 7   - Animal: Adicionar peso\n" +
				" 8   - Animal: Remover peso\n" +
				" 9   - Dono: Buscar dados de contato pelo nome do animal \n" +
				" 10  - Dono: Verificar quantidade de animais de um dono \n" +
				" 11  - Dono: Listar animais de um dono\n" +
				" 12  - Cálculo / Dado: Calcular média geral dos pesos médios dos animais\n" +
				" 13  - Cálculo / Dado: Buscar animal com a maior média de peso\n" +
				" 14  - Cálculo / Dado: Verificar quantidade de animais com peso maior que o informado\n" +
				" 0   - Encerrar sistema";
		
		String opcaoEmString;

		int opcao = -1;

		do {

			try {
				opcaoEmString = JOptionPane.showInputDialog("Nome do veterinário: " + veterinario.getNome()+ "\n\n" + textoMenu);
				opcao = Integer.parseInt(opcaoEmString);
	
			} catch (Exception e) {
	
			}

			switch (opcao) {
			case 1:
				definirNomeVeterinario();
				break;
			case 2:
				visualizarNomeVeterinário();
				break;
			case 3:
				listarAnimais();
				break;
			case 4:
				adicionarAnimal();
				break;
			case 5:
				removerAnimal();
				break;
			case 6:
				alterarDadosAnimal();
				break;
			case 7:
				adicionarPeso();
				break;
			case 8:
				removerPeso();
				break;
			case 9:
				buscarDadosDonoPeloNomeAnimal();
				break;
			case 10:
				calcularQuantAnimaisDono();
				break;
			case 11:
				listarAnimaisDono();
				break;
			case 12:
				calcularMediaGeral();
				break;
			case 13:
				buscarAnimalMaiorMedia();
				break;
			case 14:
				calcularQuantAnimaisPesoMaiorQueInformado();
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

	public void definirNomeVeterinario() {
		try {
			String nomeInformado = JOptionPane.showInputDialog("Informe o nome para o veterinário: ");
			veterinario.setNome(nomeInformado);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void visualizarNomeVeterinário() {
		JOptionPane.showMessageDialog(null, "O nome do veterinário é: " + veterinario.getNome());
	}
	
	public void listarAnimais() {
		JOptionPane.showMessageDialog(null, veterinario.listarTodosAnimais());
	}
	
	public void adicionarAnimal() {
		try {
			Animal animalAAdicionar = new Animal("não definido","não definido");
			Dono donoAAdicionar = new Dono("não definido","00000000000");
			
			String nomeAnimal = JOptionPane.showInputDialog("Informe o nome do animal: ");
			animalAAdicionar.setNome(nomeAnimal);
			String especieAnimal = JOptionPane.showInputDialog("Informe a espécie do animal: ");
			animalAAdicionar.setEspecie(especieAnimal);
			String nomeDono = JOptionPane.showInputDialog("Informe o nome do dono: ");
			donoAAdicionar.setNome(nomeDono);
			String telefoneDono = JOptionPane.showInputDialog("Informe o telefone do dono (somente 11 numeros, sendo os 2 primeiros o DDD): ");
			donoAAdicionar.setTelefone(telefoneDono);
			
			animalAAdicionar.setDonoDoAnimal(donoAAdicionar);
			veterinario.addAnimal(animalAAdicionar);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void removerAnimal() {
		String animalEscolhidoString = JOptionPane.showInputDialog("Escolha o animal para excluir \n " + veterinario.listarTodosAnimais() + "\n \n Nº do animal escolhido: ");
		int animalEscolhido = -1;
		try {
			try {
				animalEscolhido = Integer.parseInt(animalEscolhidoString);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro: Opção Inválida !!!");
			}
			Animal animalEscolhidoClasse = veterinario.getAnimais().get(animalEscolhido-1);
			veterinario.excluiAnimal(animalEscolhidoClasse);
			JOptionPane.showMessageDialog(null, "Animal excluido com sucesso");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}
	
	public void alterarDadosAnimal() {
		try {
			String animalEscolhidoString = JOptionPane.showInputDialog("Digite o nome do animal para alterar: ");
			Animal animalEncontrado = veterinario.buscarAnimal(animalEscolhidoString);
			String novoNome = JOptionPane.showInputDialog("Animal " + animalEncontrado.getNome() + " encontrado. \n Informe o novo nome para esse animal: ");
			String novaEspecie = JOptionPane.showInputDialog("Informe a nova espécie: ");
			List<Float> novosPesos = new ArrayList<Float>();
			int adicionarMais = 1;
			
			do {
				String pesoAAdicionarString = JOptionPane.showInputDialog("Informe o peso a adicionar: ");
				float pesoAAdicionar = 0;
				try {
					pesoAAdicionar = Float.parseFloat(pesoAAdicionarString);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Peso inválido !!!");
				}
				novosPesos.add(pesoAAdicionar);
				adicionarMais = JOptionPane.showOptionDialog(null, "Deseja adicionar mais? ", "Adicionar mais?", 1, JOptionPane.QUESTION_MESSAGE, null, null, 0);
			} while (adicionarMais == 0);
			
			veterinario.alteraAnimal(animalEncontrado.getNome(), novoNome, novaEspecie, novosPesos);
			
			JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso !!!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}
	
	public void adicionarPeso() {
		String animalEscolhidoString = JOptionPane.showInputDialog("Escolha o animal para adicionar o peso \n " + veterinario.listarTodosAnimais() + "\n \n Nº do animal escolhido: ");
		int animalEscolhido = -1;
		try {
			try {
				animalEscolhido = Integer.parseInt(animalEscolhidoString);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro: Opção Inválida !!!");
			}
			animalEscolhido -= 1;
			
			int adicionarMais = 1;
			
			do {
				String pesoAAdicionarString = JOptionPane.showInputDialog("Informe o peso a adicionar: ");
				float pesoAAdicionar = 0;
				try {
					pesoAAdicionar = Float.parseFloat(pesoAAdicionarString);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Peso inválido !!!");
				}
				veterinario.getAnimais().get(animalEscolhido).addPeso(pesoAAdicionar);
				adicionarMais = JOptionPane.showOptionDialog(null, "Deseja adicionar mais? ", "Adicionar mais?", 1, JOptionPane.QUESTION_MESSAGE, null, null, 0);
			} while (adicionarMais == 0);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}
	
	public void removerPeso() {
		
		String animalEscolhidoString = JOptionPane.showInputDialog("Escolha o animal para excluir o peso \n " + veterinario.listarTodosAnimais() + "\n \n Nº do animal escolhido: ");
		int animalEscolhido = -1;
		try {
			try {
				animalEscolhido = Integer.parseInt(animalEscolhidoString);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro: Opção Inválida !!!");
			}
			String pesoARemoverString = JOptionPane.showInputDialog("Escolha o peso para remover: " + veterinario.getAnimais().get(animalEscolhido-1).listarPesos());
			int pesoARemover = Integer.parseInt(pesoARemoverString);
			veterinario.getAnimais().get(animalEscolhido-1).removePeso(pesoARemover-1);
			JOptionPane.showMessageDialog(null, "Peso removido com sucesso !!!");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}
	
	public void buscarDadosDonoPeloNomeAnimal() {
		try {
			String nomeAnimalBuscar = JOptionPane.showInputDialog("Informe o nome do animal para buscar os dados do dono:");
			String dadosLocalizados = veterinario.buscarDadosContatoDonoPeloNomeAnimal(nomeAnimalBuscar);
			JOptionPane.showMessageDialog(null, dadosLocalizados);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}
	
	public void calcularQuantAnimaisDono () {
		try {
			String nomeDonoABuscar = JOptionPane.showInputDialog("Informe o nome do dono para calcular: ");
			int quantidadeLocalizada = veterinario.calculaQuantAnimaisDono(nomeDonoABuscar);
			JOptionPane.showMessageDialog(null, "Foram localizados " + quantidadeLocalizada + " animais para o dono " + nomeDonoABuscar);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void listarAnimaisDono () {
		try {
			String nomeDonoAListar = JOptionPane.showInputDialog("Informe o nome do dono para listar os animais: ");
			String dadosObtidos = veterinario.listarAnimaisDono(nomeDonoAListar);
			JOptionPane.showMessageDialog(null, dadosObtidos);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}
	
	public void calcularMediaGeral () {
		JOptionPane.showMessageDialog(null, "A media geral dos pesos médios de todos os animais é: " + veterinario.calculaMediaGeralPesosAnimais());
	}
	
	public void buscarAnimalMaiorMedia () {
		try {
			JOptionPane.showMessageDialog(null, veterinario.retornaAnimalMaiorMedia());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void calcularQuantAnimaisPesoMaiorQueInformado() {
		try {
			String pesoInformado = JOptionPane.showInputDialog("Informe o peso para calcular: ");
			float pesoEmFloat = 0;
			
			try {
				pesoEmFloat = Float.parseFloat(pesoInformado);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro: peso informado incorretamente !!!");
			}
			
			int quantidadeObtida = veterinario.calculaQuantAnimaisPesoMaiorQueInformado(pesoEmFloat);
			JOptionPane.showMessageDialog(null, "A quantidade de animais com peso maior que " + pesoEmFloat + " é: " + quantidadeObtida);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public static void main(String[] args) throws Exception {
		new Sistema();
	}
}
