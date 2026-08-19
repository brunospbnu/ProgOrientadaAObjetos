import java.util.Date;

public class Aluguel {
	private Date data;
	private int horainicio;
	private int horaFim;
	private Tema tema;
	private Cliente cliente;
	private String endereço;
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		if (data != null) {
			this.data = data;
		} else {
			System.out.println("A data não pode estar vazia");
		}
		
	}
	
	public int getHorainicio() {
		return horainicio;
	}
	
	public void setHorainicio(int horainicio) {
		if (horainicio >= 0 && horainicio < 24) {
			this.horainicio = horainicio;
		} else {
			System.out.println("A hora de inicio deve estar entre 0 e 23");
		}
		
	}
	
	public int getHoraFim() {
		return horaFim;
	}
	
	public void setHoraFim(int horaFim) {
		if (horaFim >= 0 && horaFim < 24) {
			this.horaFim = horaFim;
		} else {
			System.out.println("A hora de fim deve ser entre 0 e 23");
		}
		
	}
	
	public Tema getTema() {
		return tema;
	}
	
	public void setTema(Tema tema) {
		if (tema != null) {
			this.tema = tema;
		} else {
			System.out.println("O tema não pode estar vazio");
		}
		
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		if (cliente != null) {
			this.cliente = cliente;
		} else {
			System.out.println("O cliente não pode estar vazio");
		}
		
	}
	
	public String getEndereço() {
		return endereço;
	}
	
	public void setEndereço(String endereço) {
		if (endereço != null && !endereço.isEmpty() && endereço.length() >= 3) {
			this.endereço = endereço;
		} else {
			System.out.println("O endereço não pode estar vazio e deve conter 3 letras ou mais");
		}
		
	}
}
