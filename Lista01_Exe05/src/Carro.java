
public class Carro {
	private Modelo modelo;
	private COR corAtual;
	private int anoFabricacao;
	private double quilometragematual;
	private boolean esta_ligado;
	
	public String getModelo() {
		return this.modelo.getNomeModelo();
	}
	
	public COR getCor( ) {
		return this.corAtual;
	}
	
	public int getAnoFabricacao() {
		return anoFabricacao;
	}
	
	public double getQuilometragematual() {
		return quilometragematual;
	}
	
	public String getEsta_Ligado() {
		String estado;
		if (esta_ligado) {
			estado = "SIM";
		}
		else {
			estado = "NÃO";
		}
		return estado;
	}
	
	public void setModelo(String modeloAtual) {
		this.modelo = new Modelo();
		modelo.setModeloNome(modeloAtual);
		
	}
	
	public void setCor(COR corDigitada) {
		this.corAtual = corDigitada;
		
	}
	
	public void setAnoFabricacao(int anoDigitado) {
		this.anoFabricacao = anoDigitado;
		
	}
	
	public void setQuilometragemAtual(double quilometragemDigitada) {
		this.quilometragematual = quilometragemDigitada;
		
	}
	
	public void setEsta_Ligado(boolean estadoInformado) {
		this.esta_ligado = estadoInformado;
	}

}