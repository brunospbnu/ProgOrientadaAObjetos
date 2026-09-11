import java.util.ArrayList;
import java.util.List;

public class Turma {
	
	private String nomeTurma;
	private List<Aluno> listaDeAlunos;
	
	
	public Turma(String nomeInformado) throws IllegalArgumentException{
		setNomeTurma(nomeInformado);
		listaDeAlunos = new ArrayList<Aluno>();
	}
	
	public String getNomeTurma() {
		return nomeTurma;
	}
	
	public void setNomeTurma(String nomeInformado) throws IllegalArgumentException {
		if (nomeInformado.isBlank()|| nomeInformado.length() <= 3) {
			throw new IllegalArgumentException ("O nome não pode estar vazio e deve conter mais de 3 letras !!!");
		} else {
			//O throw new já para a execução do método e retorna a exceção informada.
			//Por isso não seria necessário o else, mas vou manter.
			nomeTurma = nomeInformado;
		}
	}
	
	
	public List<Aluno> getListaDeAlunos() {
		return listaDeAlunos;
	}
	
	public void setListaDeAlunos(List<Aluno> listaDeAlunosInformada) throws IllegalArgumentException {
		if (listaDeAlunosInformada.size() != listaDeAlunos.size()) {
			throw new IllegalArgumentException ("Ao passar a lista inteira para cadastro, ambas devem ter a mesma quantidade de itens !!!");
		} else {
			listaDeAlunos = listaDeAlunosInformada;
		}
	}
	
	public String retornarStringListaDeAlunos() {
		String listaDeAlunosEmString = "Lista de Alunos: \n";
		if (listaDeAlunos.isEmpty()) {
			listaDeAlunosEmString += "A lista está vazia !!!\n ";
		}
		for (int i = 0; i < listaDeAlunos.size(); i++) {
			listaDeAlunosEmString += (i+1) + ") Nome: " + listaDeAlunos.get(i).getNomeAluno() + "\n  ";
			if (listaDeAlunos.get(i).getNotasAluno().isEmpty()) {
				listaDeAlunosEmString += "Aluno sem notas cadastradas.\n ";
			}
			for (int j = 0; j < listaDeAlunos.get(i).getNotasAluno().size(); j++) {
				listaDeAlunosEmString += "\n" +(j+1) + "ª Nota = " + listaDeAlunos.get(i).getNotasAluno().get(j);
			}
			listaDeAlunosEmString += "\n \n ";
			}
		listaDeAlunosEmString += "Fim da lista !!!";
		return listaDeAlunosEmString;
	}
	
	public float calcularERetornarMediaTurma() {
		float somaDaMediaDeTodos = 0;
		for (int i = 0; i < listaDeAlunos.size(); i++) {
			somaDaMediaDeTodos = somaDaMediaDeTodos + listaDeAlunos.get(i).calcularERetornarMediaAluno();
		}
		float mediaDeTodos = somaDaMediaDeTodos / (float) listaDeAlunos.size();
				
		return mediaDeTodos;
	}
	
	public Aluno retornarAlunoComMaiorMedia() {
		
		
		if (listaDeAlunos == null || listaDeAlunos.isEmpty()) {
			throw new IllegalArgumentException("Não há alunos cadastrados !!!");
		}
		if (listaDeAlunos.size() < 2) {
			throw new IllegalArgumentException("Somente há um aluno cadastrado - Não é possível comparar!!!");
		}
		
		Aluno alunoComMaiorMedia = listaDeAlunos.get(0);
		boolean houveEmpateNoTopo = false;
		
		for (int i = 1; i < listaDeAlunos.size(); i++) {
			Aluno alunoAtual = listaDeAlunos.get(i);
			double mediaAtual = alunoAtual.calcularERetornarMediaAluno();
	        double maiorMediaAteAgora = alunoComMaiorMedia.calcularERetornarMediaAluno();
	        
			if (mediaAtual > maiorMediaAteAgora) {
				alunoComMaiorMedia = alunoAtual;
	            houveEmpateNoTopo = false;
			}
			else if (mediaAtual == maiorMediaAteAgora) {
	            houveEmpateNoTopo = true;
	        }
		}
		if (houveEmpateNoTopo) {
	        throw new IllegalArgumentException("Há alunos empatados com a maior média. Confira a lista!");
	    }
		return alunoComMaiorMedia;
		
		
	}
	
	public int calcularQuantAlunosMedia07OuMais() {
		int quantAlunosMedia07OuMais = 0;
		for (int i = 0; i < listaDeAlunos.size(); i++) {
			if (listaDeAlunos.get(i).calcularERetornarMediaAluno() >= 7.0) {
				quantAlunosMedia07OuMais++;
			}
		}
		return quantAlunosMedia07OuMais;
		
	}
	
	public Aluno retornarAlunoEspecificoBuscadoPeloNome(String alunoBuscado) throws IllegalArgumentException{
		if (alunoBuscado!= null) {
			for (int i = 0; i < listaDeAlunos.size(); i++) {
				if (listaDeAlunos.get(i).getNomeAluno().equalsIgnoreCase(alunoBuscado)) {
					return listaDeAlunos.get(i);
				}
			}
		}
		else {
			throw new IllegalArgumentException("O nome do aluno a ser alterado não pode estar vazio");
		}
		return null;
		
	}
	
	
	public void addAluno(Aluno alunoInformado) throws IllegalArgumentException {
		if (alunoInformado == null) {
			throw new IllegalArgumentException ("O aluno deve ser informado !");
		}
		else {
			listaDeAlunos.add(alunoInformado);
		}
	}
	
	public void excluirAluno(Aluno alunoInformado) throws IllegalArgumentException{
		if (alunoInformado == null) {
			throw new IllegalArgumentException ("O aluno deve ser informado !");
		}
		else {
			listaDeAlunos.remove(alunoInformado);
		}
	}
	
	public void alteraDadosAluno(String nomeAntigo, String novoNome, int posicaoNotaAAlterar, float novoValor) throws IllegalArgumentException{
		Aluno alunoSelecionado = retornarAlunoEspecificoBuscadoPeloNome(nomeAntigo);
		if (novoNome == null || novoNome.isBlank() || novoNome.length() <= 3) {
			throw new IllegalArgumentException("O nome não pode estar vazio e deve conter mais de 3 letras !!!");
		} 
		else {
			alunoSelecionado.setNomeAluno(novoNome);
		}
		if (posicaoNotaAAlterar < 1 || posicaoNotaAAlterar > alunoSelecionado.getNotasAluno().size()) {
			throw new IllegalArgumentException("A posição da nota deve ser maior que 1 e não pode ser maior que a quantidade de notas");
		} else {
			alunoSelecionado.alteraNotaAluno(posicaoNotaAAlterar, novoValor);
		}
		
	
	}
	
}
