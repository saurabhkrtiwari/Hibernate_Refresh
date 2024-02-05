package in.saurabhkrtiwari;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class JPQLExample {
    public static void main(String[] args) {
        //getAllEmployees();
       // getAllEmployeesWithActiveAccessCard();
        getAllEmployeesPaymentsWithName();
    }

    private static void getAllEmployeesPaymentsWithName() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager =entityManagerFactory.createEntityManager();

        TypedQuery<Object[]> employeeTypedQuery = entityManager.createQuery("select e.id,e.payStubs from Employee e",Object[].class);
        List<Object[]> resultList = employeeTypedQuery.getResultList();
        resultList.forEach(s-> System.out.println(s[0]+"---"+s[1]));

        entityManager.close();
        entityManagerFactory.close();
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
