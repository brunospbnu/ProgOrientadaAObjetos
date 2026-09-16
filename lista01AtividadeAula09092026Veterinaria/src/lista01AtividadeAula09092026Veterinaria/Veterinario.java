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
	
	public void setAnimais(List<Animal> animaisInformados) throws Exception {
		if (animaisInformados == null) {
			throw new Exception("ERRO: A lista de animais não pode ser nula !!!");
		}
		animaisVeterinario = animaisInformados;
	}
	
	public void addAnimal(Animal animalInformado) throws Exception {
		if (animalInformado == null) {
			throw new Exception("O animal não pode estar vazio !!!");
		}
		animaisVeterinario.add(animalInformado);
	}
	
	public Animal buscarAnimal(String nomeInformado) throws Exception {
		if (nomeInformado == null || nomeInformado.isBlank()) {
			throw new Exception("O nome buscado não pode estar vazio !!!");
		}
		for (int i = 0; i < animaisVeterinario.size(); i++) {
			if (nomeInformado == animaisVeterinario.get(i).getNome()) {
				return animaisVeterinario.get(i);
			}
		}
		throw new Exception ("Não foram encontrados animais com esse nome !!! ");
	}
	
	public void alteraAnimal(String nomeBuscado, String novoNome, String especieNova, List<Float> novosPesos) throws Exception {
		Animal animalEncontrado = buscarAnimal(nomeBuscado);
		animalEncontrado.setNome(novoNome);
		animalEncontrado.setEspecie(especieNova);
		animalEncontrado.setPesos(novosPesos);

	}
	
	public void excluiAnimal(Animal animalInformado) throws Exception {
		if (animalInformado == null) {
			throw new Exception("O animal não pode estar vazio !!!");
		}
		animaisVeterinario.remove(animalInformado);
	}
	
	public String listarTodosAnimais() {
		String listaAnimais = "\n \n Lista completa de animais: \n\n";
		for (int i = 0; i < animaisVeterinario.size(); i++) {
			listaAnimais += (i+1) + "º) " + animaisVeterinario.get(i).getNome() + " - Dono: " + animaisVeterinario.get(i).getDonoDoAnimal().getNome() + "\n";
		}
		return listaAnimais;
	}
	
	public String listarAnimaisDono(String nomeDonoInformado) {
		String listaDeAnimaisDono = "\n\n Lista de animais do dono" + nomeDonoInformado + " :\n\n";
		for (int i = 0; i < animaisVeterinario.size(); i++) {
			if (nomeDonoInformado.equalsIgnoreCase(animaisVeterinario.get(i).getDonoDoAnimal().getNome())) {
				listaDeAnimaisDono += animaisVeterinario.get(i).getNome();
			}
		}
		return listaDeAnimaisDono;
		
	}
	
	public String buscarDadosContatoDonoPeloNomeAnimal(String nomeAnimalInformado) {
		String dadosContatoDoDono = "Busca realizada - Dados encontrados para o animal" + nomeAnimalInformado + ": \n";
		for (int i = 0; i < animaisVeterinario.size(); i++) {
			if (nomeAnimalInformado.equalsIgnoreCase(animaisVeterinario.get(i).getNome())) {
				dadosContatoDoDono += "Nome do dono: " + animaisVeterinario.get(i).getDonoDoAnimal().getNome() + "- Telefone: " + animaisVeterinario.get(i).getDonoDoAnimal().getNome();
			}
		}
		return dadosContatoDoDono;
	}
	
	public float calculaMediaGeralPesosAnimais() {
		float somaDasMediasAnimais = 0;
		float mediaGeral = 0;
		for (int i = 0; i < animaisVeterinario.size(); i++) {
			somaDasMediasAnimais += animaisVeterinario.get(i).calculaMediaPesoAnimal();
		}
		mediaGeral = somaDasMediasAnimais / (float) animaisVeterinario.size();
		return mediaGeral;
	}
	
	public String retornaAnimalMaiorMedia() throws Exception {
		if (animaisVeterinario.size() == 1) {
			throw new Exception ("ERRO: Há somente 1 animal cadastrado - Não é possível comparar !!!");
		}
		String animalMaiorMediaDados = "O animal com maior média é: ";
		Animal animalMaiorMedia = animaisVeterinario.get(0);
		boolean empate = false;
		for (int i = 1; i < animaisVeterinario.size(); i++) {
			Animal animalAtual = animaisVeterinario.get(i);
			if (animalAtual.calculaMediaPesoAnimal() > animalMaiorMedia.calculaMediaPesoAnimal()) {
				animalMaiorMedia = animalAtual;
			}
			if (animalAtual.calculaMediaPesoAnimal() == animalMaiorMedia.calculaMediaPesoAnimal()) {
				empate = true;
			}
			
		}
		if (empate == true) {
			throw new Exception("ERRO: Há animais empatados, consulte a lista !!!");
		}
		animalMaiorMediaDados += animalMaiorMedia.getNome();
		return animalMaiorMediaDados;
	}
	
	public int calculaQuantAnimaisDono(String nomeDonoInformado) throws Exception {
		int quantidadeAnimaisDoDono = 0;
		boolean donoValido = false;
		for (int i = 0; i < animaisVeterinario.size(); i++) {
			if (nomeDonoInformado.equalsIgnoreCase(animaisVeterinario.get(i).getDonoDoAnimal().getNome())) {
				donoValido = true;
				quantidadeAnimaisDoDono++;
			}
		}
		if (!donoValido) {
			throw new Exception("ERRO: Não há qualquer dono cadastrado com o nome informado");
		}

		return quantidadeAnimaisDoDono;
	}
	
	
	public int calculaQuantAnimaisPesoMaiorQueInformado (float pesoInformado) throws Exception {
		int quantidade = 0;
		if (pesoInformado < 0) {
			throw new Exception ("ERRO: O peso informado não pode ser menor que zero !!!");
		}
		for (int i = 0; i < animaisVeterinario.size(); i++) {
			if (animaisVeterinario.get(i).calculaMediaPesoAnimal() > pesoInformado) {
				quantidade++;
			}
		}
		return quantidade;
	}
	
	
}
