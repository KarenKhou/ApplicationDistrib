package com.example.td2karenjpa;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.math.BigDecimal;

@Stateless
public class aaaEJBBean {

  @PersistenceContext(unitName = "default")
  private EntityManager em;

  public aaaEJBBean() { }

  public String abc() {
    try {
      Employee e = new Employee("Karen Khoury", new BigDecimal("6000"));

      System.out.println("Persisting Employee...");
      em.persist(e);
      em.flush(); // Ensure the entity is saved

      System.out.println("Employee persisted with ID: " + e.getId());

      // Retrieve employee from the database
      TypedQuery<Employee> query = em.createNamedQuery("Employee.findById", Employee.class);
      query.setParameter("id", e.getId());
      Employee e1 = query.getSingleResult();

      return "Saved employee: " + e1.getName() + " with salary: " + e1.getSalary();
    } catch (Exception ex) {

      return "Failed to retrieve Employee.";
    }
  }
}
