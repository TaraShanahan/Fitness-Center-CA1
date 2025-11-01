package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.payment;

public class paymentDAO {
	
	protected static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("mydb"); 
	
	// Saves a new payments to the database
	public void persist(payment p)
	{
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}
	
	// Retrieve a payments by its primary key (id)
	public payment find(int id)
	{
		EntityManager em = emf.createEntityManager();
		payment pay = em.find(payment.class, id);
		em.close();
		return pay; 
	}
	
	// returns a list of all the payments 
	public List<payment> getAllPayments(int memberId)
	{
		EntityManager em = emf.createEntityManager();
		List<payment> pay = em.createQuery("SELECT p FROM payment p WHERE p.member = :mid", payment.class).setParameter("mid", memberId).getResultList();
		em.close();
		return pay;
	}
	// updates an existing payments ( merge will update the entity) 
	public payment merge( payment pay)
	{
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		payment updated = em.merge(pay);
		em.getTransaction().commit();
		em.close();
		return updated;
	}
	
	// Delete a payments, the entity must first be merged in order to remove it
	public void remove(payment pay) {
	    EntityManager em = emf.createEntityManager();
	    em.getTransaction().begin();
	    em.remove(em.merge(pay));
	    em.getTransaction().commit();
	    em.close();
	}
	
}