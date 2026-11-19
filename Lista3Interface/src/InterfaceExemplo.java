import java.util.List;

public interface InterfaceExemplo {
	// serve para definir metodos abstratos.
	//todos os metodos são publicos e abstratos.
	
	void somar(); // É equivalente a: public abstract void somar();
	
	
	boolean salvar(String caminhoArquivo); 
	// nada é implementado na interface. ela apenas serve de modelo para as classes.
	// apenas são declarados os métodos publicos e abstratos.
	
	List<String> ler (String caminhoArquivo);
	
	
	int getTamanhoArquivo();
	
	
}
