package principal;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ConteudoDiretorio {
	
	/*
	 * Enunciado:
	 * 
	 * Solicite o caminho de um diretório e liste os arquivos e as subpastas que estão diretamente 
	 * nele. Exiba o nome e o tipo de cada item. Para os arquivos, mostre também o tamanho em 
	 * bytes.
	 * 
	 * Ao final, apresente a quantidade de arquivos, a quantidade de subpastas, a soma dos 
	 * tamanhos dos arquivos e o nome do maior arquivo, quando houver. Trate os casos de 
	 * diretório vazio, caminho inválido e falha na listagem.
	 * 
	 */
	
	public static void main(String[] args) {
		
		JFileChooser seletor = new JFileChooser();
        seletor.setDialogTitle("Selecione a pasta-base para listar os arquivos e subpastas:");
        seletor.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        seletor.setAcceptAllFileFilterUsed(false);

        if (seletor.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
            return; // Encerra se o usuário cancelar
        }

        File pastaBase = seletor.getSelectedFile();
        if (pastaBase == null || !pastaBase.isDirectory()) {
            JOptionPane.showMessageDialog(null, "Selecione uma pasta válida.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
		
        StringBuilder info = new StringBuilder();
        
        File[] arquivosOuPastas= pastaBase.listFiles();
        File maiorArquivo = null;
        
        int qntArquivos = 0;
        int qntPastas = 0;
        long somaTamanhoArquivos = 0;
        
        if (arquivosOuPastas == null) {
        	info.append("Falha na listagem");
        	JOptionPane.showMessageDialog(null, info.toString());
        	return;
        }
        else if (arquivosOuPastas.length == 0) {
        	info.append("A pasta está vazia !!!");
		}
        else {
        	for (File atual : arquivosOuPastas) {

            	String tipo = "";
            	
            	if (atual.isFile()) {
            		
    				tipo = "Arquivo - Tamanho: " + atual.length();
    				qntArquivos++;
    				somaTamanhoArquivos+= atual.length();
    				
    				if (maiorArquivo == null || atual.length() > maiorArquivo.length()) {
    					maiorArquivo = atual;
					}
    			}
            	else if (atual.isDirectory()) {
    				tipo = "Pasta";
    				qntPastas++;
    			}
            	
    			info.append("\nNome: ").append(atual.getName()).append(" - Tipo: ").append(tipo);
    		}
		}	
        
        String maiorArquivoNome = "";
        
        if (maiorArquivo == null) {
        	 maiorArquivoNome = "Não há arquivos !!!";
		}
        else {
        	maiorArquivoNome = maiorArquivo.getName();
		}
        
        info.append("\n\nQuantidade de arquivos: ").append(qntArquivos);
        info.append("\n\nQuantidade de pastas: ").append(qntPastas);
        info.append("\n\nSoma do tamanho de todos os arquivos: ").append(somaTamanhoArquivos);
        info.append("\n\nNome do maior arquivo: ").append(maiorArquivoNome);
        
        JOptionPane.showMessageDialog(null, info.toString());
	}
}
