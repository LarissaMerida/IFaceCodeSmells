package model;

import java.util.ArrayList;

import resources.Mensagem;

public class Comunidade extends Identification{
	private int id;
	private Usuario usuario;
	
	public Comunidade(int id, Usuario usuario, String nome, String descricao) {
		super(nome, descricao, new ArrayList<Mensagem>(), new ArrayList<Usuario>());
		
		this.id = id;
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Comunidade getComunidadeByName(String nome, ArrayList<Comunidade> listComunidades){
		for(Comunidade comunidade : listComunidades){
			if(comunidade.getName().equals(nome))
				return comunidade;
		}
		return null;
	}

}
