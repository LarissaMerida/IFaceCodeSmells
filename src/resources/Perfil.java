package resources;


import java.util.Calendar;

public class Perfil {
	private String cidade;
	private Calendar dataNascimento;
	private String descricao;
	
	public Perfil(String cidade, Calendar dataNascimento, String descricao) {
		this.cidade = cidade;
		this.dataNascimento = dataNascimento;
		this.descricao = descricao;
	}
	
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public boolean isNULL(Calendar data) {
		return (data == null) ? true : false;
	}
	public int getIdade() {
		
		if(isNULL(dataNascimento)) {
			Calendar now = Calendar.getInstance();
			
			long millis = now.getTimeInMillis() - dataNascimento.getTimeInMillis();
				
			now.setTimeInMillis(millis);
			return now.get(Calendar.YEAR);
		}
		return 0;
	}
	
	public void editarPerfil(String novoValor, int opcao,Perfil  perfilUsuario){
		if(opcao == 1){
			perfilUsuario.setCidade(novoValor);
		}else{
			perfilUsuario.setDescricao(novoValor);
		}
	}
	public void editarPerfil(Calendar dataNascimento, Perfil  perfilUsuario){
		perfilUsuario.setDataNascimento(dataNascimento);
	}
	
}
