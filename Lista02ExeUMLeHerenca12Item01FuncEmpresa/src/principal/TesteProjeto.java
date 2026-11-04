package principal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TesteProjeto {

	@Test
	void testeUnicoDoProjeto() {
		Empresa e = new Empresa();
		
		FuncionarioFixo ff = new FuncionarioFixo("Pedro", 1, 1000);
		FuncionarioHorista fh = new FuncionarioHorista("Ana", 2, 100, 12);
		FuncionarioComissionado fc = new FuncionarioComissionado("José", 3, 1000, 5000, 5);
		
		e.addfuncionario(fc);
		e.addfuncionario(fh);
		e.addfuncionario(ff);
		
		assertEquals("Pedro", ff.getNome());
		assertEquals(1, ff.getMatricula());
		assertEquals(1000, ff.calcularSalario());
		
		assertEquals("Ana", fh.getNome());
		assertEquals(2, fh.getMatricula());
		assertEquals(100, fh.getHorasTrabalhadas());
		assertEquals(12, fh.getValorHora());
		assertEquals(1200, fh.calcularSalario());
		
		
		assertEquals("José", fc.getNome());
		assertEquals(3, fc.getMatricula());
		assertEquals(1000, fc.getSalarioBase());
		assertEquals(5000, fc.getTotalVendas());
		assertEquals(5.0/100, fc.getPercentualComissao());
		assertEquals(1250, fc.calcularSalario());
		
		
		assertEquals("Lista de todos os funcionários: \n"
				+ "Nome: José - Matrícula: 3 - Salário: R$ 1250.0\n"
				+ "Nome: Ana - Matrícula: 2 - Salário: R$ 1200.0\n"
				+ "Nome: Pedro - Matrícula: 1 - Salário: R$ 1000.0\n\n Fim da Lista !!!", e.exibirDadosTodos());
		
		assertEquals(3450, e.calcularTotalFolha());
	}

}
