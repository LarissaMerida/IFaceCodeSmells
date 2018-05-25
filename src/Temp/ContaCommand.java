package Temp;

import model.Usuario;
import rede.RedeRelacionamento;

public class ContaCommand implements CommandOption {
	public Conta conta;
	public CommandOption command;

	public ContaCommand() {}

	public boolean notIsNull(Usuario user) {
		
		return (user != null)? true : false;
	}
	
	@Override
	public void execute(Interface interfaceMenu, 
			Usuario usuarioAtivo, RedeRelacionamento redeRelacionamento) {
		String opcao;
		
		do {
			opcao = interfaceMenu.principal(usuarioAtivo);
			
			switch(opcao){
				case "1":
					if(notIsNull(usuarioAtivo)){
						usuarioAtivo = conta.entrar(redeRelacionamento);
						
						if(!notIsNull(usuarioAtivo))
							System.out.println("Email ou senha incorreta!");
						
					}else{
						usuarioAtivo.setPerfilUsuario(conta.criarPerfil(usuarioAtivo,redeRelacionamento));
					}
					
					break;
				case "2":
					if(!notIsNull(usuarioAtivo)){
						Usuario novoUsuario = conta.cadastrarUsuario();
						redeRelacionamento.adicionarUsuario(novoUsuario);
						usuarioAtivo = novoUsuario;
						
					}else{
						conta.adicionarAmigo(usuarioAtivo,redeRelacionamento);
					}
					
					break;
				case "3":
					if(!notIsNull(usuarioAtivo)){
						conta.reativarConta(redeRelacionamento);
					}else{
						conta.visualizarPedidosAmizade(usuarioAtivo,redeRelacionamento);
					}

					break;
				case "4":
					conta.enviarMensagem(usuarioAtivo, redeRelacionamento);
					break;
				case "5":
					conta.visualizarMensagens(usuarioAtivo, redeRelacionamento);
					break;
				case "6":
					conta.cadastrarComunidade(usuarioAtivo, redeRelacionamento);
					break;
				case "7":
					conta.entrarComunidade(usuarioAtivo, redeRelacionamento);
					break;
				case "8":
					boolean flag = conta.apagarConta(usuarioAtivo, redeRelacionamento);
					if(flag)
						usuarioAtivo = null;
					break;
				case "9":
					usuarioAtivo = null;
					break;
			}
			
		}while(opcao.equals("0") == false);	
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
}
