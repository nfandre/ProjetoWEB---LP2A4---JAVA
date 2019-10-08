package teste;

import Model.Cliente;
import Model.Curso;
import Model.Usuario;
import PersistJPA.ClientePersist;
import PersistJPA.CursoPersist;
import PersistJPA.UsuarioPersist;


public class testes {

	public static void main(String[] args) {
//		Usuario u = new Usuario();
//		UsuarioPersist up = new UsuarioPersist();
//		u.setCpf("cpf");
//		u.setEmail("email");
//		u.setNome("nome");
//		u.setSenha("senha");
//		up.save(u);
		
//		Curso c = new Curso();
//		c.setNome("aaa");
//		c.setSite("ddddddddd");
//		c.setValor("250");
//		CursoPersist cp = new CursoPersist();
//		cp.save(c);
		Cliente cl = new Cliente();
		ClientePersist cpp = new ClientePersist();
		cpp.save(cl);

	}

}
