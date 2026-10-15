package principal;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	List<ContaBancaria> contas;
	
	public Sistema() {
		contas = new ArrayList<ContaBancaria>();
		
	}
	
	public static void main(String[] args) {
		new Sistema();
	}
}
