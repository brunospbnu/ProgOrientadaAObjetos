package serializacao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class GravandoObjetoEmArquivo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2174904871019525264L;

	public static void main(String[] args) {
		
		File f = new File("src\\Objetos.bin");
		try (FileOutputStream fos = new FileOutputStream(f);
		ObjectOutputStream o = new ObjectOutputStream(fos)) {
		o.writeObject("Boa noite");
		o.writeObject(new ContaBancaria("1","Lucas",300));
		o.writeObject(new Veiculo("MIE-3932","Anderson"));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
