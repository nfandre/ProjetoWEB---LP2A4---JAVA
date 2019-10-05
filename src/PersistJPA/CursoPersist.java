package PersistJPA;

import java.util.List;

import javax.persistence.EntityManager;

import Model.Curso;
import bancoDados.ConnectionFactory;

public class CursoPersist {
	public Curso save(Curso curso) {
		EntityManager em = new ConnectionFactory().getConnection();
		try {
			em.getTransaction().begin();
			if(curso.getId() ==null) {
				em.persist(curso);
			}else {
				em.merge(curso);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			e.getMessage();
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		
		return curso;
	}
	public Curso findById(Integer id) {
		EntityManager em = new ConnectionFactory().getConnection();
		
		Curso c =null;
		try {
			c = em.find(Curso.class, id);
		} catch (Exception e) {
			e.getMessage();
		}finally {
			em.close();
		}
		
		return c;
	}
	public List<Curso> findAll(){
		EntityManager em = new ConnectionFactory().getConnection();
		List<Curso> cursos = null;
		try {
			cursos = em.createQuery("from Curso u").getResultList();
		} catch (Exception e) {
			e.getMessage();
		}finally {
			em.close();
		}
		return cursos;
		
	}
	
	public Curso remove(Integer id) {
		EntityManager em = new ConnectionFactory().getConnection();
		Curso c =null;
		try {
			c = em.find(Curso.class, id);
			em.getTransaction().begin();
			em.remove(c);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.getMessage();
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		return c;
	}
}
