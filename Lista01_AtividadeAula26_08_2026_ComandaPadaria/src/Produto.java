
public class Produto {
	private String nomeProduto;
	private float valorUnitario;
	
	public Produto(String nomePassado, float valorUnitarioPassado) {
		setNomeProduto(nomePassado);
		setValorUnitario(valorUnitarioPassado);
	}
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	
	public void setNomeProduto(String nomeInformado) {
		if (nomeInformado != null && nomeInformado.length() >= 3 && !nomeInformado.isBlank()) {
			nomeProduto = nomeInformado;
		} else {
			System.out.println("Erro: O nome deve ser preenchido e deve conter 3 letras ou mais !!! ");
		}
		
	}
	
	public float getValorUnitario() {
		return valorUnitario;
	}
	
	public void setValorUnitario(float valorInformado) {
		if (valorInformado > 0) {
			valorUnitario = valorInformado;
		}
		else {
			System.out.println("Erro: O valor do produto deve ser maior do que zero !!! ");
		}
	}
}
