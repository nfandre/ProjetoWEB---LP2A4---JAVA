package tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Usuario;
import bancoDados.ConnectionFactory;

public class UsuarioTest {

	public static void main(String[] args) {
		Usuario u = new Usuario();
		u.setCpf("4545");
		u.setEmail("dfsaf");
		u.setNome("addfs");
		u.setSenha("sdfsadf");
		
		EntityManager em = new ConnectionFactory().getConnection();
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		em.close();
	}
}
