package lista01AtividadeAula09092026Veterinaria;
import java.util.List;
import javax.swing.JOptionPane;

public class Sistema {
	Veterinario veterinario;
	String nomeVeterinario;
	List<Animal> animais;
	
	public Sistema() throws Exception {
		nomeVeterinario = "Nome não definido";
		veterinario = new Veterinario(nomeVeterinario);
		String textoMenu = "MENU PRINCIPAL - Escolha uma Opção:\n \n" +
				" 1  - **************************\n" +
				" 0 - Encerrar sistema";
		//TODO fazer menu	
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
				//TODO fazer as opções e seus respectivos metodos.
				break;
			case 2:
				
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

	
	public static void main(String[] args) throws Exception {
		new Sistema();
	}
}
