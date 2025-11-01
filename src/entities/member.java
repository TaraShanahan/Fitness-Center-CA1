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
	private String membershipId;
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
    public member(String membershipId, String name, String phone, String address, String fitnessGoal)
    {
    	this.membershipId = membershipId;
    	this.name = name;
    	this.phone = phone;
    	this.address = address;
    	this.fitnessGoal = fitnessGoal;
    	
    }
    
    
    
	

}
