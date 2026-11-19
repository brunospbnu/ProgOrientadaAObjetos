package binarioSimples;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class GravarArquivoTipoEspecifico {
	public static void main(String[] args) {
		File arquivo = new File ("C:\\Users\\bpatricio\\Desktop\\dados.bat");
		//se for para adicionar dados tem mais um parametro no construtor do FileOutputStream que pode ser colocado (arquivo, true)...
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		
		double preco = 19.99;
		boolean teste = true;
		String nome = "FURB";
		
		try {
			fos = new FileOutputStream(arquivo);
			dos = new DataOutputStream(fos);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			dos.writeDouble(preco);
			dos.writeBoolean(teste);
			dos.writeUTF(nome);
			dos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
