package principal;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class TestarProjeto {

	@Test
	void testeSolicitado() {
		Empresa e = new Empresa("Nome não definido");
		
		
		//VENDEDORES:
		Vendedor luiz = new Vendedor("Luiz", 1000, 10);
		Vendedor paula = new Vendedor("Paula", 1200, 7);
		
		e.incluirFuncionario(luiz);
		e.incluirFuncionario(paula);
		
		
		//Vendas Luiz
		Venda vl1 = new Venda(200);
		Venda vl2 = new Venda(100);
		luiz.incluirVenda(vl1);
		luiz.incluirVenda(vl2);
		
		//Vendas Paula
		Venda vp1 = new Venda(500);
		Venda vp2 = new Venda(350);
		Venda vp3 = new Venda(280);
		paula.incluirVenda(vp1);
		paula.incluirVenda(vp2);
		paula.incluirVenda(vp3);
		
		
		
		//PROGRAMADORES:
		Programador julio = new Programador("Julio", 1000);
		Programador ana = new Programador("Ana", 1000);
		Programador anderson = new Programador("Anderson", 1200);
		
		e.incluirFuncionario(julio);
		e.incluirFuncionario(ana);
		e.incluirFuncionario(anderson);
		
		//Definindo linguagens conhecidas.
		julio.incluirLinguagem("C");
		julio.incluirLinguagem("Java");
		ana.incluirLinguagem("Java");
		ana.incluirLinguagem("C#");
		anderson.incluirLinguagem("Phyton");
		
		
		
		// verificando saidas esperadas:
		
		/*
		 Salarios
		 
		 Vendedores:
		 Luiz: 1000 + (200 + 100)*0.1 = 1030
		 Paula: 1200 + (500 + 350 + 280)*0.07 = 1279,1
		 
		 Programadores (+ 20% se conhecem java):
		 Julio: 1000 + 20% = 1200
		 Ana: 1000 + 20% = 1200
		 Anderson: 1200
		 
		 TOTAL = 5.909,10.
		 
		 */
		
		
		//Custo total de salarios da empresa:
		assertEquals(5909.10, e.calcularCustosSalarios());
		
		//Nomes de funcionarios e salário:
		assertEquals("Luiz", e.getFuncionarios().get(0).getNome());
		assertEquals(1030, e.getFuncionarios().get(0).calcularSalario());
		
		assertEquals("Paula", e.getFuncionarios().get(1).getNome());
		assertEquals(1279.1, e.getFuncionarios().get(1).calcularSalario());
		
		assertEquals("Julio", e.getFuncionarios().get(2).getNome());
		assertEquals(1200, e.getFuncionarios().get(2).calcularSalario());
		
		assertEquals("Ana", e.getFuncionarios().get(3).getNome());
		assertEquals(1200, e.getFuncionarios().get(3).calcularSalario());
		
		assertEquals("Anderson", e.getFuncionarios().get(4).getNome());
		assertEquals(1200, e.getFuncionarios().get(4).calcularSalario());
		
		
		//Listar o nome dos vendedores e o percentual de comissão de cada um:
		assertEquals("Luiz", e.getFuncionarios().get(0).getNome());
		assertEquals(10, luiz.getPercentualComissao());
		
		assertEquals("Paula", e.getFuncionarios().get(1).getNome());
		assertEquals(7, paula.getPercentualComissao());
		
		//Listar os programadores e as linguagens que cada um conhece
		assertEquals(List.of("C", "Java"), julio.getLinguagens());
		
		assertEquals(List.of("Java", "C#"), ana.getLinguagens());
		
		assertEquals(List.of("Phyton"), anderson.getLinguagens());
	}

}
