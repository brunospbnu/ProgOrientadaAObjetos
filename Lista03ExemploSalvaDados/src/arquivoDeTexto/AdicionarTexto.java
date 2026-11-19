package arquivoDeTexto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class AdicionarTexto {
	public static void main(String[] args) {
		File arquivo = new File("src\\texto.txt");
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(arquivo, true);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter arquivoTexto = new PrintWriter(fos);
		arquivoTexto.println("nova linha2");
		
		arquivoTexto.close();
	}
}
