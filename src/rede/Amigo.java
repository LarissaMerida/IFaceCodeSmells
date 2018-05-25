package rede;

import model.Usuario;

public class Amigo extends RedeRelacionamento{
	
	public boolean aceitarSolicitacaoAmizade(Usuario usuarioSolicitante, Usuario usuarioAtivo){
		
		if(notIsNull(usuarioSolicitante)){
			usuarioAtivo.getListSolicitacaoAmizade().remove(usuarioSolicitante);
			usuarioAtivo.getListUser().add(usuarioSolicitante);
			usuarioSolicitante.getListUser().add(usuarioAtivo);
			
			return true;
		}
		return false;
	}
	
	public boolean adicionarAmigo(Usuario usuarioAtivo, String email){
		PersonFinder person = new PersonFinder();
		Usuario user = person.selectBy(getListUsuarios(), email, null);
		
		return notIsNull(user);
	}
	
	
}
