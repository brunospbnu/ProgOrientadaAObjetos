import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Sistema<E> {
	int opcao = 0;
	ArrayList<Carro> carrosCadastrados = new ArrayList<> ();
	Scanner teclado = new Scanner(System.in);
	
	public Sistema() {
		menu();
		teclado.close();
	}
	
	private void menu() {
		 System.out.println("---- Programa para cadastrar Carros ----");
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
			Carro carroCriado = new Carro();
			
			System.out.println("Informe o modelo do Carro");
			String modeloDigitado = teclado.next();
			carroCriado.setModelo(modeloDigitado);
			
			System.out.println("Selecione a COR do Carro: ");
			
			// 1. O método .values() cria um vetor com todas as cores do seu enum
			
			COR[] vetorDeCores = COR.values();
			
			// 2. Usamos um for normal para imprimir as opções numeradas
			
	        for (int i = 0; i < vetorDeCores.length; i++) {
	            
	        	// Imprime (i + 1) para o menu começar no 1 em vez do 0
	        	
	            System.out.println((i + 1) + " - " + vetorDeCores[i]);
	        }
	        
	        System.out.print("Digite o número da opção desejada: ");
	        int opcao = teclado.nextInt();
	        carroCriado.setCor(vetorDeCores[opcao - 1]);
	        
	        System.out.println("Informe o ano de fabricação: ");
	        int anoDigitado = teclado.nextInt();
	        carroCriado.setAnoFabricacao(anoDigitado);
	        
	        System.out.println("Informe a quilometragem atual: ");
	        double quilometragemDigitada = teclado.nextDouble();
	        carroCriado.setQuilometragemAtual(quilometragemDigitada);
	        
	        System.out.println("Informe se o carro está ligado: \n 1- SIM \n 2- NÃO");
	        int situacaoInformada = teclado.nextInt();
	        while (situacaoInformada < 1 || situacaoInformada > 2 ) {
				 System.out.print("Opção inválida! Informe uma opção válida: ");
				 situacaoInformada = teclado.nextInt();
	            }
	        if (situacaoInformada == 1) {
				carroCriado.setEsta_Ligado(true);
			}
	        else if (situacaoInformada == 2) {
	        	carroCriado.setEsta_Ligado(false);
	        }
	        
	        carrosCadastrados.add(carroCriado);
	        System.out.println("Carro º " + carrosCadastrados.size() + " cadastrado.");
		}
		
		private void excluirCarro() {
			System.out.println("Excluir Carro - Lista de carros: ");
			int indice = 1;
			for (Carro item : carrosCadastrados) {
				System.out.println(indice + " - " + item.getModelo());
				indice++;
				
			}
			System.out.println("Escolha o carro para excluir: ");
			int indiceCarroAExcluir = teclado.nextInt();
			carrosCadastrados.remove(indiceCarroAExcluir);
		}
		
		private void mostrarCarros() {
			System.out.println("Lista de carros: ");
			int indice = 1;
			for (Carro item : carrosCadastrados) {
				System.out.println(indice + ": Modelo = " + item.getModelo() + "; COR = " + item.getCor() + "; Ano de Fabricação = " + item.getAnoFabricacao() + "; Quilometragem = " + item.getQuilometragematual() + "; Está ligado? " + item.getEsta_Ligado());
				indice++;
			}
			
		}
	
	public static void main(String[] Args) {
		new Sistema<>();
	}
}
