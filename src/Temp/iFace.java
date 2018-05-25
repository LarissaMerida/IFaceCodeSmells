package Temp;
import model.Usuario;
import rede.RedeRelacionamento;

public class iFace {
	public static Interface interfaceMenu = new Interface();
	public static Usuario usuarioAtivo = null;
	public static RedeRelacionamento redeRelacionamento = new RedeRelacionamento();
	
	public static void main(String[] args) {
		
		option();
		System.out.println("Sistema encerrado.");
	}

	private static void option() {
		ContaCommand command = new ContaCommand();
		command.execute(interfaceMenu, 
				usuarioAtivo, redeRelacionamento);
	}
	
}
