
public class Carro {
	private Modelo modelo;
	private COR cor;
	private int anoFabricacao;
	private double quilometragematual;
	private boolean esta_ligado;
	
	public String getModelo() {
		return this.modelo.getNomeModelo();
	}
	
	public COR getCor( ) {
		return this.cor;
	}
	
	public int getAnoFabricacao() {
		return anoFabricacao;
	}
	
	public double getQuilometragematual() {
		return quilometragematual;
	}
	
	public boolean getEsta_Ligado() {
		return esta_ligado;
	}
	
	public void setModelo(String modeloAtual) {
		this.modelo = new Modelo();
		modelo.setModeloNome(modeloAtual);
		
	}
	
	public void setCor() {
		
		// PENDENTE
	}
	
	public void setAnoFabricacao() {
		
		// PENDENTE
	}
	
	public void setQuilometragemAtual() {
		
		// PENDENTE
	}
	
	public void setEsta_Ligado() {
		
		// PENDENTE
	}
}