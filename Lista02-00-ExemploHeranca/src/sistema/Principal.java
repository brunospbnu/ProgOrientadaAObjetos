package sistema;


// IMPORTAÇÃO DE UMA CLASSE DE OUTRO PACOTE PARA TER ACESSO:
import heranca.SubClasse;
import heranca.SuperClasse;

public class Principal {
	
	public Principal() {
		SubClasse s1 = new SubClasse (10,2,8);
		System.out.println(s1.somar());
		System.out.println(s1.dividir());
		
		SuperClasse super1 = new SuperClasse(10, 2);
		System.out.println(super1.dividir());
		
		/* 
		O que não pode ser feito e não é possível ser feito:
		
		super1.numero1 = 5;
		
		Isso não é possível porque o numero1 em superclasse está como protegido e não pode ser acessado diretamente.
		
		*/
	}
	
	public static void main(String[] args) {
		new Principal();
	}
}
