package principal;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Controle {
	
	List<Produto> produtos;
	File dadosEstoque;
	String localArquivo;
	
	public Controle() {
		produtos = new ArrayList<Produto>();
		dadosEstoque = new File(localArquivo, "dadosEstoque.dat");
		setLocalArquivo();
	}
	
	
	public String getLocalArquivo() {
		return localArquivo;
	}
	
	public void setLocalArquivo() {
		JFileChooser selecionarArquivo= new JFileChooser();
		selecionarArquivo.setDialogTitle("Selecione a pasta de armazendamento dos dados: ");
		selecionarArquivo.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		selecionarArquivo.setAcceptAllFileFilterUsed(false);
		
		if (selecionarArquivo.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
            return; // Encerra se o usuário cancelar
        }

        File pasta = selecionarArquivo.getSelectedFile();
        
        if (pasta == null || !pasta.isDirectory()) {
            JOptionPane.showMessageDialog(null, "Selecione uma pasta válida.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        localArquivo = pasta.getAbsolutePath();
	}
	
	
	
	private void addProduto() {
		// TODO Auto-generated method stub

	}
	
	private void lerArquivo() {
		// TODO Auto-generated method stub

	}
	
	private void gravarArquivo() {
		// TODO Auto-generated method stub

	}
	
	
}
