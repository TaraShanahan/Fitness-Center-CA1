package main;
import entities.member;
import entities.membershipPlan;
import entities.payment;

import dao.memberDAO;
import dao.membershipPlanDAO;
import dao.paymentDAO;

import java.util.List;

public class test {
	public static void main(String[] args)
	{
		// make the DAO objects
		membershipPlanDAO planDao = new membershipPlanDAO();
		memberDAO memberDao = new memberDAO();
		paymentDAO payDao = new paymentDAO();
		
		// creating a membership plan and save it to the db 
		membershipPlan plan = new membershipPlan();
		plan.setDescription("Muscle Bulk");
		plan.setTotalCost(30);
		planDao.persist(plan);
		System.out.println("new gym plan : " + plan.getDescription());
		
		// making a member and putting them on the new saved plan 
		member m = new member();
		m.setName("Matt Morrison");
		m.setPhone("0874684644");
		m.setAddress("Meath");
		m.setFitnessGoal("build muscle tone");
		m.setPlan(plan);   // should link to the plan ( many to one) 
		memberDao.persist(m);
		System.out.println("Saved member : " + m.getName());
		
		
		// record a payment for the new member 
		payment p = new payment();
		p.setDate("29/07/2025");
		p.setAmount(30);
		p.setMember(m);
		payDao.persist(p);
		System.out.println("Previous payment: " + p.getAmount());
		
		// return the member and their payments...
		member returned = memberDao.find(m.getId());
		System.out.println("Current member: " + returned.getName() + " Current members plan : " + (returned.getPlan()));
		
		List<payment> paymentsForMember = payDao.getAllPayments(m.getId());
		System.out.println("Payments for " + returned.getName() + ":");
		for (payment pay : paymentsForMember)
		{
			System.out.println("Date : " + pay.getDate() + "$ :" + pay.getAmount());
		}
		
		// Show all members
		System.out.println("All members: ");
		for( member mem : memberDao.getAllMembers())
		{
			System.out.println("ID: " + mem.getId() + ", Name:  " + mem.getName());
		}
		
	}

}
