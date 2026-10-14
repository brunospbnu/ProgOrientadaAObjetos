package heranca;

public class SuperClasse {
	protected int numero1;
	protected int numero2;
	
	public SuperClasse(int numero1, int numero2) {
		setNumero1(numero1);
		setNumero2(numero2);
	}

	public int getNumero1() {
		return numero1;
	}

	public void setNumero1(int numero1) {
		this.numero1 = numero1;
	}

	public int getNumero2() {
		return numero2;
	}

	public void setNumero2(int numero2) {
		this.numero2 = numero2;
	}
	
	public int dividir() {
		if (numero2 != 0) {
			return numero1 / numero2;
		}
		return 0;
	}
}
