package principal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Controle {

	private List<Produto> produtos;
	private File dadosEstoque;
	private String localArquivo;

	public Controle() {
		produtos = new ArrayList<>();
		setLocalArquivo();
		if (localArquivo != null) {
			dadosEstoque = new File(localArquivo, "dadosEstoque.dat");
		}
	}

	public String getLocalArquivo() {
		return localArquivo;
	}

	public void setLocalArquivo() {
		JFileChooser selecionarArquivo = new JFileChooser();
		selecionarArquivo.setDialogTitle("Selecione a pasta de armazenamento dos dados:");
		selecionarArquivo.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		selecionarArquivo.setAcceptAllFileFilterUsed(false);

		if (selecionarArquivo.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
			return;
		}

		File pasta = selecionarArquivo.getSelectedFile();
		if (pasta == null || !pasta.isDirectory()) {
			JOptionPane.showMessageDialog(null, "Selecione uma pasta válida.", "Erro", JOptionPane.ERROR_MESSAGE);
			return;
		}

		localArquivo = pasta.getAbsolutePath();
	}

	public void addProduto(Produto p) throws IOException, IllegalArgumentException {
		for (Produto produto : produtos) {
			if (produto.getCodigo() == p.getCodigo()) {
				throw new IllegalArgumentException("Já existe um produto com esse código.");
			}
		}

		// Acrescenta apenas o novo registro ao final do arquivo (append = true)
		try (FileOutputStream fos = new FileOutputStream(dadosEstoque, true);
			 DataOutputStream dos = new DataOutputStream(fos)) {
			dos.writeInt(p.getCodigo());
			dos.writeInt(p.getQntDisponivel());
			dos.writeDouble(p.getPreco());
		}

		produtos.add(p);
	}

	public String listarProdutos() {
		if (produtos.isEmpty()) {
			return "Nenhum produto cadastrado no estoque.";
		}

		StringBuilder texto = new StringBuilder("Lista de produtos:");
		for (Produto produto : produtos) {
			texto.append("\nCódigo: ").append(produto.getCodigo())
				 .append("; Quantidade Disponível: ").append(produto.getQntDisponivel())
				 .append("; Preço: R$ ").append(String.format("%.2f", produto.getPreco()));
		}
		return texto.toString();
	}

	public void lerProdutos() throws IOException {
		if (!dadosEstoque.exists()) {
			return;
		}

		produtos.clear();
		try (FileInputStream fis = new FileInputStream(dadosEstoque);
			 DataInputStream dis = new DataInputStream(fis)) {

			while (true) {
				try {
					int codigo = dis.readInt();
					int qntDisponivel = dis.readInt();
					double preco = dis.readDouble();
					produtos.add(new Produto(codigo, qntDisponivel, preco));
				} catch (EOFException e) {
					break;
				}
			}
		}
	}

	public void entradaProduto(int codigoProd, int qntAdd) throws IllegalArgumentException, IOException {
		Produto prodEntrada = buscarProduto(codigoProd);
		prodEntrada.addProduto(qntAdd);
		atualizarQuantidadeNoArquivo(codigoProd, prodEntrada.getQntDisponivel());
	}

	public void saidaProduto(int codigoProd, int qntRemov) throws IllegalArgumentException, IOException {
		Produto prodSaida = buscarProduto(codigoProd);
		prodSaida.removerProduto(qntRemov);
		atualizarQuantidadeNoArquivo(codigoProd, prodSaida.getQntDisponivel());
	}

	private Produto buscarProduto(int codigo) {
		for (Produto produto : produtos) {
			if (produto.getCodigo() == codigo) {
				return produto;
			}
		}
		throw new IllegalArgumentException("Não foi localizado um produto com o código informado.");
	}

	// Atualiza apenas os 4 bytes da quantidade diretamente no arquivo
	private void atualizarQuantidadeNoArquivo(int codigoProd, int novaQuantidade) throws IOException {
		try (RandomAccessFile raf = new RandomAccessFile(dadosEstoque, "rw")) {
			while (raf.getFilePointer() < raf.length()) {
				int codigoLido = raf.readInt(); // Lê 4 bytes; ponteiro para exatamente na quantidade
				if (codigoLido == codigoProd) {
					raf.writeInt(novaQuantidade); // Sobrescreve apenas os 4 bytes da quantidade
					return;
				}
				// Pula os 4 bytes da quantidade + 8 bytes do preço deste registro
				raf.skipBytes(12);
			}
		}
	}
}