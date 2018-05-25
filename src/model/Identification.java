package model;

import java.util.ArrayList;

import resources.Mensagem;

public class Identification {
	private String name;
	private ArrayList<Mensagem> listMensagens;
	private ArrayList<Usuario> listUser;
	private String MoreInformation;
	
	public Identification(String name, String MoreInformation,  ArrayList<Mensagem> Mensagens,
			ArrayList<Usuario> listUser ) {
		this.name = name;
		this.MoreInformation = MoreInformation;
		this.listMensagens = Mensagens;
		this.listUser = listUser;
	}
	
	public String getMoreInformation() {
		return this.MoreInformation;
	}
	public void setMoreInformation(String moreInformation) {
		MoreInformation = moreInformation;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<Mensagem> getListMensagens() {
		return this.listMensagens;
	}
	public void setListMensagens(ArrayList<Mensagem> listMensagens) {
		this.listMensagens = listMensagens;
	}
	
	public ArrayList<Usuario> getListUser() {
		return this.listUser;
	}
	public void setListUser(ArrayList<Usuario> listUser) {
		this.listUser = listUser;
	}
	
}
