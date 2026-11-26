package principal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/*
 * 06 - Registro de medições em arquivo binário:
 * 
 * Implemente um programa que armazene medições de temperatura em medicoes.dat. 
 * 
 * Cada registro deve conter, nesta ordem, o código do sensor (int), a temperatura (double) 
 * e a indicação de que a medição foi validada (boolean).
 * 
 * O programa deve permitir acrescentar medições, preservando os registros existentes, e 
 * listar todas as medições armazenadas. 
 * 
 * Ao final da listagem, apresente a média das temperaturas das medições validadas. 
 * 
 * Exiba uma mensagem específica quando nenhuma medição tiver sido validada.
 * 
 */

public class ArmazenaMedicoesTemp {
	
	private List<Sensor> sensores;
	File medicoes;
	
	
	public ArmazenaMedicoesTemp() {
		sensores = new ArrayList<Sensor>();
		medicoes = new File("medicoes.dat");
		
	}
	
	

	public List<Sensor> getSensores() {
		return sensores;
	}

	public void setSensores(List<Sensor> sensores) {
		this.sensores = sensores;
	}
	
	
	// ---------- METODOS PRINCIPAIS ------ 
	
	
	public void addSensor(Sensor s) throws FileNotFoundException, IOException {
		sensores.add(s);
		armazenarMedicao(s);
	}
	
	public void armazenarMedicao(Sensor sensor) throws IOException, FileNotFoundException {
		
		FileOutputStream fos = new FileOutputStream(medicoes, true);
		
		try (DataOutputStream dos = new DataOutputStream(fos)) {
			
			dos.writeInt(sensor.getCodigo());
			dos.writeDouble(sensor.getTemperatura());
			dos.writeBoolean(sensor.isValidada());
			
		} catch (FileNotFoundException e) {
			throw e;
			
		} catch (IOException e) {
			throw e;
		}
		
	}
	
	public void carregarMedicoes() throws FileNotFoundException, IOException {
		
		FileInputStream fis = new FileInputStream(medicoes);
		DataInputStream dis = new DataInputStream(fis);
		
		while (fis.available() > 0) {
			int codigo = dis.readInt();
			double temperatura  = dis.readDouble();
			boolean validada = dis.readBoolean();
			
			Sensor s = new Sensor(codigo, temperatura, validada);
			sensores.add(s);
		}
		dis.close();

	}
	
	public String listarMedicoes() {
		String dados = "Lista de Medições cadastradas:";
		int qntTempValidadas = 0;
		double somaTempValidadas = 0;
		
		for (int i = 0; i < sensores.size(); i++) {
			
			String validadaString = "";
			
			if (sensores.get(i).isValidada()) {
				 validadaString = "Sim";
				 qntTempValidadas++;
				 somaTempValidadas+= sensores.get(i).getTemperatura();
			}
			else {
				validadaString = "Não";
			}
			
			dados += "\n Código: " + sensores.get(i).getCodigo() + "; Temperatura: " + sensores.get(i).getTemperatura() + "; Validada: " + validadaString;
		}
		
		if (qntTempValidadas > 0) {
			dados += "\n\nMédia das temperaturas das medições validadas:  " + somaTempValidadas/qntTempValidadas;
		}
		else {
			dados += "\n\nNão há medições validadas para calcular a média !!!";
		}
		
		
		return dados;
		
	}
	
}
