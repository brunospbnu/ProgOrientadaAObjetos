package lista01AtividadeAula09092026Veterinaria;

import java.util.ArrayList;
import java.util.List;

public class Animal {
	private String nome;
	private String especie;
	private Dono donoDoAnimal;
	private List<Float> pesos;
	
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
		if (pesosInformados == null) {
			throw new Exception("ERRO: A lista de pesos não pode ser nula !!!");
		}
		pesos = pesosInformados;
	}
	
	
}
