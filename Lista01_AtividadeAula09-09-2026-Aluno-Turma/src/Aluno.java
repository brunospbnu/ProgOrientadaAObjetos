import java.util.ArrayList;
import java.util.List;

public class Aluno {

	private String nomeAluno;
	private List<Float> notasAluno;
	private int quantDeNotasParaCadaEstudante;
	private int quantNotasCadastradas;
	
	
	/*
	 Introduzimos a utilização do tratamento de exceções. 
	 Para isso, sempre no inicio do metodo e do consututor tem que ter o aviso de que ele é capaz de retornar exceções.
	*/
	public Aluno(String nomeInformado) throws IllegalArgumentException {
		setNomeAluno(nomeInformado);
		notasAluno = new ArrayList<Float>();
		quantDeNotasParaCadaEstudante = 3;
		quantNotasCadastradas = 0;
	}
	
	//Poderiam ser colocados mais construtores, desde que cada um tenha uma quantidade de parametros diferentes.
	//Quando há mais de um contrutor com parametros diferentes, 
	//o construtor chamado vai depender do que for colocado como parametro na classe principal que estiver chamando essa.
	
	public String getNomeAluno() {
		return nomeAluno;
	}
	
	/*
	 Introduzimos a utilização do tratamento de exceções. 
	 Para isso, sempre no inicio do metodo e do consututor tem que ter o aviso de que ele é capaz de retornar exceções.
	*/
	public void setNomeAluno(String nomeInformado) throws IllegalArgumentException {
		if (nomeInformado.isBlank()|| nomeInformado.length() <= 3) {
			throw new IllegalArgumentException("O nome não pode estar vazio e deve conter mais de 3 letras !!!");
		} else {
			nomeAluno = nomeInformado;
		}
	}
	
	
	public List<Float> getNotasAluno() {
		return notasAluno;
	}
	
	public void setNotasAluno(List<Float> listaDeNotasInformada) throws IllegalArgumentException {
		if (listaDeNotasInformada.size() != notasAluno.size()) {
			throw new IllegalArgumentException ("Ao passar a lista inteira para cadastro, ambas devem ter a mesma quantidade de itens !!!");
		} else {
			notasAluno = listaDeNotasInformada;
		}
	}
	
	public void addNotaAluno(float notaInformada) throws IllegalArgumentException {
		if (notaInformada < 0 || notaInformada > 10) {
			throw new IllegalArgumentException ("A nota não pode ser menor que 0 e nem maior que 10 !!!");
		} 
		else if (quantNotasCadastradas == quantDeNotasParaCadaEstudante) {
			throw new IllegalArgumentException ("Limite de notas alcançado - não é possível adicionar mais !!!");
		}
		
		else {
			notasAluno.add(notaInformada);
			quantNotasCadastradas++;
		}
		
	}
	
	public void alteraNotaAluno(int posicaoDaNota, float notaInformada) throws IllegalArgumentException {
		if (notaInformada < 0 || notaInformada > 10) {
			throw new IllegalArgumentException ("A nota não pode ser menor que 0 e nem maior que 10 !!!");
		} 
		
		else {
			notasAluno.remove(posicaoDaNota);
			quantNotasCadastradas--;
			notasAluno.add(posicaoDaNota, notaInformada);
			quantNotasCadastradas++;
		}
		
	}
	
	public void removeNotaAluno(int posicaoNaLista) throws IllegalArgumentException {
		if (posicaoNaLista < 0 || posicaoNaLista > notasAluno.size()) {
			throw new IllegalArgumentException("A posição informada é inválida !!!");
		}
		notasAluno.remove(posicaoNaLista);
		quantNotasCadastradas--;
	}
	
	public float retornaNotaEspecificaAluno(int posicaoNaLista) {
		return notasAluno.get(posicaoNaLista);
	}
	
	public String retornaStringComNotasDoAluno() {
		String listaDeNotasemString = "Notas:\n";
		for (int j = 0; j < notasAluno.size(); j++) {
			listaDeNotasemString += (j+1) + "ª Nota = " + notasAluno.get(j) + "\n";
		}
		return listaDeNotasemString;
	}
	
	public float calcularERetornarMediaAluno() {
		float soma = 0;
		for (int i = 0; i < notasAluno.size(); i++) {
			soma = soma + retornaNotaEspecificaAluno(i);
		}
		float media = soma / quantDeNotasParaCadaEstudante;
		return media;
	}
	
}
