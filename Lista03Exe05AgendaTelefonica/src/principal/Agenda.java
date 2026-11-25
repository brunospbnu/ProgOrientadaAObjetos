package principal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * 
 * Implemente uma agenda que grave seus dados em contatos.txt, com um registro por 
 * linha no formato codigo;nome;telephone (o arquivo deve ser Gerado pelo 
 * programa). Crie um menu para cadastrar, listar, buscar por código, alterar e excluir 
 * contatos.
 * 
 */

public class Agenda {
	
	private Map<Integer, Contato> contatos;
	private File  arquivo;
	
	public Agenda() throws FileNotFoundException {
		arquivo = new File("contatos.txt");
		contatos =  lerArquivoAgendaPopulaAgenda();  //new HashMap<Integer, Contato>();
		
	}
	
	
	public void cadastrar(Contato contato) throws FileNotFoundException {
		if (contatos.containsKey(contato.getCodigo())) {
			throw new IllegalArgumentException("Código de contato já existe !!!");
		}
		contatos.put(contato.getCodigo(), contato);
		
		// gravação do arquivo:
		FileOutputStream fos = new FileOutputStream(arquivo, true);
		PrintWriter pw = new PrintWriter(fos);
		
		pw.println(contato.getCodigo() + ";" + contato.getNome() + ";" + contato.getTelefone());
		
		pw.close();
	}
	
	
	private void reescreverArquivo() throws FileNotFoundException {
		
		FileOutputStream fos = new FileOutputStream(arquivo);
		PrintWriter pw = new PrintWriter(fos);
		
		for (Contato contato : contatos.values()) {
			pw.println(contato.getCodigo() + ";" + contato.getNome() + ";" + contato.getTelefone());
		}
		pw.close();
		
	}
	
	public void alterarContato(int codigoExistente, Contato novoContato) throws FileNotFoundException {
		if (!contatos.containsKey(codigoExistente)) {
			throw new IllegalArgumentException("Este contato não existe !!!");
		}
		
		contatos.get(codigoExistente).setNome(novoContato.getNome());
		contatos.get(codigoExistente).setTelefone(novoContato.getTelefone());
		
		reescreverArquivo();
	}
	
	public Contato excluirContato(int codigoContato) {
		Contato c = contatos.get(codigoContato);
		if (c != null) {
			contatos.remove(codigoContato);
		}
		return c;
	}
	
	public String listar() {
		String info = "";
		for (Contato c : contatos.values()) {
			info += "\nCódigo: " + c.getCodigo() +
					" - Nome: " + c.getNome() + "(" + c.getTelefone() + ")";
		}
		return info;
	}
	
	public Contato buscar(int codigo) {
		return contatos.get(codigo);
	}
	
	public Map<Integer, Contato> lerArquivoAgendaPopulaAgenda() throws FileNotFoundException {
		
		Map<Integer, Contato> contatos = null;
		try {
			contatos = new HashMap<>();
			@SuppressWarnings("resource")
			Scanner leitor = new Scanner(arquivo);
			while (leitor.hasNext()) {
				String linha = leitor.next(); // codigo;nome;telefone
				String[] partes = linha.split(";"); 
				Contato c = new Contato(Integer.parseInt(partes[0]), partes[1], partes[2]);
				contatos.put(c.getCodigo(), c);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
		
		}
		
		return contatos;
		
	}
	
}
