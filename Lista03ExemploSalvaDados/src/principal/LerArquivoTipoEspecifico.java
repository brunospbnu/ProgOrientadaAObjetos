package principal;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LerArquivoTipoEspecifico {
	public static void main(String[] args) {
		File arquivo = new File("C:\\Users\\bpatricio\\Desktop\\dados.bat");
		FileInputStream fis = null;
		DataInputStream dis = null;
		
		
		try {
			fis = new FileInputStream(arquivo);
			dis = new DataInputStream(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			double preco = dis.readDouble();
			boolean bool = dis.readBoolean();
			String nome = dis.readUTF();
			dis.close();
			
			System.out.println(preco);
			System.out.println(bool);
			System.out.println(nome);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Terminou");
	}
}
