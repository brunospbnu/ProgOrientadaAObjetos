package principal;

import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Menu {
	
	private String textoMenu;
	private int opcao;
	private ArmazenaMedicoesTemp arm;
	
	
	public static void main(String[] args) {
		new Menu();
	}
	
	public Menu() {
		textoMenu = "\nMenu --- Programa para Armazenar Temperaturas em Arquivo: " +
					"\n 1 - Cadastrar" +
					"\n 2 - Listar"+
					"\n 0 - Sair do Programa";
		opcao = -1;
		arm = new ArmazenaMedicoesTemp();
		executar();
	}
	
	private void executar() {
		
		
		try {
			arm.carregarMedicoes();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Não foi encontrado um arquivo - será criado um novo quando um dado for cadastrado !!!");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao abrir o arquivo de salvamento !!!");
			return;
		}
		
		
		do {
			String opcaoEmString = JOptionPane.showInputDialog(textoMenu);
			try {
				opcao = Integer.parseInt(opcaoEmString);
			} catch (Exception e) {
				// Deixado vazio pois vai cair no default lá em baixo.
			}
			switch (opcao) {
			
			case 0:
				JOptionPane.showMessageDialog(null, "Sistema encerrado !!!");
				break;
				
			case 1:
				cadastrar();
				break;
				
			case 2:
				listar();
				break;
				
			default:
				JOptionPane.showMessageDialog(null, "Opção Inválida - Tente novamente !!!");
				break;
			}
			
		} while (opcao != 0);

	}

	private void listar() {
		
		JOptionPane.showMessageDialog(null, arm.listarMedicoes());
		
	}

	private void cadastrar() {
		
		int codigo = 0;
		double temperatura = 0;
		
		try {
			String codigoString = JOptionPane.showInputDialog("Informe o código do sensor:");
			codigo = Integer.parseInt(codigoString);
			
		} catch (HeadlessException e) {
			JOptionPane.showMessageDialog(null, "Periféricos não encontrados !!!");
			return;
			
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "A entrada informada não é um número inteiro !!!");
			return;
		}
		
		try {
			String temperaturaString = JOptionPane.showInputDialog("Informe a temperatura: ");
			temperatura = Double.parseDouble(temperaturaString);
			
		} catch (HeadlessException e) {
			JOptionPane.showMessageDialog(null, "Periféricos não encontrados !!!");
			return;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "A entrada informada não é um número real !!!");
			return;
		}
		
		int validadaInt = JOptionPane.showConfirmDialog(null, "Informe se está validada ou não: ", "Validação", JOptionPane.YES_NO_OPTION);
		
		boolean validada;
		if (validadaInt == 0) {
			validada = true;
		}
		else {
			validada = false;
		}
		
		Sensor s = new Sensor(codigo, temperatura, validada);
		
		try {
			arm.addSensor(s);
			
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Arquivo não encontrado !!!");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao abrir o arquivo de salvamento !!!");
		}
		
		
	}

	public ArmazenaMedicoesTemp getArm() {
		return arm;
	}

	public void setArm(ArmazenaMedicoesTemp arm) {
		this.arm = arm;
	}
	
	




}
