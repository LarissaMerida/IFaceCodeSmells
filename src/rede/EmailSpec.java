package rede;

import model.Usuario;

public class EmailSpec extends Specification{
	private String email;

	public EmailSpec(String email) {
		this.email = email;
	}
	
	@Override
	public boolean isSatisfiedBy(Usuario usuario) {
		
		return usuario.getEmail().equals(this.email);
	}
}
