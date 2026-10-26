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
	
	public double devolucao(ItemBiblioteca itemDevolvido, LocalDate dataDevEfetiva) throws IllegalArgumentException {
		double multaDevida = 0;
		if (itemDevolvido == null) {
			throw new IllegalArgumentException("O item não pode estar vazio !!!");
		}
		multaDevida = itemDevolvido.calcularMulta(dataDevEfetiva);
		
		return multaDevida;
	}
	
}
