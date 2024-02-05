package in.saurabhkrtiwari;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class JPQLExample {
    public static void main(String[] args) {
        //getAllEmployees();
        getAllEmployeesWithActiveAccessCard();
    }

    private static void getAllEmployeesWithActiveAccessCard() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager =entityManagerFactory.createEntityManager();

        TypedQuery<Employee> employeeTypedQuery = entityManager.createQuery("select e from Employee e where e.accessCard.isActive=true",Employee.class);
        List<Employee> resultList = employeeTypedQuery.getResultList();
        resultList.forEach(System.out::println);

        entityManager.close();
        entityManagerFactory.close();
    }

    private static void getAllEmployees() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager =entityManagerFactory.createEntityManager();

        TypedQuery<Employee> employeeTypedQuery = entityManager.createQuery("select e from Employee e",Employee.class);
        List<Employee> resultList = employeeTypedQuery.getResultList();
        resultList.forEach(System.out::println);

        entityManager.close();
        entityManagerFactory.close();
    }
}
