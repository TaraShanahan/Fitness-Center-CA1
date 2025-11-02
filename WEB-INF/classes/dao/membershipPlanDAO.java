package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.membershipPlan;

public class membershipPlanDAO {
	
	protected static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("mydb"); 
	
	// Saves a new plan to the database
	public void persist(membershipPlan plan)
	{
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(plan);
		em.getTransaction().commit();
		em.close();
	}
	
	// Retrieve a plan by its primary key (id)
	public membershipPlan find(int id)
	{
		EntityManager em = emf.createEntityManager();
		membershipPlan p = em.find(membershipPlan.class, id);
		em.close();
		return p; 
	}
	
	// returns a list of all the plans 
	public List<membershipPlan> getAllPlans()
	{
		EntityManager em = emf.createEntityManager();
		List<membershipPlan> plans = em.createQuery("FROM membershipPlan", membershipPlan.class).getResultList();
		em.close();
		return plans;
	}
	// updates an existing membershipPlan ( merge will update the entity) 
	public membershipPlan merge( membershipPlan plan)
	{
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		membershipPlan updated = em.merge(plan);
		em.getTransaction().commit();
		em.close();
		return updated;
	}
	
	// Delete a membershipPlan, the entity must first be merged in order to remove it
	public void remove(membershipPlan plan) {
	    EntityManager em = emf.createEntityManager();
	    em.getTransaction().begin();
	    em.remove(em.merge(plan));
	    em.getTransaction().commit();
	    em.close();
	}
	
}
