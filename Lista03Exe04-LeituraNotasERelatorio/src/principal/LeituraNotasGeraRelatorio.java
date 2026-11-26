package principal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class LeituraNotasGeraRelatorio {
	
	
	/*
	 * Leia um arquivo notas.txt com um estudante por linha, no formato nome;nota (esse 
	 * arquivo você precisa criar). 
	 * 
	 * Considere notas de 0 a 10, com ponto como separador 
	 * decimal. 
	 * 
	 * Gere um arquivo relatorio.txt com o nome, a nota e a situação de cada 
	 * estudante (esse arquivo é Gerado pelo seu programa). Considere aprovado quem obtiver 
	 * nota igual ou superior a 6,0.
	 * 
	 * Ao encontrar uma linha inválida, informe seu número e prossiga com as demais. 
	 * 
	 * Apresente, ao final do relatório, as quantidades de aprovados e reprovados e a média 
	 * calculada com os registros válidos. 
	 * 
	 * Se nenhum registro for válido, informe que a média 
	 * está indisponível.

	 */
	
	public static void main(String[] args) {
		
		JFileChooser selecionarArquivo= new JFileChooser();
		selecionarArquivo.setDialogTitle("Selecione o arquivo com as notas");
		selecionarArquivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
		selecionarArquivo.setAcceptAllFileFilterUsed(false);
		
		if (selecionarArquivo.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
            return; // Encerra se o usuário cancelar
        }

        File arquivoNotas = selecionarArquivo.getSelectedFile();
        
        if (arquivoNotas == null || !arquivoNotas.isFile()) {
            JOptionPane.showMessageDialog(null, "Selecione um arquivo válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
		
        
        // lendo os dados dos alunos e salvando em um ArrayList de Aluno.
        
        ArrayList<Aluno> dadosAlunos = new ArrayList<Aluno>();
        int numeroLinha = 0;

		try (Scanner arqTexto = new Scanner(arquivoNotas, StandardCharsets.UTF_8)) {

			while (arqTexto.hasNextLine()) {
				String linha = arqTexto.nextLine();
				numeroLinha++;

				try {
					String[] partes = linha.split(";", -1);
					if (partes.length != 2) {
						throw new IllegalArgumentException("Formato inválido");
					}

					String nome = partes[0].trim();
					if (nome.isEmpty()) {
						throw new IllegalArgumentException("Nome vazio");
					}

					double notaExtraida = Double.parseDouble(partes[1].trim());
					if (Double.isNaN(notaExtraida) || notaExtraida < 0.0 || notaExtraida > 10.0) {
						throw new IllegalArgumentException("Nota fora do intervalo [0, 10]");
					}

					dadosAlunos.add(new Aluno(nome, notaExtraida));

				} catch (Exception e) {
					JOptionPane.showMessageDialog(
							null,
							"Linha inválida encontrada e ignorada (Linha " + numeroLinha + ").",
							"Aviso de Leitura",
							JOptionPane.WARNING_MESSAGE
					);
				}
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Arquivo não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
			return;
		}
        
        
        
        // Analisando as notas, definindo situação e contando informações:
        
        int qntAlunosAprovados = 0;
        int qntAlunosReprovados = 0;
        double somaNotas = 0;
        
        for (Aluno aluno : dadosAlunos) {
        	somaNotas += aluno.getNota();
        	
			if (aluno.getNota() >= 6) {
				aluno.setAprovado(true);
				qntAlunosAprovados++;
			}
			else {
				aluno.setAprovado(false);
				qntAlunosReprovados++;
			}
		}
        
        
        double media = somaNotas / dadosAlunos.size();
        
        boolean mediaDisponivel = true;
        if (dadosAlunos.isEmpty()) {
			mediaDisponivel = false;
		}
        		
        // Imprimindo relatório:
        
        File relatorio = new File("relatorio.txt");
        
        try (PrintWriter arquivoRelatorio = new PrintWriter(relatorio, StandardCharsets.UTF_8)) {
        	
			for (Aluno aluno : dadosAlunos) {
				String situacaoEmTexto = "";
				if (aluno.isAprovado()) {
					situacaoEmTexto = "Aprovado";
				}
				else {
					situacaoEmTexto = "Reprovado";
				}
				arquivoRelatorio.println("Aluno: " + aluno.getNome()+"; Nota: " + aluno.getNota() + "; Situação: " + situacaoEmTexto);
			}
			
			arquivoRelatorio.println("Quantidade de alunos aprovados: " + qntAlunosAprovados);
			arquivoRelatorio.println("Quantidade de alunos reprovados: " + qntAlunosReprovados);
			if (mediaDisponivel) {
				arquivoRelatorio.println("Média das notas: " + media);
			}
			else {
				arquivoRelatorio.println("Média indisponível, pois não há alunos validos cadastrados !!!");
			}
			
			arquivoRelatorio.close();
			
			JOptionPane.showMessageDialog(null, "Relatório gerado com sucesso!");
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
        
	}
	
	
}
