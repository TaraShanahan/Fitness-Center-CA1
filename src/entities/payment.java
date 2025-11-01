package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "payment")
@Entity
public class payment {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String date;
private double amount;

@ManyToOne
private member member;

public payment ()
{
	
}
public payment(String date, double amount, member member)
{
	this.date = date;
	this.amount = amount;
	this.member = member;
}
// getters and setters 
}
