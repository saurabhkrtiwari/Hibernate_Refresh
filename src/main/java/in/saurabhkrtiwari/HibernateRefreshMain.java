package in.saurabhkrtiwari;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class HibernateRefreshMain {
    public static void main(String[] args) {

        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Test Employee");
        employee.setAge(22);

        employee.setSsn("ssn");

        Employee employee1 = new Employee();
        employee1.setId(2);
        employee1.setName("Test Employee");
        employee1.setAge(22);

        employee1.setSsn("ssn");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(employee);
            transaction.commit();

            EntityTransaction transaction1 = entityManager.getTransaction();
            transaction1.begin();
            entityManager.persist(employee1);
            transaction1.commit();

        } finally {
        }
    }
}
