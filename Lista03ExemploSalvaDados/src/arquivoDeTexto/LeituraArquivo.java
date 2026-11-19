package arquivoDeTexto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeituraArquivo {
	public static void main(String[] args) {
		Scanner arqTexto = null;
		try {
			arqTexto = new Scanner(new File("src\\texto.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (arqTexto.hasNext()) {
		System.out.println(arqTexto.nextLine());
		}
		
		arqTexto.close();

	}
}
