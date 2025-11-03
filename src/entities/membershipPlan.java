package entities;

import javax.persistence.*;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;


// JAX so entities can be serialized to XML in REST
@XmlRootElement(name = "membershipPlan")
@Entity
public class membershipPlan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;
	private String description;
	private double totalCost;
	
	@OneToMany (mappedBy = "plan")
	private List<member> members;
	
	public membershipPlan() {
		
	}
		public membershipPlan(String description, double totalCost)
		
		{
			this.description = description;
			this.totalCost = totalCost;
		}
		
		// getters and setters 
		public int getId()
		{
			return id;
		}
		public void setId(int id)
		{
			this.id = id;
		}
		
		public String getDescription()
		{
			return description;
		}
		public void setDescription(String description)
		{
			this.description = description;
		}
		
		public double getTotalCost()
		{
			return totalCost;
		}
		public void setTotalCost(double totalCost)
		{
			this.totalCost = totalCost;
		}
		
		public List<member> getMembers()
		{
			return members;
		}
		public void setMembers(List<member> members)
		{
			this.members = members;
		}

}
