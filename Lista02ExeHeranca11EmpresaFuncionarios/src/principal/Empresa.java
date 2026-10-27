package principal;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
	
	private String nome;
	private List<Funcionario> funcionarios;
	
	public Empresa(String nome) throws IllegalArgumentException {
		setNome(nome);
		funcionarios = new ArrayList<Funcionario>();
	}
	
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) throws IllegalArgumentException {
		if (nome.isBlank() || nome.length() < 3) {
			throw new IllegalArgumentException("O nome não pode estar em branco e deve ter 3 letras ou mais !!!");
		}
		this.nome = nome;
	}
	
	public void incluirFuncionario(Funcionario f) throws IllegalArgumentException{
		if (f == null) {
			throw new IllegalArgumentException("O funcionario não pode ser nulo !!!");
		}
		funcionarios.add(f);
	}
	
	public void removerFuncionario(Funcionario f) throws IllegalArgumentException {
		if (f== null) {
			throw new IllegalArgumentException("O funcionario não pode ser nulo !!!");
		}
		
		boolean remover = funcionarios.remove(f);
		
		if (!remover) {
			throw new IllegalArgumentException("Item não encontrado!!!");
		}
		
	}
	
	public double calcularCustosSalarios() {
		double soma = 0;
		
		/*
		 Inicialmente havia feito assim:
		 
		 for (int i = 0; i < funcionarios.size(); i++) {
			Funcionario	funcionarioAtual = funcionarios.get(i);
			
			if (funcionarioAtual instanceof Programador) {
				// Se o funcionaro foi criado como uma instância de programador, forçamos a transformação dele na classe programador.
				Programador programadorAtual = (Programador) funcionarioAtual;
				double salarioFunAtual = programadorAtual.calcularSalario();
				soma += salarioFunAtual;
			}
			else if (funcionarioAtual instanceof Vendedor) {
				//Aqui também forçamos o funcionario a se tranformar, mas agora em vendedor.
				Vendedor vendedorAtual = (Vendedor) funcionarioAtual;
				double salarioFunAtual = vendedorAtual.calcularSalario();
				soma += salarioFunAtual;
			}
			else {
				throw new IllegalArgumentException("Erro ao identificar o tipo de funcionário !!!");
			}
			}
			
			--------------
			
			Contudo:
			Isso é a antítese do polimorfismo. 
			A principal razão de existir um método abstrato calcularSalario() na classe mãe Funcionario é justamente para que o sistema 
			não precise investigar "quem é quem" usando instanceof.   
			O polimorfismo permite que você dê uma ordem genérica à classe mãe, e o próprio Java se encarrega de redirecionar a execução para a classe filha 
			correta em tempo real. Se amanhã a empresa criar os cargos "Gerente" e "Estagiário", o seu código atual quebraria, exigindo que você abrisse 
			a classe Empresa para adicionar novos else if.   
			
			A Correção (O Poder do Polimorfismo):
			Você pode apagar todas as verificações de instanceof e casts. O método completo se resume a isso:
		 */
		
		for (Funcionario f : funcionarios) {
			
	        // O Java sabe automaticamente se f é Vendedor ou Programador na hora de calcular
			
	        soma += f.calcularSalario();
	    }
		
		
		
		
		return soma;
	}
	
	
	
}
