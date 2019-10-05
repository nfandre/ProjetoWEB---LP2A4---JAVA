package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id;
	private String cpf;
	private String nome;
	private String email;
	private String senha;
	public String getCpf() {
		return cpf;
	}
	
	
	
	public Integer getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	
	
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		
		if(obj.getClass() == this.getClass()){
			Usuario outroUser = (Usuario)obj;
			
			result = this.getCpf().equals(outroUser.getCpf());
			
			result = result || this.getEmail().equals(outroUser.getEmail());
			
			
		}
		return result;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", cpf=" + cpf + ", email=" + email + "]";
	}
	

	
	
	
}
