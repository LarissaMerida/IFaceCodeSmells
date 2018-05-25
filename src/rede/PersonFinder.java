package rede;

import java.util.ArrayList;

import model.Usuario;

public class PersonFinder {

	public Usuario selectBy(ArrayList<Usuario> users, 
			String email, String senha) {
		
		Specification spec;
		if(isNull(senha)) {
			spec = new EmailSpec(email); 
		}else
			spec = new AndSpec(email, senha);
		
		for(Usuario t : users){
			
			if(spec.isSatisfiedBy(t)){
					return t;
			}
		}
		return null;
	}

	private boolean isNull(String senha) {
		
		return (senha == null) ? true : false;
	}

}
