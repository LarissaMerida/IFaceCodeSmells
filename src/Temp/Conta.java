package Temp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import model.Comunidade;
import model.Usuario;
import rede.Amigo;
import rede.RedeRelacionamento;
import resources.Mensagem;
import resources.Perfil;

public class Conta {
	
	public Scanner input = new Scanner(System.in);
	
	public String getEmail() {
		System.out.println("Informe o email: ");
		 String email = input.nextLine();
		 return email;
	}
	public String getSenha(){
		System.out.println("Informe a senha: ");
		String senha = input.nextLine();
		return senha;
	}
	
	public Usuario entrar(RedeRelacionamento redeRelacionamento){
	
		return redeRelacionamento.getUsuario(getEmail(), getSenha());
	}
	
	public Usuario cadastrarUsuario(){

		System.out.println("Informe seu nome: ");
		String nome = input.nextLine();
		
		Usuario novoUsuario = new Usuario(getEmail(), getSenha(), nome);
		return novoUsuario;
	}
	
	public void adicionarAmigo(Usuario usuarioAtivo, RedeRelacionamento redeRelacionamento){
		
		System.out.println("Informe o email do amigo que deseja adicionar: ");
		String email = input.nextLine();
		
		Amigo amigo = new Amigo();
	
		if(amigo.adicionarAmigo(usuarioAtivo, email))
			System.out.println("Solicitacao de amizade enviada com sucesso!");
		else
			System.out.println("Nao foi possivel enviar o pedido de amizade!");
	}
	
	public void reativarConta(RedeRelacionamento redeRelacionamento){
		
		System.out.println("Conta desativada : ");
	
		if(redeRelacionamento.reativarUsuario(getEmail(), getSenha()))
			System.out.println("Conta reativada com sucesso!");
		else
			System.out.println("Conta inexistente.");
	}
	
	public void visualizarPedidosAmizade(Usuario usuarioAtivo,
			RedeRelacionamento redeRelacionamento){
		Amigo amigo = new Amigo();
		boolean flag = true;
		
		if(usuarioAtivo.getListSolicitacaoAmizade().size() > 0){
			System.out.println("Pedidos de Amizade: ");
			for(Usuario usuario : usuarioAtivo.getListSolicitacaoAmizade()){
				System.out.println("Nome: " + usuario.getName() + "\tEmail: " + usuario.getEmail());
			}
			
			while(flag){
				System.out.println("Deseja aceitar algum pedido de amizade? Se sim, digite o email da pessoa deseja: (Caso nao deseje digite '0')");
				String email = input.nextLine();
				
				if(email.equals("0") )
					flag = false;
				else if(email.equals(usuarioAtivo.getEmail())){
					System.out.println("Nao foi possivel encontrar este usuario em suas solicitacoes!");
					
				}
				else{
					boolean flagSolicitacao = amigo.aceitarSolicitacaoAmizade(redeRelacionamento.getUsuario(email, null),usuarioAtivo);
					if(flagSolicitacao)
						System.out.println("Voce adicionou " + redeRelacionamento.getUsuario(email, null).getName() + " como seu amigo!");
					else
						System.out.println("Nao foi possivel encontrar este usuario em suas solicitacoes!");
				}
				
			}
		}else{
			System.out.println("Voce nao possui nenhuma solicitacao de amizade!");
		}
		
	}
	
	public void enviarMensagem(Usuario usuarioAtivo, RedeRelacionamento redeRelacionamento){
	
		System.out.println("Digite a mensagem que voce deseja enviar:");
		String mensagem = input.nextLine();
		
		System.out.println("Voce deseja enviar para: \n\t1. Amigo\n\t2. Comunidade");
		System.out.println("Digite a opcao desejada:");
		int opcao = Integer.parseInt(input.nextLine());
		
		while(opcao < 1 || opcao > 2){
			System.out.println("Opcao invalida, digite novamente: ");
			opcao = Integer.parseInt(input.nextLine());
		}
		
		if(opcao == 1){
			System.out.println("Informacao do destinatario: ");
			
			redeRelacionamento.enviarMensagem(usuarioAtivo, mensagem, redeRelacionamento.getUsuario(getEmail(), null));
		}else{
			System.out.println("Digite o nome da comunidade que deseja enviar a mensagem: ");
			String nomeComunidade = input.nextLine();
			
			Comunidade comunidade = null;
			redeRelacionamento.enviarMensagem(usuarioAtivo, mensagem, comunidade.getComunidadeByName(nomeComunidade, usuarioAtivo.getListComunidades()));
		}
	}
	
	public boolean notIsNull(Usuario user) {
		
		return (user != null)? true : false;
	}

	public void visualizarMensagens(Usuario usuarioAtivo,RedeRelacionamento redeRelacionamento){

		System.out.println("Voce deseja visualizar as mensagens de:");
		System.out.println("\t1.Usuario\n\t2.Comunidade");
		System.out.println("Digite a opcao desejada:");
		int opcao = Integer.parseInt(input.nextLine());
		
		while(opcao < 1 || opcao > 2){
			System.out.println("Opcao invalida, digite novamente: ");
			opcao = Integer.parseInt(input.nextLine());
		}
		
		if(opcao == 1){
			Usuario remetente = redeRelacionamento.getUsuario(getEmail(), null);
			
			if(notIsNull(remetente)){
				Mensagem mensagens = null;
				ArrayList<Mensagem> listMensagem = mensagens.getListMensagensByUser(remetente, 
						usuarioAtivo.getListMensagens());
				
				if(listMensagem.size() > 0){
					System.out.println("Mensagens enviadas por " + remetente.getName());
					for(Mensagem mensagem : listMensagem){
						System.out.println("Mensagem: " + mensagem.getDescricao());
					}
				}else{
					System.out.println("Voce nao recebeu nenhuma mensagem deste usuario");
				}
			}else{
				System.out.println("Nao foi possivel encontrar este usuario!");
			}
		}else{
			System.out.println("Digite o nome da comunidade:");
			String nome = input.nextLine();
			
			Comunidade comunidade1 = null;
			Comunidade comunidade = comunidade1.getComunidadeByName(nome, 
					usuarioAtivo.getListComunidades());
			if(comunidade != null)
			{
				System.out.println("Mensagens em " + comunidade.getName());
				for(Mensagem mensagem : comunidade.getListMensagens())
					System.out.println("Mensagem: " + mensagem.getDescricao()
					  + " Enviada por " + mensagem.getUsuario().getName());
			}
			else
				System.out.println("Nao foi possivel encontrar esta comunidade!");	
		}
	}
	
	public void cadastrarComunidade(Usuario usuario, RedeRelacionamento redeRelacionamento){
		Scanner input = new Scanner(System.in);
		
		System.out.println("------- CADASTRAR COMUNIDADE --------\n");
		
		System.out.println("Informe o nome da comunidade que voce deseja cadastrar:");
		String nomeComunidade = input.nextLine();
		
		System.out.println("Informe uma descricao para a comunidade:");
		String descricao = input.nextLine();
		
		redeRelacionamento.cadastrarComunidade(usuario, nomeComunidade, descricao);
		
		System.out.println("Comunidade cadastrada com sucesso!");
	}
	
	public void entrarComunidade(Usuario usuario, RedeRelacionamento redeRelacionamento){
		Scanner input = new Scanner(System.in);
		
		System.out.println("------- ENTRAR COMUNIDADE -------\n");
		
		System.out.println("Informe o nome da comunidade em que voce deseja entrar:");
		String nomeComunidade = input.nextLine();
		
		boolean flag = redeRelacionamento.entrarComunidade(usuario, nomeComunidade);
		
		if(flag)
			System.out.println("Voce entrou com sucesso na comunidade " + nomeComunidade);
		else
			System.out.println("Nao foi possivel entrar na comunidade");
			
		
	}
	
	public Perfil criarPerfil(Usuario usuario, RedeRelacionamento redeRelacionamento) {
		Scanner input = new Scanner(System.in);
		
		if(usuario.getPerfilUsuario().getCidade() == null && usuario.getPerfilUsuario().getDataNascimento() == null) {
			System.out.println("------- CRIAR PERFIL ---------\n");
			System.out.println("Informe a cidade em que voce mora: ");
			String cidade = input.nextLine();
			
			System.out.println("Informe a data de seu nascimento no formato dd mm aaaa:");
			int dia = Integer.parseInt(input.nextLine());
			int mes = Integer.parseInt(input.nextLine());
			int ano = Integer.parseInt(input.nextLine());
			
			Calendar dataNascimento = Calendar.getInstance();
			dataNascimento.set(ano, mes, dia);
			
			System.out.println("Informe uma descricao para seu perfil:");
			String descricao = input.nextLine();
			
			Perfil perfil = new Perfil(cidade,dataNascimento,descricao);
			redeRelacionamento.getUsuario(usuario.getEmail(), null).setPerfilUsuario(perfil);
			
			System.out.println("Perfil criado com sucesso!");
		}else {
			System.out.println("------- EDITAR PERFIL -------\n");
			
			System.out.println("Informe a opcao que deseja alterar:");
			System.out.println("\t1.CIDADE");
			System.out.println("\t2.DATA DE NASCIMENTO");
			System.out.println("\t3.DESCRICAO");
			
			int opcao = Integer.parseInt(input.nextLine());
			while(opcao < 1 || opcao > 3) {
				System.out.println("Entrada invalida! Informe a opcao novamente");
				opcao = Integer.parseInt(input.nextLine());
			}
				
			switch(opcao) {
				case 1:
					System.out.println("Informe o nova cidade:");
					String cidade = input.nextLine();
					redeRelacionamento.getUsuario(usuario.getEmail(), null).getPerfilUsuario().setCidade(cidade);
					break;
				case 2:
					System.out.println("Informe a data de seu nascimento no formato dd mm aaaa:");
					int dia = Integer.parseInt(input.nextLine());
					int mes = Integer.parseInt(input.nextLine());
					int ano = Integer.parseInt(input.nextLine());
					
					Calendar dataNascimento = Calendar.getInstance();
					dataNascimento.set(ano, mes, dia);
					
					redeRelacionamento.getUsuario(usuario.getEmail(), null).getPerfilUsuario().setDataNascimento(dataNascimento);
					break;
				case 3:
					System.out.println("Informe a nova descricao do seu perfil:");
					String descricao = input.nextLine();
					
					redeRelacionamento.getUsuario(usuario.getEmail(), null).getPerfilUsuario().setDescricao(descricao);
					break;
			}
			
			System.out.println("Perfil alterado com sucesso!");
		}
		
		return redeRelacionamento.getUsuario(usuario.getEmail(), null).getPerfilUsuario();
	}
	
	public boolean apagarConta(Usuario usuarioAtivo, RedeRelacionamento redeRelacionamento){

		System.out.println("------- APAGAR CONTA --------\n");
		System.out.println("Voce deseja realmente apagar sua conta:");
		System.out.println("\t1.SIM");
		System.out.println("\t2.NAO");
		
		int opcao = Integer.parseInt(input.nextLine());
		
		while(opcao < 1 || opcao > 2){
			System.out.println("Opcao invalida. Informe novamente sua opcao:");
			opcao = Integer.parseInt(input.nextLine());
		}
		
		if(opcao == 1){
			(redeRelacionamento.getListUsuariosRemovidos()).add(usuarioAtivo);
			redeRelacionamento.getListUsuarios().remove(usuarioAtivo);
			
			System.out.println("Usuario apagado com sucesso!");
		}
		else
			return false;
		
		return true;
	}

}
