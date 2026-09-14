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
							" 3  - ALUNO: Adicionar aluno na turma\n" +
							" 4  - ALUNO: Listar alunos e suas notas\n" +
							" 5  - ALUNO: Excluir aluno da turma, bem como suas notas\n" +
							" 6  - ALUNO / NOTA: Alterar dados de um aluno, incluindo uma nota\n\n" +
							" 7  - MÉDIA: Exibir aluno com maior média\n" +
							" 8  - MÉDIA: Exibir a quantidade de alunos com média igual ou superior à 7,0\n" +
							" 9  - MÉDIA: Exibir a Média da Turma\n\n" +
							" 10 - NOTA: Adicionar nota a um aluno\n" +
							" 11 - NOTA: Remover nota de um aluno\n\n" +
							" 0 - Encerrar sistema";
						
		
		
		String opcaoEmString;
		
		int opcao = -1;
		
		do {
			
			opcaoEmString = JOptionPane.showInputDialog("Nome da turma: " + turmaDaEscola.getNomeTurma() + "\n\n" + textoMenu);
			
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
		String alunoAExcluirNotaString = JOptionPane.showInputDialog("Escolha o aluno para remover a nota, pelo número: \n" + turmaDaEscola.retornarStringListaDeAlunos());
		try {
			int alunoARemoverNotaEmInt = Integer.parseInt(alunoAExcluirNotaString);
			Aluno alunoARemoverNota = turmaDaEscola.getListaDeAlunos().get(alunoARemoverNotaEmInt-1);
			String notaAExcluiremString = JOptionPane.showInputDialog("Esconha a nota para exccluir, pelo número: " + alunoARemoverNota.retornaStringComNotasDoAluno());
			int notaAExcluirEmInt = Integer.parseInt(notaAExcluiremString);
			turmaDaEscola.getListaDeAlunos().get(alunoARemoverNotaEmInt-1).removeNotaAluno(notaAExcluirEmInt-1);
			
			
			JOptionPane.showMessageDialog(null, "Nota removida com sucesso !!! ");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}



	private void adicionarNotaAluno() {
		String alunoAAdicionarNotaString = JOptionPane.showInputDialog("Escolha o aluno para adicionar a nota, pelo número: \n" + turmaDaEscola.retornarStringListaDeAlunos());
		try {
			int alunoAAdicionarNotaEmInt = Integer.parseInt(alunoAAdicionarNotaString);
			Aluno alunoAAdicionarNota = turmaDaEscola.getListaDeAlunos().get(alunoAAdicionarNotaEmInt-1);
			String notaAAdionarString = JOptionPane.showInputDialog("Informe a nota a adicionar: ");
			float notaAAdicionar = Float.parseFloat(notaAAdionarString);
			alunoAAdicionarNota.addNotaAluno(notaAAdicionar);
			JOptionPane.showMessageDialog(null, "Nota adicionada com sucesso !!! ");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}



	private void exibirMediaDaTurma() {
		float mediaDaTurma = turmaDaEscola.calcularERetornarMediaTurma();
		JOptionPane.showMessageDialog(null, "A média da turma é: " + mediaDaTurma);
		
	}



	private void exibirQuantAlunosMedia07OuMais() {
		int quantAlunosMedia07OuMais = turmaDaEscola.calcularQuantAlunosMedia07OuMais();
		JOptionPane.showMessageDialog(null, "A quantidade de alunos com média maior que 7 é: \n " + quantAlunosMedia07OuMais);
		
	}



	private void exibirAlunoMaiorMedia() {
		try {
			Aluno alunoComMaiorMedia = turmaDaEscola.retornarAlunoComMaiorMedia();
			JOptionPane.showMessageDialog(null, "O Aluno com maior média é: \n "+alunoComMaiorMedia.getNomeAluno());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}



	private void alterarDadosCompletosAluno() {
		try {
			String nomeDoAlunoAAlterar = JOptionPane.showInputDialog("Informe o nome do aluno a ser alterado: \n");
			Aluno alunoAAlterar = turmaDaEscola.retornarAlunoEspecificoBuscadoPeloNome(nomeDoAlunoAAlterar);
			String novoNome = JOptionPane.showInputDialog("Informe o novo nome: \n");
			String posicaoNotaAAlterarString = JOptionPane.showInputDialog("Informe a posição da nota a alterar, pelo número: \n" + alunoAAlterar.retornaStringComNotasDoAluno());
			int posicaoNotaAAAlterar = Integer.parseInt(posicaoNotaAAlterarString);
			String novaNotaEmString = JOptionPane.showInputDialog("Informe a nova nota: \n ");
			float novaNota = Float.parseFloat(novaNotaEmString);
			turmaDaEscola.alteraDadosAluno(nomeDoAlunoAAlterar, novoNome,posicaoNotaAAAlterar-1,novaNota);
			JOptionPane.showMessageDialog(null, "Nota alterada com sucesso !!! ");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		
		
	}



	private void excluirAluno() {
		String alunoAAxcluirString = JOptionPane.showInputDialog("Informe o aluno para excluir, pelo número: \n" + turmaDaEscola.retornarStringListaDeAlunos());
		try {
			int alunoAExcluirEmInt = Integer.parseInt(alunoAAxcluirString);
			Aluno alunoAExcluir = turmaDaEscola.getListaDeAlunos().get(alunoAExcluirEmInt-1);
			turmaDaEscola.excluirAluno(alunoAExcluir);
			JOptionPane.showMessageDialog(null, "Aluno excluído com sucesso !!! ");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "O valor digitado é invalido ou não é um número !!!");
		}
		
		
	}



	private void listarAlunos() {
		JOptionPane.showMessageDialog(null, turmaDaEscola.retornarStringListaDeAlunos());
	}



	private void adicionarAluno() {
		String nomeInformado = JOptionPane.showInputDialog("Adicionando estudante: \n Informe o nome do estudante: \n");
		try {
			Aluno alunoAAdicionar = null;
			alunoAAdicionar = new Aluno(nomeInformado);
			turmaDaEscola.addAluno(alunoAAdicionar);
			JOptionPane.showMessageDialog(null, "Aluno adicionado com sucesso !!!");
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		
	}



	private void consultarNomeTurma() {
		String nomeConsultado = turmaDaEscola.getNomeTurma();
		JOptionPane.showMessageDialog(null, "O nome da turma é: " + nomeConsultado);
	}



	private void definirNomeTurma() {
		try {
			String nomeInformado = JOptionPane.showInputDialog("Informe o nome da Turma: " );
			turmaDaEscola.setNomeTurma(nomeInformado);
		} 
		catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		
	}



	public static void main(String[] args) {
		new Sistema();
	}
}
