import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/*
Uma escola deseja desenvolver um sistema para gerenciar os alunos de uma turma.  

Para isso, deverão ser criadas as classes Aluno e Turma.  

Cada aluno deve possuir um nome e três notas, além de um método responsável por calcular e retornar sua média.

A turma deve possuir um nome e manter uma lista com os alunos matriculados.  

Na classe Turma, deverão ser implementados os métodos para cadastrar um novo aluno, buscar um aluno pelo nome, 
alterar suas informações e excluir um aluno da turma.  

Além disso, a classe deverá possuir métodos que permitam listar todos os alunos, calcular a média geral da turma, 
identificar o aluno com a maior média e informar a quantidade de alunos que possuem média igual ou superior a 7,0. 

 */


public class Sistema {
	Turma turmaDaEscola;
	List<Aluno> alunosDaEscola;
	
	
	public Sistema() {
		turmaDaEscola = new Turma("Nome não definido");
		alunosDaEscola = new ArrayList<Aluno>();
		String textoMenu = "MENU PRINCIPAL - Escolha uma Opção:\n \n" +
							" 1  - TURMA: Definir / Alterar o nome da turma\n" +
							" 2  - TURMA: Consultar o nome da turma\n\n" +
							" 3  - ALUNO: Adicionar aluno no cadastro\n" +
							" 4  - ALUNO: Listar alunos e suas notas\n" +
							" 5  - ALUNO: Excluir aluno do cadastro, bem como suas notas\n" +
							" 6  - ALUNO / NOTAS: Alterar dados completos de um aluno, incluindo notas\n\n" +
							" 7  - MÉDIA: Exibir aluno com maior média\n" +
							" 8  - MÉDIA: Exibir a quantidade de alunos com média igual ou superior à 7,0\n" +
							" 9  - MÉDIA: Exibir a Média da Turma\n\n" +
							" 10 - NOTA: Adicionar nota a um aluno\n" +
							" 11 - NOTA: Remover nota de um aluno\n\n" +
							" 0 - Encerrar sistema";
						
		
		
		String opcaoEmString;
		
		int opcao = -1;
		
		do {
			
			opcaoEmString = JOptionPane.showInputDialog(textoMenu);
			
			try {
				opcao = Integer.parseInt(opcaoEmString);
				
			} catch (Exception e) {
				
			}
			
			switch (opcao) {
			case 1:
				definirNomeTurma();
				break;
			case 2:
				consultarNomeTurma();
				break;
			case 3:
				adicionarAluno();
				break;
			case 4:
				listarAlunos();
				break;
			case 5:
				excluirAluno();
				break;
			case 6:
				alterarDadosCompletosAluno();
				break;
			case 7:
				exibirAlunoMaiorMedia();
				break;
			case 8:
				exibirQuantAlunosMedia07OuMais();
				break;
			case 9:
				exibirMediaDaTurma();
				break;
			case 10:
				adicionarNotaAluno();
				break;
			case 11:
				removerNotaAluno();
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
	
	
	
	private void removerNotaAluno() {
		// TODO Auto-generated method stub
		
	}



	private void adicionarNotaAluno() {
		// TODO Auto-generated method stub
		
	}



	private void exibirMediaDaTurma() {
		// TODO Auto-generated method stub
		
	}



	private void exibirQuantAlunosMedia07OuMais() {
		// TODO Auto-generated method stub
		
	}



	private void exibirAlunoMaiorMedia() {
		// TODO Auto-generated method stub
		
	}



	private void alterarDadosCompletosAluno() {
		// TODO Auto-generated method stub
		
	}



	private void excluirAluno() {
		// TODO Auto-generated method stub
		
	}



	private void listarAlunos() {
		// TODO Auto-generated method stub
		
	}



	private void adicionarAluno() {
		// TODO Auto-generated method stub
		
	}



	private void consultarNomeTurma() {
		// TODO Auto-generated method stub
		
	}



	private void definirNomeTurma() {
		// TODO Auto-generated method stub
		
	}



	public static void main(String[] args) {
		new Sistema();
	}
}
