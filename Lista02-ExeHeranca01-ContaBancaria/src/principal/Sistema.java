package principal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Sistema {
	List<ContaBancaria> contasNormais;
	List<ContaEspecial> contasEspeciais;
	
	public Sistema() {
		contasNormais = new ArrayList<ContaBancaria>();
		contasEspeciais = new ArrayList<ContaEspecial>();
		String textoMenu = "Menu Principal - Escolha uma opção:" +
							"\n 1 - Criar Conta" +
							"\n 2 - Deletar conta " +
							"\n 3 - Depositar valor " +
							"\n 4 - Sacar valor " +
							"\n 5 - Transferir valor " +
							"\n 6 - Listar Todas as Contas " +
							"\n 0 - Encerrar sistema ";
		int opcao = -1;
		do {
			try {
				String opcaoEmString = JOptionPane.showInputDialog(textoMenu);
				opcao = Integer.parseInt(opcaoEmString);
			} catch (Exception e) {
				opcao = -1;
			}
			
			switch (opcao) {
			case 1:
				criarConta();
				break;
			case 2:
				deletarConta();
				break;
			case 3:
				depositarValor();
				break;
			case 4:
				sacarValor();
				break;
			case 5:
				transferirValor();
				break;
			case 6:
				listarcontas();
				break;
			case 0:
				JOptionPane.showMessageDialog(null, "Sistema encerrado !!!");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida - Retornando ao menu !!! ");
				break;
			}
		} while (opcao !=0);
		
		
	}
	
	private void listarcontas() {
		String listaCompleta = "Lista de Contas: \n Contas Normais: ";
		for (int i = 0; i < contasNormais.size(); i++) {
			listaCompleta += "\n" + (i+1) + "ª) Número: " + contasNormais.get(i).getNumero() + " - Saldo: " + contasNormais.get(i).getSaldo() + " - Titular: " + contasNormais.get(i).getTitular().getNome();
		}
		if (contasNormais.isEmpty()) {
			listaCompleta += "\n Sem contas normais !!!";
		}
		
		listaCompleta += "\n Contas especiais: ";
		
		for (int i = 0; i < contasEspeciais.size(); i++) {
			listaCompleta += "\n" + (i+1) + "ª) Número: " + contasEspeciais.get(i).getNumero() + " - Saldo: " + contasEspeciais.get(i).getSaldo() + " - Titular: " + contasEspeciais.get(i).getTitular().getNome();
		}
		if (contasEspeciais.isEmpty()) {
			listaCompleta += "\n Sem contas especiais !!!";
		}
		listaCompleta += "\n FIM DA LISTA !!! ";
		JOptionPane.showMessageDialog(null, listaCompleta);
	}

	private void transferirValor() {
		// TODO Auto-generated method stub
		
	}

	private void sacarValor() {
		// TODO Auto-generated method stub
		
	}

	private void depositarValor() {
		// TODO Auto-generated method stub
		
	}

	private void deletarConta() {
		// TODO Auto-generated method stub
		
	}

	private void criarConta() {
		try {
			Cliente novoCliente = new Cliente("Não Informado", "Não Informado");
			
			String nomeCliente = JOptionPane.showInputDialog("Informe o nome do cliente: ");
			novoCliente.setNome(nomeCliente);
			String enderecoCliente = JOptionPane.showInputDialog("Informe o endereço do cliente: ");
			novoCliente.setEndereco(enderecoCliente);
			
			int tipoConta;
			do {
				String tipoContaString = JOptionPane.showInputDialog("Informe o tipo de conta: \n 1- Normal \n 2 - Especial (com cheque especial)");
				tipoConta = Integer.parseInt(tipoContaString);
				String numeroInformado = JOptionPane.showInputDialog("Informe o número da conta: ");
				switch (tipoConta) {
				case 1:
					ContaBancaria novaConta = new ContaBancaria(numeroInformado, novoCliente);
					contasNormais.add(novaConta);
					break;
				case 2:
					String limiteEmString = JOptionPane.showInputDialog("Como se trata de uma conta especial, informe o limite de crédito: ");
					double limiteCredito = Double.parseDouble(limiteEmString);
					ContaEspecial novaContaEspecial = new ContaEspecial(numeroInformado, novoCliente, limiteCredito);
					contasEspeciais.add(novaContaEspecial);
					break;

				default:
					JOptionPane.showMessageDialog(null, "Opção inválida - tente novamente !!");
					break;
				}
			} while (tipoConta < 1 || tipoConta > 2);
			
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			}
	}

	public static void main(String[] args) {
		new Sistema();
	}
}
