package arquivoDeTexto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class GravacaoArquivo {
	public static void main(String[] args) {
		File arquivo = new File("src\\texto.txt");
		
		PrintWriter arquivoTexto = null;
		
		try {
			arquivoTexto = new PrintWriter(arquivo);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		arquivoTexto.println("Primeira linha");
		arquivoTexto.println(true);
		arquivoTexto.printf("Preço: %20.2f", 1234.5);

		arquivoTexto.close();
		
	}
}
