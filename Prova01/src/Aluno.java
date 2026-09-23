import java.util.Date;

public class Aluno {
	private String nome;
	private Date dataNascimento;
	private String telefone;
	private String atividadeExtra1;
	private String atividadeExtra2;
	private Professor professorAluno;
	
	public Aluno(String nome, Date dataNascimento, String telefone, Professor professorInformado) throws IllegalArgumentException {
		setNome(nome);
		setDataNascimento(dataNascimento);
		setTelefone(telefone);
		setProfessorAluno(professorInformado);
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nomeInformado) throws IllegalArgumentException {
		if (nomeInformado == null || nomeInformado.isBlank() || nomeInformado.length() < 3) {
			throw new IllegalArgumentException("ERRO: O nome não pode estar vazio e deve ter mais de 3 letras !!!");
		} 
		nome = nomeInformado;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Date dataNascimentoInformada) throws IllegalArgumentException {
		if (dataNascimentoInformada == null) {
			throw new IllegalArgumentException("ERRO: A data não pode ser nula");
		}
		dataNascimento = dataNascimentoInformada;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefoneInformado) throws IllegalArgumentException {
		if (telefoneInformado ==  null || telefoneInformado.isEmpty()) {
			throw new IllegalArgumentException("ERRO: Telefone vazio: O telefone não pode estar vazio !!!");
		}
		if (telefoneInformado.length() != 11) {
			throw new IllegalArgumentException("ERRO: Telefone inválido: O telefone deve conter exatamente 11 números sendo os 2 primeiros o DDD do estado !!!");
		}
		telefone = telefoneInformado;
	}
	
	public String getAtividadeExtra1() {
		return atividadeExtra1;
	}
	
	public void setAtividadeExtra1(String atividadeExtra1Informada) throws IllegalArgumentException {
		if (!atividadeExtra1Informada.equalsIgnoreCase("funcional") && !atividadeExtra1Informada.equalsIgnoreCase("corrida") && !atividadeExtra1Informada.equalsIgnoreCase("bike")) {
			throw new IllegalArgumentException("ERRO: A atividade informada é inválida. A atividade extra deve ser: funcional, corrida ou bike!!!");
		}
		atividadeExtra1 = atividadeExtra1Informada;
	}
	
	public String getAtividadeExtra2() {
		return atividadeExtra2;
	}
	
	public void setAtividadeExtra2(String atividadeExtra2Informada) throws IllegalArgumentException {
		if (!atividadeExtra2Informada.equalsIgnoreCase("funcional") && !atividadeExtra2Informada.equalsIgnoreCase("corrida") && !atividadeExtra2Informada.equalsIgnoreCase("bike")) {
			throw new IllegalArgumentException("ERRO: A atividade informada é inválida. A atividade extra deve ser: funcional, corrida ou bike!!!");
		}
		atividadeExtra2 = atividadeExtra2Informada;
	}
	
	public Professor getProfessorAluno() {
		return professorAluno;
	}
	
	public void setProfessorAluno(Professor professorAluno) {
		if (professorAluno == null) {
			throw new IllegalArgumentException("ERRO: O professor não pode ser nulo");
		}
		this.professorAluno = professorAluno;
	}
	
	
}
