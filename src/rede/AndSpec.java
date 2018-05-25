package rede;

import model.Usuario;

public class AndSpec extends Specification{
	private String email, passsword;

	public AndSpec(String email, String passsword) {
		this.email = email;
		this.passsword = passsword;
	}
	
	@Override
	public boolean isSatisfiedBy(Usuario usuario) {
		
		return usuario.getEmail().equals(this.email) && 
				usuario.getSenha().equals(this.passsword);
	}

}
