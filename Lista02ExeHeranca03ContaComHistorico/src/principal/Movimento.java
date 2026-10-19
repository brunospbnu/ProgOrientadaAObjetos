package principal;

import java.time.LocalDate;
import java.time.LocalTime;

public class Movimento {
	private double valor;
	private LocalDate data;
	private LocalTime hora;
	private TipoMovimento tipo;
	
	public Movimento(double valorInformado, TipoMovimento tipoInformado) {
		setValor(valorInformado);
		data = LocalDate.now();
		hora = LocalTime.now();
		setTipoMovimento(tipoInformado);
	}
	
	public LocalDate getData() {
		return data;
	}
	
	public LocalTime getHora() {
		return hora;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valorInformado) {
		if (valorInformado < 0) {
	        throw new IllegalArgumentException("O valor informado deve ser positivo");
	    }
		valor = valorInformado;
		
	}
	
	public TipoMovimento getTipoMovimento() {
		return tipo;
	}
	
	public void setTipoMovimento(TipoMovimento tipoInformado) {
		tipo = tipoInformado;
	}
	
}
