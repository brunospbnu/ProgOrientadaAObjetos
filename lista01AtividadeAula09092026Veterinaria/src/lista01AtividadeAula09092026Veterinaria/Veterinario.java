package lista01AtividadeAula09092026Veterinaria;

import java.util.ArrayList;
import java.util.List;

public class Veterinario {
	String nome;
	List<Animal> animaisVeterinario;
	
	public Veterinario(String nomeInformado) throws Exception {
	setNome(nomeInformado);
	animaisVeterinario = new ArrayList<Animal>();
		
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nomeInformado) throws Exception {
		if (nomeInformado == null || nomeInformado.isBlank() || nomeInformado.length() < 3) {
			throw new Exception("ERRO: O nome não pode estar vazio e deve ter mais de 3 letras !!!");
		} 
		nome = nomeInformado;
	}
	
	public List<Animal> getAnimais() {
		return animaisVeterinario;
	}
	
	public void setAnimeis(List<Animal> animaisInformados) throws Exception {
		if (animaisInformados == null) {
			throw new Exception("ERRO: A lista de animais não pode ser nula !!!");
		}
		animaisVeterinario = animaisInformados;
	}
	
	public void addanimal(Animal animalInfomado) {
		//TODO
	}
	
	public Animal buscarAnimal(String nomeInformado) {
		//TODO
		return null;
	}
	
	public void alteraAnimal(Animal animalInformado) {
		//TODO
	}
	
	public void excluiAnimal(Animal animalInformado) {
		//TODO
	}
	
	public String listarAnimaisDono(String donoInformado) {
		String listaAnimaisDono = "Lista de animais do dono: " + donoInformado + ": \n\n";
		//TODO
		return listaAnimaisDono;
	}
	
	public String listarTodosAnimais() {
		String listaDeAnimais = "Lista completa de animais:\n\n";
		//TODO
		return listaDeAnimais;
		
	}
	
	public String buscarDadosContatoDonoPeloNomeAnimal(String nomeAnimalInformado) {
		String dadosContatoDoDono = "Busca realizada - Dados encontrados: \n";
		//TODO
		return dadosContatoDoDono;
	}
	
	public int calculaQuantAnimaisDono() {
		int quantidadeAnimaisDoDono = 0;
		//TODO
		return quantidadeAnimaisDoDono;
	}
	
	public float calculaMediaAnimalEspecifico() {
		float mediaAnimal = 0;
		//TODO
		return mediaAnimal;
	}
	
	public float calculaMediaGeralPesosAnimais() {
		float mediageral = 0;
		//TODO
		return mediageral;
	}
	
	public int calculaQuantAnimaisPesoMaiorQueInformado (float pesoInformado) {
		int quantidade = 0;
		//TODO
		return quantidade;
	}
	
	
}
