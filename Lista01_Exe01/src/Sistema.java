
public class Sistema {
	public Sistema() {
		System.out.println("Teste de sistema que interliga classes");
		Pessoa p1 = new Pessoa();
		Pessoa p2 = new Pessoa();
		
		p1.setNome("Maria");
		p2.setNome("");
		p2.setNome("Luciana");
		
		System.out.println(p1.getNome() + " " + p2.getNome() + " " + p1.getIdade());
	}

	public static void main(String[] args) {
		new Sistema();
	}
}