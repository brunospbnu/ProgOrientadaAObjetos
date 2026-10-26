package principal;

import java.time.LocalDate;

public abstract class ItemBiblioteca {
	private LocalDate dataEmprestimo;
	private LocalDate dataPrevistaDevolucao;
	private double valorMultaDia;
	
	public ItemBiblioteca(LocalDate dataEmprestimo, LocalDate dataPrevistaDevolucao, double valorMultaDia) {
		setDataEmprestimo(dataEmprestimo);
		setDataPrevistaDevolucao(dataPrevistaDevolucao);
		setValorMultaDia(valorMultaDia);
	}
	
	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}
	
	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public LocalDate getDataPrevistaDevolucao() {
		return dataPrevistaDevolucao;
	}

	public void setDataPrevistaDevolucao(LocalDate dataPrevistaDevolucao) {
		this.dataPrevistaDevolucao = dataPrevistaDevolucao;
	}

	public double getValorMultaDia() {
		return valorMultaDia;
	}

	public void setValorMultaDia(double valorMultaDia) {
		this.valorMultaDia = valorMultaDia;
	}
	
	public double calcularMulta(LocalDate dataDevEfetiva) {
		double multaDevida = 0;
		int diasAtraso = 0;
		int nmUnicoDataPrevista = (int) dataPrevistaDevolucao.toEpochDay();
		int nmUnicoDataDevolucao = (int) dataDevEfetiva.toEpochDay();
		
		if (nmUnicoDataPrevista < nmUnicoDataDevolucao) {
			diasAtraso = nmUnicoDataDevolucao - nmUnicoDataPrevista ;
			
		}
		
		multaDevida = valorMultaDia * diasAtraso;
		
		
		return multaDevida;
	}
	
	
	/*
	 OBS:
	 
	 O seu método calcularMulta em ItemBiblioteca.java utilizou perfeitamente o toEpochDay() para subtrair os inteiros e achar os dias de atraso. 
	 Essa lógica está 100% correta.   
	 Como dica de evolução técnica, o Java moderno possui uma classe chamada ChronoUnit que faz exatamente essa conta de forma mais direta, 
	 eliminando a necessidade de variáveis intermediárias int:
	 
	 Javaimport java.time.temporal.ChronoUnit;
	 // ... dentro de calcularMulta:
	 /// if (dataDevEfetiva.isAfter(dataPrevistaDevolucao)) {
	 /// diasAtraso = (int) ChronoUnit.DAYS.between(dataPrevistaDevolucao, dataDevEfetiva);}.
	 
	 */
	
	
}
