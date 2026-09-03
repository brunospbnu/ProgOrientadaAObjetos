import javax.swing.JOptionPane;

public class Livro {
	
	private int codigoLivro;
	private String tituloLivro;
	
	public Livro(int codigoInformado, String tituloInformado) {
		setCodigoLivro(codigoInformado);
		setTituloLivro(tituloInformado);
	}
	
	public int getCodigoLivro() {
		return codigoLivro;
	}
	public void setCodigoLivro(int codigoLivro) {
		if (codigoLivro <= 0) {
			JOptionPane.showMessageDialog(null, "ERRO no programa - O código do livro não pode ser igual ou menor que zero !");
		}
		else{
			this.codigoLivro = codigoLivro;
		}
		
	}
	
	public String getTituloLivro() {
		return tituloLivro;
	}
	public void setTituloLivro(String tituloLivro) {
		
		if (tituloLivro == null || tituloLivro.isBlank()) {
			JOptionPane.showMessageDialog(null, "ERRO no programa - O título do livro não pode estar vazio !");
		} else {
			this.tituloLivro = tituloLivro;
		}
		
	}
	
	public String imprimirDados() {
		return "Código: " + getCodigoLivro() + " - Título: " + getTituloLivro() + "\n";
	}
	
}
