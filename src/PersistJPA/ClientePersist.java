package PersistJPA;

import java.util.List;

import javax.persistence.EntityManager;

import Model.Cliente;
import Model.Usuario;
import bancoDados.ConnectionFactory;

public class ClientePersist {
	public Cliente save(Cliente cliente) {
		EntityManager em = new ConnectionFactory().getConnection();
		try {
			em.getTransaction().begin();
			if(cliente.getId() ==null) {
				em.persist(cliente);
			}else {
				em.merge(cliente);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			e.getMessage();
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		
		return cliente;
	}
	public Cliente findById(Integer id) {
		EntityManager em = new ConnectionFactory().getConnection();
		
		Cliente c =null;
		try {
			c = em.find(Cliente.class, id);
		} catch (Exception e) {
			e.getMessage();
		}finally {
			em.close();
		}
		
		return c;
	}
	public List<Cliente> findAll(){
		EntityManager em = new ConnectionFactory().getConnection();
		List<Cliente> clientes = null;
		try {
			clientes = em.createQuery("from Cliente c").getResultList();
		} catch (Exception e) {
			e.getMessage();
		}finally {
			em.close();
		}
		return clientes;
		
	}
}
