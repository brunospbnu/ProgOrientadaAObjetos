import java.util.ArrayList;
import java.util.List;

public class Academia {
	private List<Professor> professores;
	private List<Aluno> alunos;
	
	public Academia() throws IllegalArgumentException {
		professores = new ArrayList<Professor>();
		alunos = new ArrayList<Aluno>();
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) throws IllegalArgumentException {
		if (professores == null) {
			throw new IllegalArgumentException("ERRO: A lista de professores não pode ser nula");
		}
		this.professores = professores;
	}
	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) throws IllegalArgumentException {
		if (alunos == null) {
			throw new IllegalArgumentException("ERRO: A lista de alunos não pode ser nula");
		}
		this.alunos = alunos;
	}
	
	public void addProfessor(Professor professorInformado) throws IllegalArgumentException {
		if (professorInformado == null) {
			throw new IllegalArgumentException("ERRO: O professor informado não pode ser nulo");
		}
		professores.add(professorInformado);
	}
	
	public String listarProfessores() {
		String listaDeProfessores = "Lista de professores: \n";
		for (int i = 0; i < professores.size(); i++) {
			listaDeProfessores += (i+1) + "º) Nome: " + professores.get(i).getNome() + " --- Endereço: " + professores.get(i).getEndereco() + " --- Telefone: " + professores.get(i).getTelefone() + "\n";
		}
		listaDeProfessores += "\n\n";
		return listaDeProfessores;
	}
	
	public void removeProfessor(int posicaoProfessor) throws IllegalArgumentException {
		posicaoProfessor = posicaoProfessor -1;
		//Menos 1 pois fiz uma lista de professores começando em 1 para o usuário, mas a lista de fato começa em 0, logo precisa ser subtraido um do valor informado pelo usuário.
		if (posicaoProfessor < 0 || posicaoProfessor > professores.size()) {
			throw new IllegalArgumentException("ERRO: A posição informada é inválida !!!");
		}
		professores.remove(posicaoProfessor);
	}
	
	
	public void addAluno(Aluno alunoInformado) throws IllegalArgumentException {
		if (alunoInformado == null) {
			throw new IllegalArgumentException("ERRO: O aluno informado não pode ser nulo");
		}
		alunos.add(alunoInformado);
	}
	
	
	public String listarAlunos() {
		String listaDeAlunos = "Lista de alunos: \n";
		for (int i = 0; i < alunos.size(); i++) {
			listaDeAlunos += (i+1) + "º) Nome: " + alunos.get(i).getNome() + " --- Data Nascimento: " + alunos.get(i).getDataNascimento() + " --- Telefone: " + alunos.get(i).getTelefone() + "\n";
		}
		listaDeAlunos += "\n\n";
		return listaDeAlunos;
	}
	
	public void removeAluno(int posicaoAluno) throws IllegalArgumentException {
		posicaoAluno = posicaoAluno -1;
		if (posicaoAluno < 0 || posicaoAluno > alunos.size()) {
			throw new IllegalArgumentException("ERRO: A posição informada é inválida !!!");
		}
		alunos.remove(posicaoAluno);
	}
	
	public String buscarAlunosSoMusculacao() {
		String listaDeAlunos = "Lista de alunos: \n";
		for (int i = 0; i < alunos.size(); i++) {
			listaDeAlunos += (i+1) + "º) Nome: " + alunos.get(i).getNome() + " --- Data Nascimento: " + alunos.get(i).getDataNascimento() + " --- Telefone: " + alunos.get(i).getTelefone() + "\n";
		}
		listaDeAlunos += "\n\n";
		return listaDeAlunos;
	}

	public String AlunosProfessor(String nomeProfessor) {
		String listaDeAlunosProfessor = "Lista de alunos do professor " + nomeProfessor + ": \n";
		for (int i = 0; i < alunos.size(); i++) {
			if (nomeProfessor.equalsIgnoreCase(alunos.get(i).getProfessorAluno().getNome())) {
				listaDeAlunosProfessor += (i+1) + "º) Nome: " + alunos.get(i).getNome() + "\n";
			}
		}
		listaDeAlunosProfessor += "\n\n";
		return listaDeAlunosProfessor;
	}
	
}
