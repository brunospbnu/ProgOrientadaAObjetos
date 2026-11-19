package serializacao;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class LerObjetoArquivo {
	public static void main(String[] args) {
		
		
		File f = new File("src\\Objetos.bin");
		
		String objeto1;
		ContaBancaria objeto2;
		Veiculo objeto3;
		
		try (FileInputStream fis = new FileInputStream(f);
		
				ObjectInputStream ois = new ObjectInputStream(fis))  {
			
			objeto1 = (String) ois.readObject();
			objeto2 = (ContaBancaria) ois.readObject();
			objeto3 = (Veiculo) ois.readObject();
			System.out.println(objeto1);
			System.out.println(objeto2.getNome());
			System.out.println("Conta: " + objeto2.getNumeroConta());
			System.out.println("Saldo: " + objeto2.getSaldo());
			System.out.println("Veículo: " + objeto3.getNome() + " - Placa: " + objeto3.getPlaca());
		}
			catch (Exception e) {
			System.out.println(e.getMessage());
		
		
	}
}
}
