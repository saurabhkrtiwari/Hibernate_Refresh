package in.saurabhkrtiwari;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.Date;

public class HibernateRefreshMain {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityManagerFactory entityManagerFactory2 = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager2 = entityManagerFactory.createEntityManager();


        saveDemo(entityManagerFactory,entityManager);
        readDemo(entityManagerFactory2,entityManager2);

        entityManager.close();
        entityManagerFactory.close();
        entityManager2.close();
        entityManagerFactory2.close();

    }

    private static void readDemo(EntityManagerFactory entityManagerFactory, EntityManager entityManager) {
        Employee employee = entityManager.find(Employee.class, 1);
        System.out.println("********Employee **********");
        System.out.println(employee.getName());
        System.out.println("********Employee Access Card **********");
        System.out.println(employee.getAccessCard());
    }

    private static void saveDemo(EntityManagerFactory entityManagerFactory, EntityManager entityManager) {
        Employee employee = new Employee();
        employee.setName("Test Employee");
        employee.setAge(22);
        employee.setDob(new Date());
        employee.setUpdateTime(new Date());
        employee.setEmployeeType(EmployeeType.FULLTIME);


        employee.setSsn("ssn");



        Employee employee1 = new Employee();
        employee1.setName("Test Employee");
        employee1.setAge(22);

        employee1.setSsn("ssn1");
        employee1.setDob(new Date());
        employee1.setUpdateTime(new Date());
        employee1.setEmployeeType(EmployeeType.TEMPERORY);


        AccessCard accessCard1 = new AccessCard();
        accessCard1.setActive(true);
        accessCard1.setFirmwareVersion("1.0");
        accessCard1.setIssuedDate(new Date());
        employee.setAccessCard(accessCard1);

        AccessCard accessCard2 = new AccessCard();
        accessCard2.setActive(true);
        accessCard2.setFirmwareVersion("1.0");
        accessCard2.setIssuedDate(new Date());
        employee1.setAccessCard(accessCard2);

        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(employee);
            entityManager.persist(employee1);
            entityManager.persist(accessCard1);
            entityManager.persist(accessCard2);
            transaction.commit();




        } finally {
        }
    }
}
