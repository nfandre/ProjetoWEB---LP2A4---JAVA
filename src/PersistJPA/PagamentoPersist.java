package PersistJPA;

import java.util.List;

import javax.persistence.EntityManager;

import Model.Pagamento;
import bancoDados.ConnectionFactory;

public class PagamentoPersist {

	public Pagamento save(Pagamento pagamento) {
		EntityManager em = new ConnectionFactory().getConnection();
		try {
			em.getTransaction().begin();
			if(pagamento.getId() ==null) {
				em.persist(pagamento);
			}else {
				em.merge(pagamento);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			e.getMessage();
			em.getTransaction().rollback();
		}finally {
			em.close();
		}

		
		return pagamento;
	}
	
	public Pagamento findById(Integer id) {
		EntityManager em = new ConnectionFactory().getConnection();
		
		Pagamento p =null;
		try {
			p = em.find(Pagamento.class, id);
		} catch (Exception e) {
			e.getMessage();
		}finally {
			em.close();
		}
		return p;
	}
	public List<Pagamento> findAll(){
		EntityManager em = new ConnectionFactory().getConnection();
		List<Pagamento> pagamentos = null;
		try {
			pagamentos = em.createQuery("from Pagamento p").getResultList();
		} catch (Exception e) {
			e.getMessage();
		}finally {
			em.close();
		}
		return pagamentos;
		
	}
	public Pagamento remove(Integer id) {
		EntityManager em = new ConnectionFactory().getConnection();
		Pagamento p =null;
		try {
			p = em.find(Pagamento.class, id);
			em.getTransaction().begin();
			em.remove(p);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.getMessage();
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		return p;
	}
	
}
