package entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

// Jax annotations for xml support - enables xml output for member data

@XmlRootElement(name = "member")
@Entity

public class member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
    private String phone;
    private String address;
    private String fitnessGoal;
    
    // Relationships
    @ManyToOne
    private membershipPlan plan;
    @OneToMany(mappedBy = "member")
    private List<payment> payments;
    
    // JPA required constructore
    public member() {
    }
    public member(String name, String phone, String address, String fitnessGoal, membershipPlan plan)
    {

    	this.name = name;
    	this.phone = phone;
    	this.address = address;
    	this.fitnessGoal = fitnessGoal;
    	this.plan = plan;
    	
    	
    }
    // Getters and setters 
    public int getId()
    { return id;
    
    }
    public void setId(int id)
    {
    	this.id = id;
    }
    
    public String getName()
    {
    	return name;
    }
    public void setName(String name)
    {
    	this.name = name;
    }
    
    public String getPhone()
    {
    	return phone;
    }
    public void setPhone(String phone)
    {
    	this.phone = phone;
    }
    
    public String getAddress()
    {
    	return address;
    }
    public void setAddress(String address)
    {
    	this.address = address;
    }
    
    public String getFitnessGoal()
    {
    	retrun fitnessGoal;
    }
    public void setFitnessGoal( String fitnessGoal)
    {
    	this.fitnessGoal = fitnessGoal;
    }
    
    public membershipPlan getPlan()
    {
    	return plan;
    }
    public void getPlan()
    {
    	retrun plan;
    }
    
    public List<payment> getPayments()
    {
    	return payments;
    }
    public void setPayments(List <payments> payments)
    {
    	this.payments = payments;
    }
    
	

}
