package resources;


import java.util.ArrayList;

import model.Usuario;

public class Mensagem {
	private Usuario usuario;
	private String descricao;
	
	public Mensagem(Usuario usuario, String descricao) {
		this.usuario = usuario;
		this.descricao = descricao;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public ArrayList<Mensagem> getListMensagensByUser(Usuario remetente, ArrayList<Mensagem> listMensagens){
		ArrayList<Mensagem> listMensagem = new ArrayList<Mensagem>();
		
		for(Mensagem mensagem : listMensagens){
			if(mensagem.getUsuario().equals(remetente))
				listMensagem.add(mensagem);
		}
		return listMensagem;
	}



}
