import javax.swing.JOptionPane;

public class Cliente {

	private int codigoCliente;
	private String nomeCliente;
	private String emailCliente;
	
	public Cliente(int codigoInformado, String nomeInformado, String emailInformado) {
		setCodigoCliente(codigoInformado);
		setNomeCliente(nomeInformado);
		setEmailCliente(emailInformado);
	}
	
	public int getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(int codigoCliente) {
		if (codigoCliente <= 0) {
			JOptionPane.showMessageDialog(null, "ERRO no programa - O código do cliente não pode ser igual ou menor que zero !");
		}
		else {
		this.codigoCliente = codigoCliente;
		}
	}
	
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		if (nomeCliente == null || nomeCliente.isBlank()) {
			JOptionPane.showMessageDialog(null, "ERRO no programa - O nome do Cliente não pode estar vazio !");
		} else {
			this.nomeCliente = nomeCliente;
		}
	}
	
	public String getEmailCliente() {
		return emailCliente;
	}
	public void setEmailCliente(String emailCliente) {
		if (emailCliente == null || emailCliente.isBlank()) {
			JOptionPane.showMessageDialog(null, "ERRO no programa - O e-mail não pode estar vazio ! ");
		} else {
			this.emailCliente = emailCliente;
		}
		
	}
	
	public String imprimirDados() {
		return "Código: " + getCodigoCliente() + " - Nome: " + getNomeCliente() + " - E-mail: " + getEmailCliente() + "\n";
	}
	
}
