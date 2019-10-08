package PersistJPA;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Filter;
import org.hibernate.query.Query;

import Model.Usuario;
import bancoDados.ConnectionFactory;

public class UsuarioPersist {
	
	
	public Usuario save(Usuario usuario) {
		EntityManager em = new ConnectionFactory().getConnection();
		try {
			em.getTransaction().begin();
			if(usuario.getId() ==null) {
				em.persist(usuario);
			}else {
				em.merge(usuario);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			e.getMessage();
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		
		return usuario;
	}
	
	public Usuario findById(Integer id) {
		EntityManager em = new ConnectionFactory().getConnection();
		
		Usuario u =null;
		try {
			u = em.find(Usuario.class, id);
		} catch (Exception e) {
			e.getMessage();
		}finally {
			em.close();
		}
		
		return u;
	}
	
	public List<Usuario> findAll(){
		EntityManager em = new ConnectionFactory().getConnection();
		List<Usuario> usuarios = null;
		try {
			usuarios = em.createQuery("from Usuario u").getResultList();
		} catch (Exception e) {
			e.getMessage();
		}finally {
			em.close();
		}
		return usuarios;
		
	}
	
	public Usuario remove(Integer id) {
		EntityManager em = new ConnectionFactory().getConnection();
		Usuario u =null;
		try {
			u = em.find(Usuario.class, id);
			em.getTransaction().begin();
			em.remove(u);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.getMessage();
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		return u;
	}
    public Usuario VerificarSeUsuarioExiste(Usuario usuario) {
    	Usuario resultado = null;
    	for(Usuario u: findAll()) {
    		if(u.equals(usuario)) {
    			resultado = u;
    			break;
    		}
    	}
    	return resultado;
    }
    public boolean verificarSenhaEstaCorreta(Usuario usuario, String senha) {
    	boolean resultado = false;
    	for(Usuario u: findAll()) {
    		if(u.equals(usuario)) {
    			if(u.getSenha().trim().equals(senha)==true) {
        			
    				resultado = true;
        			break;
    			}

    		}
    	}
    	return resultado;
    }
    public Usuario verificarEmailExiste(String email) {
		EntityManager em = new ConnectionFactory().getConnection();
		
		Usuario u =null;
		try {
			String emailConsulta = "from Usuario u where email = '"+email+"'";
			List<Usuario> usuarios = null;
			usuarios = em.createQuery(emailConsulta).getResultList();
			u = em.find(Usuario.class, usuarios.get(0).getId());
		} catch (Exception e) {
			e.getMessage();
		}finally {
			em.close();
		}
		
		return u;
    }
	
	
}
