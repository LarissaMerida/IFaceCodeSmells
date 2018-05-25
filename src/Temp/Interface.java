package Temp;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import model.Comunidade;
import model.Usuario;
import rede.AndSpec;
import rede.RedeRelacionamento;
import resources.Mensagem;
import resources.Perfil;

public class Interface {
	
	
	public String principal(Usuario usuario){
		Scanner input = new Scanner(System.in);
		boolean flag = false;
		String opcao = "0";
		int op;
		
		System.out.println("\t\tiFace");
		System.out.println("\n------------ MENU PRINCIPAL --------------- \n");
		
		if(usuario == null){
			System.out.println("\t1. Entrar com sua conta");
			System.out.println("\t2. Criar uma nova conta");
			System.out.println("\t3. Reativar sua conta");
		}else{
			System.out.println("Bem vindo, " + usuario.getName());
			
			System.out.println("\t1. Criar/Editar Perfil");
			System.out.println("\t2. Adicionar Amigo");
			System.out.println("\t3. Visualizar Pedidos de Amizade");
			System.out.println("\t4. Enviar Mensagem");
			System.out.println("\t5. Visualizar Mensagens");
			System.out.println("\t6. Criar comunidade");
			System.out.println("\t7. Entrar em uma comunidade");
			System.out.println("\t8. Apagar sua conta");
			System.out.println("\t9. Sair da conta");
		}
		
		System.out.println("\t0. Sair do sistema");
		
		while(!flag){
			System.out.println("Informe a opcao desejada: ");
			opcao = input.nextLine();
			
			if(opcao.length() == 1 && opcao.matches("^[0-9]*$") == true)
			{
				op = Integer.parseInt(opcao);
					
				if((op >= 0 && op <= 9 && usuario != null) || (op >= 0 && op <= 3))
					flag = true;
				else
					System.out.println("Opcao invalida!");
			}
			else
				System.out.println("Opcao invalida!");	
		}
		
		return opcao;	
	}
	
}
