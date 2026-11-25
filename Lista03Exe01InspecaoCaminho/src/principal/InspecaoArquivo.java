package principal;

import java.io.File;

import javax.swing.JOptionPane;

public class InspecaoArquivo {
	
	
	/*
	 * Implemente um programa que receba um caminho como entrada e informe se ele existe. 
	 * Caso exista, identifique se corresponde a um arquivo ou a um diretório e exiba seu nome, 
	 * seu caminho absoluto e as permissões de leitura e escrita. Se o caminho corresponder a 
	 * um arquivo, exiba também seu tamanho em bytes.
	 */
	
	public static void main(String[] args) {
		
		String caminho = JOptionPane.showInputDialog("Informe o caminho do arquivo:");
		
		File caminhoOuArquivo = new File(caminho);
		
		Boolean existe = caminhoOuArquivo.exists();
		
		String informacoes = "O caminho informado corresponde a: ";
		
		if (!existe) {
			informacoes += "O arquivo ou pasta informado não existe !!! ";
		}
		else {
			
			String nome = caminhoOuArquivo.getName();
			String caminhoAbsoluto = caminhoOuArquivo.getAbsolutePath();
			
			boolean PermissaoLeitura = caminhoOuArquivo.canRead();
			boolean PermissaoEscrita = caminhoOuArquivo.canWrite();
			String PermissaoLeituraS = "";
			String PermissaoEscritaS = "";
			
			if (PermissaoLeitura) {
				PermissaoLeituraS = "Sim";
			}
			else {
				PermissaoLeituraS = "Não";
			}
			
			if (PermissaoEscrita) {
				PermissaoEscritaS = "Sim";
			}
			else {
				PermissaoEscritaS = "Não";
			}
			
			
			if (caminhoOuArquivo.isDirectory()) {
				informacoes += "Uma pasta\n" 
							+ "Nome da pasta: " + nome
							+ "\nCaminho absoluto: " + caminhoAbsoluto
							+ "\nPermissões:"
							+ "\nPode ler? :" + PermissaoLeituraS
							+ "\nPode Alterar? : " + PermissaoEscritaS;
			}
			else { // isFile()
				informacoes += "Um arquivo\n"
							+ "Nome do arquivo: " + nome
							+ "\nCaminho absoluto: " + caminhoAbsoluto
							+ "\nPermissões:"
							+ "\nPode ler? :" + PermissaoLeituraS
							+ "\nPode Alterar? : " + PermissaoEscritaS
							+ "\nTamanho em bytes: " + caminhoOuArquivo.length();
			}
		}
		
		JOptionPane.showMessageDialog(null, informacoes);
		
	}
}
