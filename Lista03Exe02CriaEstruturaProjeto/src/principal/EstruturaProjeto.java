package principal;

import java.io.File;

import javax.swing.JOptionPane;

public class EstruturaProjeto {
	
	/*
	 * Solicite o caminho de uma pasta-base e o nome de um projeto. Dentro da pasta-base, crie 
	 * uma pasta com o nome do projeto. Nela, crie as subpastas dados, relatorios e backup,
	 * além do arquivo vazio README.txt.
	 * Informe quais itens foram criados e quais já existiam. Se parte da estrutura já estiver 
	 * criada, complete os itens ausentes e preserve os existentes. Se um arquivo ocupar o 
	 * caminho previsto para uma pasta, informe o conflito.
	 * 
	 */
	
	public static void main(String[] args) {
		
		String textoDeRetorno = "";
		
		String caminhoPasta = JOptionPane.showInputDialog("Informe o caminho da pasta base: ");
		String nomeProjeto = JOptionPane.showInputDialog("Informe o nome do projeto: ");
		
		File pasta = new File(caminhoPasta);
		
		if (pasta.isFile()) {
			textoDeRetorno += "Deve ser selecionada uma pasta, não um arquivo !!!";
		}
		
		//TODO continuar exercicio aqui.
		
	}
}
