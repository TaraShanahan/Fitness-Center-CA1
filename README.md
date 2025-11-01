# 🏋️‍♂️Fitness-Center-CA1 🏋️‍♂️
CA1 for Distributed Systems

## 📚 Description 
This is a RESTful web service for managing Members, Membership Plans and Payments for a comunity fitness center. 

I will build it with RESTeasy ( JAX ) , Hibernate ( JPA ) and MYSQL, and i will test it with Postman. 

## 📖 Tech Stack
- Language: Java
- REST: JAX via RESTeasy
- Persistance: Hibernate (JPA)
- DB: MYSQL
- Server: Servlet container (Tomcat)
- Testing: Postman

## 🏗️ Architecture
- membershipPlan : id (PK), description, totalCost
- member : id (PK), membershipId, name, phone, address, fitnessGoal
- payment : id (PK), date, amount

## 🔃 ERD
- Membership plan (1) ----> (N) Member
- Member (1) ----> (N) Payments
  
