package model;

import java.util.ArrayList;
import java.util.Calendar;

import resources.Mensagem;
import resources.Perfil;

public class Usuario extends Identification{
	private String email;
	private Perfil perfilUsuario;
	private String senha;
	private ArrayList<Comunidade> listComunidades;
	private ArrayList<Usuario> listSolicitacaoAmizade;

	public Usuario(String email, String senha, String nome) {
		super(nome, null,  new ArrayList<Mensagem>() , new ArrayList<Usuario>() );
		this.senha = senha;
		this.email = email;
		this.perfilUsuario = new Perfil(null, null, null);
		this.listComunidades = new ArrayList<Comunidade>();
		this.listSolicitacaoAmizade = new ArrayList<Usuario>();
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return this.senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Perfil getPerfilUsuario() {
		return perfilUsuario;
	}
	public void setPerfilUsuario(Perfil perfilUsuario) {
		this.perfilUsuario = perfilUsuario;
	}

	public ArrayList<Comunidade> getListComunidades() {
		return listComunidades;
	}
	public void setListComunidades(ArrayList<Comunidade> listComunidades) {
		this.listComunidades = listComunidades;
	}

	public ArrayList<Usuario> getListSolicitacaoAmizade() {
		return listSolicitacaoAmizade;
	}
	public void setListSolicitacaoAmizade(ArrayList<Usuario> listSolicitacaoAmizade) {
		this.listSolicitacaoAmizade = listSolicitacaoAmizade;
	}
	
}
