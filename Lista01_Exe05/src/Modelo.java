
public class Modelo {
	private String nomeModelo;
	
	public String getNomeModelo() {
		return nomeModelo;
	}
	
	public void setModeloNome(String nomeModelo) {
		if (nomeModelo.trim().equals("") || nomeModelo.trim().length() < 3) {
			System.out.println("Nome Inválido");
		}
		else {
			this.nomeModelo = nomeModelo;
		}
	}
}
