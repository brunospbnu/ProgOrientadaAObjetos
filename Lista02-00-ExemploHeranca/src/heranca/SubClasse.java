package heranca;

public class SubClasse extends SuperClasse{
	
	private int n3;
	
	
	public SubClasse(int n1, int n2, int n3) {
		super(n1,n2);
		setN3(n3);
	}


	public int getN3() {
		return n3;
	}


	public void setN3(int n3) {
		this.n3 = n3;
	}
	
	public int somar() {
		
		// Se a classe superior estiver com atributos protegidos (protected), é possivel acessar diretamente se estiver no mesmo pacote.
		return numero1 + numero2 + n3;
		
		//Se a classe superior estiver com atributos privados somente é possível acessar com os metodos acessores.
		// return getNumero1() + getNumero2() + n3;
	}
	
	// O override é uma anotação para saber que você está sobreescrevendo um método de uma classe superior.
	// O java só permite colocar essa anotação se de fato o metodo estiver sobreescrevendo algo.
	@Override
	public int dividir() {
		if (n3 != 0) {
			return (numero1 + numero2) / n3;
			
		}
		return 0;
	}
}
