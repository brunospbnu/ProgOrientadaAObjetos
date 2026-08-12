import java.util.Scanner;

public class Sistema {
	int opcao = 0;
	Scanner teclado = new Scanner(System.in);
	
	public Sistema() {
		menu();
		teclado.close();
	}
	
	private void menu() {
		 System.out.println("---- Programa para cadastrar Carros de funcionários ----");
		 do {
			 System.out.println("Selecione uma opção: \n\r 1 - Cadastrar Carro \n\r 2 - Excluir carro \n\r 3 - Mostrar carros \n\r 0 - Encerrar programa");
			 opcao = teclado.nextInt();
			 while (opcao < 0 || opcao > 3 ) {
				 System.out.print("Opção inválida! Informe uma opção válida: ");
	             opcao = teclado.nextInt();
	            }
			 executaropcao();
			 if (opcao == 0) {
				 System.out.println("Encerrando o sistema !!! ");
			 }
		} while (opcao != 0);
	}
	
	private void executaropcao() {
		switch (opcao) {
		case 1:
			cadastrarcarro();
			break;
		case 2:
			excluirCarro();
			break;
		case 3:
			mostrarCarros();
			break;
		}}
		
		private void cadastrarcarro() {
			// PENDENTE
		}
		
		private void excluirCarro() {
			// PENDENTE
		}
		
		private void mostrarCarros() {
			// PENDENTE
		}
	
	public static void main(String[] Args) {
		new Sistema();
	}
}
