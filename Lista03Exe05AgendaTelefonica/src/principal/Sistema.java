package principal;

import java.io.FileNotFoundException;

public class Sistema {
	
	public static void main(String[] args) {
		new Sistema();
	}
	
	public Sistema() {
		try {
			
			Agenda agenda = new Agenda();
			Contato c1 = new Contato(3, "Luciana", "2222");
			Contato c2 = new Contato(4, "Maria", "33333");
			agenda.cadastrar(c1);
			agenda.cadastrar(c2);
			
			System.out.println("\nAntes da alteração: \n" +agenda.listar());
			
			agenda.alterarContato(4, new Contato(4, "Augusto", "1111"));
			
			System.out.println("\nApós alteração: \n" + agenda.listar());
			
			
		} catch (FileNotFoundException | IllegalArgumentException e) {
			
			System.out.println(e.getMessage());
			
		}
	}
}
