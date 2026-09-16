package lista01AtividadeAula09092026Veterinaria;

import java.util.ArrayList;
import java.util.List;

public class Animal {
	private String nome;
	private String especie;
	private Dono donoDoAnimal;
	private List<Float> pesos;
	private int quantMaxPesosPorAnimal = 3;
	
	public Animal(String nomeInformado, String especieInformada, Dono donoInformado) throws Exception {
		setNome(nomeInformado);
		setEspecie(especieInformada);
		setDonoDoAnimal(donoInformado);
		pesos = new ArrayList<Float>(); 
		
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

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especieInformada) throws Exception {
		if (especieInformada == null || especieInformada.isBlank() || especieInformada.length() < 3) {
			throw new Exception("ERRO: O nome da espécie não pode estar vazio e deve ter mais de 3 letras !!!");
		} 
		especie = especieInformada;
	}

	public Dono getDonoDoAnimal() {
		return donoDoAnimal;
	}

	public void setDonoDoAnimal(Dono donoDoAnimalInformado) throws Exception {
		if (donoDoAnimalInformado == null) {
			throw new Exception("ERRO: O dono não pode estar vazio !!!");
		}
		donoDoAnimal = donoDoAnimalInformado;
	}

	public List<Float> getPesos() {
		return pesos;
	}

	public void setPesos(List<Float> pesosInformados) throws Exception {
		if (pesosInformados == null || pesosInformados.size() != pesos.size()) {
			throw new Exception("ERRO: A lista de pesos não pode ser nula e deve ser do mesmo tamanho que a lista cadastrada!!!");
		}
		pesos = pesosInformados;
	}
	
	public void addPeso (float pesoInformado) throws Exception {
		if (pesoInformado < 0) {
			throw new Exception("ERRO: O peso não pode ser menor que zero !!!");
		}
		if (pesos.size() == quantMaxPesosPorAnimal) {
			throw new Exception("ERRO: Quantidade Máxima de pesos já adicionada - Não é possível adicionar mais !!!");
		}
		pesos.add(pesoInformado);
	}
	
	public void removePeso (int posicaoNaLista) throws Exception {
		if (posicaoNaLista < 1 || posicaoNaLista > pesos.size()) {
			throw new Exception("ERRO: A posição escolhida deve estar na lista !!!");
		}
		pesos.remove(posicaoNaLista);
	}
	
	public float calculaMediaPesoAnimal () {
		float somaDosPesos = 0;
		for (int i = 0; i < pesos.size(); i++) {
			somaDosPesos += pesos.get(i);
		}
		float media = somaDosPesos / quantMaxPesosPorAnimal;
		return media;
	}
}
