import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

public class Emprestimo {
	private Cliente clienteDoEmprestimo;
	private List<Livro> LivrosDoEmprestimo;
	private Date dataEmprestimo;
	
	public Emprestimo(Cliente clienteInformado) {
		setDataEmprestimo(new Date());
		setClienteDoEmprestimo(clienteInformado);
		LivrosDoEmprestimo = new ArrayList<Livro>();
	}
	
	public void addLivro(Livro livroInformado) {
		if (livroInformado == null) {
			JOptionPane.showMessageDialog(null, "O livro deve ser informado !");
		}
		else {
			LivrosDoEmprestimo.add(livroInformado);
		}
		
	}
	
	public Cliente getClienteDoEmprestimo() {
		return clienteDoEmprestimo;
	}
	
	public void setClienteDoEmprestimo(Cliente clienteDoEmprestimo) {
		if (clienteDoEmprestimo == null) {
			JOptionPane.showMessageDialog(null, "ERRO no programa - A lista de livros não pode ser nula !");
		} else {
			this.clienteDoEmprestimo = clienteDoEmprestimo;
		}
		
	}
	
	
	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}
	
	public void setDataEmprestimo(Date dataEmprestimo) {
		if (dataEmprestimo == null) {
			JOptionPane.showMessageDialog(null, "ERRO no programa - A data não pode ser nula !");
		} else {
			this.dataEmprestimo = dataEmprestimo;
		}
		
	}
	
	public List<Livro> getLivrosDoEmprestimo() {
		return LivrosDoEmprestimo;
	}
	
	public void setLivrosDoEmprestimo(List<Livro> livrosDoEmprestimo) {
		if (livrosDoEmprestimo == null) {
			JOptionPane.showMessageDialog(null, "ERRO no programa - A lista de livros não pode ser nula !");
		} else {
			LivrosDoEmprestimo = livrosDoEmprestimo;
		}
		
	}
	
	public String imprimirDados() {
		String dados = dataEmprestimo.toString() + "\n";
		dados += clienteDoEmprestimo.imprimirDados() + "\n";
		for (Livro livro: LivrosDoEmprestimo) {
			dados += livro.imprimirDados();
		}
		return dados;
	}
	
	
}
