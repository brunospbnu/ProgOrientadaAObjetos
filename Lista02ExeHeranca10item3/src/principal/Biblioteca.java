package principal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
	private List<ItemBiblioteca> emprestimos;
	DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Biblioteca() throws IllegalArgumentException {
		setEmprestimos(new ArrayList<ItemBiblioteca>());
	}

	public List<ItemBiblioteca> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<ItemBiblioteca> emprestimos) {
		this.emprestimos = emprestimos;
	}
	
	public void addEmprestimo(ItemBiblioteca itemInformado) throws IllegalArgumentException{
		if (itemInformado == null) {
			throw new IllegalArgumentException("O item não pode estar vazio !!!");
		}
		emprestimos.add(itemInformado);
		
	}
	
	public String listarEmprestimos() {
		String texto = "Lista de emprestimos: ";
		
		for (int i = 0; i < emprestimos.size(); i++) {
			ItemBiblioteca itemAtual = emprestimos.get(i);
			texto += "\n Item: " + itemAtual.getClass().getSimpleName() + " - Data do emprestimo: " + itemAtual.getDataEmprestimo().format(formatador)
								+ " - Data Prevista para Devolução: " + itemAtual.getDataPrevistaDevolucao().format(formatador) + " - Valor da multa por dia: R$ " 
								+ itemAtual.getValorMultaDia();
		}
		
		if (emprestimos.isEmpty()) {
			texto += "\n NÃO HÁ EMPRESTIMOS CADASTRADOS !!!";
		}
		texto += "\n Fim da lista !!!";
		
		return texto;
	}
	
	
	/*
	 OBS:
	 Formatação Visual de MoedaNo método listarEmprestimos(), a impressão do valor da multa ficou com casas decimais quebradas ou ausentes 
	 (ex: R$ 1.2 e R$ 0.3).   
	 Para garantir que o console sempre mostre formato de dinheiro (ex: R$ 1,20), 
	 aplique o String.format diretamente na concatenação do seu texto dentro de Biblioteca.java:
	 "... Valor da multa por dia: R$ " + String.format("%.2f", itemAtual.getValorMultaDia());
	 */
	
	public double devolucao(ItemBiblioteca itemDevolvido, LocalDate dataDevEfetiva) throws IllegalArgumentException {
		double multaDevida = 0;
		if (itemDevolvido == null) {
			throw new IllegalArgumentException("O item não pode estar vazio !!!");
		}
		multaDevida =itemDevolvido.calcularMulta(dataDevEfetiva);
	
		return multaDevida;
	}
	
}
