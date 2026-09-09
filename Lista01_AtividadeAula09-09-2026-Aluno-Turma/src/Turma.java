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
		String listaDeAlunosEmString = "Lista de Alunos\n";
		for (int i = 0; i < listaDeAlunos.size(); i++) {
			listaDeAlunosEmString += (i+1) + ") Nome" + listaDeAlunos.get(i).getNomeAluno() + "\n  ";
			for (int j = 0; j < listaDeAlunos.get(i).getNotasAluno().size(); j++) {
				listaDeAlunosEmString =+ (j+1) + "ª Nota = " + listaDeAlunos.get(i).getNotasAluno().get(j) + "\n  ";
			}
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
		//TODO fazer esse metodo.
	}
	
	public int calcularQuantAlunosMedia07OuMais() {
		//TODO fazer esse metodo.
	}
	
	public Aluno retornarAlunoEspecificoBuscadoPeloNome(String alunoBuscado) {
		if (alunoBuscado!= null) {
			for (int i = 0; i < listaDeAlunos.size(); i++) {
				if (listaDeAlunos.get(i).getNomeAluno().equalsIgnoreCase(alunoBuscado)) {
					return listaDeAlunos.get(i);
				}
			}
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
	
	public void excluirAluno() {
		//TODO fazer esse metodo.
	}
	
	public void alteraInfoTurma() {
		//TODO fazer esse metodo.
		
	}
	
}
