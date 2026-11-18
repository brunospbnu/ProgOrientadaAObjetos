package principal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class GravarArquivoSimples {
	public static void main(String[] args) {
		File arquivo = new File ("C:\\Users\\bpatricio\\Desktop\\dados.bat");
		//se for para adicionar dados tem mais um parametro no construtor do FileOutputStream que pode ser colocado (arquivo, true)...
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream(arquivo);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fos.write(79);
			fos.write(105);
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
