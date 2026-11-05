package principal;

import java.util.ArrayList;
import java.util.List;

public class Cardapio {
	
	private List<Pizza> pizzas;
	private String nomePizzaria;
	
	public Cardapio() {
		pizzas = new ArrayList<Pizza>();
		
	}

	public List<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

	public String getNomePizzaria() {
		return nomePizzaria;
	}

	public void setNomePizzaria(String nomePizzaria) {
		this.nomePizzaria = nomePizzaria;
	}
	
	public void addPizza(Pizza p) {
		pizzas.add(p);
	}
	
	public double calcSoma() {
		double soma = 0;
		for (Pizza pizza : pizzas) {
			soma += pizza.calcularPreco();
		}
		return soma;
	}
	
	
	
	
}
