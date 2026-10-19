package principal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Sistema {
	List<ContaBancaria> contasNormais;
	
	public Sistema() {
		contasNormais = new ArrayList<ContaBancaria>();
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
		String listaCompleta = "Lista de Contas: \n \n  Contas Normais: ";
		for (int i = 0; i < contasNormais.size(); i++) {
			listaCompleta += "\n" + (i+1) + "ª) Número: " + contasNormais.get(i).getNumero() + " - Saldo: " + contasNormais.get(i).getSaldo() + " - Titular: " + contasNormais.get(i).getTitular().getNome();
		}
		if (contasNormais.isEmpty()) {
			listaCompleta += "\n Sem contas normais !!!";
		}
		
		listaCompleta += "\n\n FIM DA LISTA !!! ";
		JOptionPane.showMessageDialog(null, listaCompleta);
	}

	
	private void transferirValor() {
		try {
			String numeroContaOrigem = JOptionPane.showInputDialog("Informe o Número da Conta de ORIGEM: ");
			String numeroContaDestino = JOptionPane.showInputDialog("Informe o Número da Conta de DESTINO: ");
		
			ContaBancaria contaOrigemEncontrada = null;
			ContaBancaria contaDestinoEncontrada =null;
			for (int i = 0; i < contasNormais.size(); i++) {
				if (contasNormais.get(i).getNumero().equalsIgnoreCase(numeroContaOrigem)) {
					contaOrigemEncontrada = contasNormais.get(i);
				}
				if (contasNormais.get(i).getNumero().equalsIgnoreCase(numeroContaDestino)) {
					contaDestinoEncontrada = contasNormais.get(i);
				}
				
			}
			
			
			String valorATransferirString =JOptionPane.showInputDialog("Informe o valor a transferir: ");
			double valorATransferir = Double.parseDouble(valorATransferirString);
			
			if (contaOrigemEncontrada != null) {
				if (contaDestinoEncontrada != null) {
					contaOrigemEncontrada.transferir(contaDestinoEncontrada, valorATransferir);
					JOptionPane.showMessageDialog(null, "O valor de R$ " + valorATransferir + " foi transferido para a conta nº " + contaDestinoEncontrada.getNumero());
				}
				
			}
				
			JOptionPane.showMessageDialog(null, "Transferência realizada com sucesso !!!");
			
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}

	private void sacarValor() {
		try {
			String numeroConta = JOptionPane.showInputDialog("Informe o Número da Conta");
			ContaBancaria contaNormalEncontrada = null;
			for (int i = 0; i < contasNormais.size(); i++) {
				if (contasNormais.get(i).getNumero().equalsIgnoreCase(numeroConta)) {
					contaNormalEncontrada = contasNormais.get(i);
				}
			}

			if (contaNormalEncontrada == null) {
				JOptionPane.showMessageDialog(null, "Nenhuma conta foi encontrada com esse número !!!");
			}
			else if (contaNormalEncontrada != null) {
				String valorASacarString =JOptionPane.showInputDialog("Informe o valor a sacar: ");
				double valorASacar = Double.parseDouble(valorASacarString);
				contaNormalEncontrada.sacar(valorASacar);
				JOptionPane.showMessageDialog(null, "Valor sacado com sucesso !!!");
			}
			
			
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}

	private void depositarValor() {
		try {
			String numeroConta = JOptionPane.showInputDialog("Informe o Número da Conta");
			ContaBancaria contaNormalEncontrada = null;
			for (int i = 0; i < contasNormais.size(); i++) {
				if (contasNormais.get(i).getNumero().equalsIgnoreCase(numeroConta)) {
					contaNormalEncontrada = contasNormais.get(i);
				}
			}
			if (contaNormalEncontrada == null) {
				JOptionPane.showMessageDialog(null, "Nenhuma conta foi encontrada com esse número !!!");
			}
			else if (contaNormalEncontrada != null) {
				String valorADepositarString =JOptionPane.showInputDialog("Informe o valor a depositar: ");
				double valorADepositar = Double.parseDouble(valorADepositarString);
				contaNormalEncontrada.depositar(valorADepositar);
				JOptionPane.showMessageDialog(null, "Valor depositado com sucesso !!!");
			}
			
			
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}

	private void deletarConta() {
		try {
			String numeroConta = JOptionPane.showInputDialog("Informe o Número da Conta");
			boolean contaRemovida = false;
			for (int i = 0; i < contasNormais.size(); i++) {
				if (contasNormais.get(i).getNumero().equalsIgnoreCase(numeroConta)) {
					contasNormais.remove(i);
					JOptionPane.showMessageDialog(null, "A conta Normal nº " + numeroConta + " foi removida com sucesso !!!");
					contaRemovida = true;
				}
			}

			if (contaRemovida == false) {
				JOptionPane.showMessageDialog(null, "Nenhuma conta foi encontrada com esse número !!!");
			}
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}

	private void criarConta() {
		try {
			Cliente novoCliente = new Cliente("Não Informado", "Não Informado");
			String nomeCliente = JOptionPane.showInputDialog("Informe o nome do cliente: ");
			novoCliente.setNome(nomeCliente);
			String enderecoCliente = JOptionPane.showInputDialog("Informe o endereço do cliente: ");
			novoCliente.setEndereco(enderecoCliente);
			String numeroInformado = JOptionPane.showInputDialog("Informe o número da conta: ");
			ContaBancaria novaConta = new ContaBancaria(numeroInformado, novoCliente);
			contasNormais.add(novaConta);
			JOptionPane.showMessageDialog(null, "Conta adicionada com sucesso !!!");
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			}
	}

	public static void main(String[] args) {
		new Sistema();
	}
}
