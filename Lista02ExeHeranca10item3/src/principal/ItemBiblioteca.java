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
	
	
}
