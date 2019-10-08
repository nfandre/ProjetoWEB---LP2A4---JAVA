package teste;

import Model.Usuario;
import PersistJPA.UsuarioPersist;


public class testes {

	public static void main(String[] args) {
		Usuario u = new Usuario();
		UsuarioPersist up = new UsuarioPersist();
		u.setCpf("cpf");
		u.setEmail("email");
		u.setNome("nome");
		u.setSenha("senha");
		up.save(u);

	}

}
