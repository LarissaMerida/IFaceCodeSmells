package Temp;

import model.Usuario;
import rede.RedeRelacionamento;

public interface CommandOption {
	
	public void execute();

	void execute(Interface interfaceMenu, Usuario usuarioAtivo, RedeRelacionamento redeRelacionamento);
	
}
