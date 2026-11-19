package binarioSimples;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LerArquivoSimples {
	
	public static void main(String[] args) {
		File f = new File("C:\\Users\\bpatricio\\Desktop\\dados.bat");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int dado;
		
		try {
			while (true) {
				dado = fis.read();
				if (dado != -1) {
					System.out.println(dado);
				}
				else {
					break;
				}
			}
			fis.close();
			// somente no objeto mais interno é necessário dar o close.
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Terminou");
	}
}
