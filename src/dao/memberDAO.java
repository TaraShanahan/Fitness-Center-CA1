/*
 * This DAO class will use JPA's Entity Manager to preform CRUD operations on the 
 * corresponding entity table ( member table). This will separate the database logic from my main application logic
 * "middleman" between application and the database. 
 */


package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.member;

public class memberDAO {
	
	protected static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("mydb"); 	
	// Saves a new member to the database, uses entity manager Persist to insert new member 
	public void persist(member member)
	{
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(member);
		em.getTransaction().commit();
		em.close();
	}
	// Retrieve a member by its primary key (id)
	public member find(int id)
	{
		EntityManager em = emf.createEntityManager();
		member m = em.find(member.class, id);
		em.close();
		return m; 
	}
	// returns a list of all the members 
	public List<member> getAllMembers()
	{
		EntityManager em = emf.createEntityManager();
		List<member> members = em.createQuery("FROM member", member.class).getResultList();
		em.close();
		return members;
	}
	// updates an existing member ( merge will update the entity) 
	public member merge( member member)
	{
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		member updated = em.merge(member);
		em.getTransaction().commit();
		em.close();
		return updated;
	}
	
	// Delete a member, the entity must first be merged in order to remove it
	public void remove(member member) {
	    EntityManager em = emf.createEntityManager();
	    em.getTransaction().begin();
	    em.remove(em.merge(member));
	    em.getTransaction().commit();
	    em.close();
	}
	
}
