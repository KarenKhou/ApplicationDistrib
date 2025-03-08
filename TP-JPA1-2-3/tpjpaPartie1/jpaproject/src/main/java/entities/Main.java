import entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.math.BigDecimal;


public class Main {
    public static void main(String[] args) {
        // Create an EntityManagerFactory for the persistence unit
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        // Create a new Employee instance
        Employee employee = new Employee();
        employee.setId(1234);
        employee.setName("Bill Gates"); // ✅ Ajoute une valeur pour `name`
        employee.setSalary(new BigDecimal(40));


        // Begin a transaction, persist the employee, and commit the transaction
        em.getTransaction().begin();
        em.merge(employee);
        em.getTransaction().commit();

        // Close the EntityManager and EntityManagerFactory
        em.close();
        emf.close();
    }
}
