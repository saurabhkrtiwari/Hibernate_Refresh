package in.saurabhkrtiwari;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "PAYMENT_DTL")
public class PayStub {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date payStartDate;
    private Date payEndDate;

    private float salary;

    @ManyToOne
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getPayStartDate() {
        return payStartDate;
    }

    public void setPayStartDate(Date payStartDate) {
        this.payStartDate = payStartDate;
    }

    public Date getPayEndDate() {
        return payEndDate;
    }

    public void setPayEndDate(Date payEndDate) {
        this.payEndDate = payEndDate;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public PayStub(Date payStartDate, Date payEndDate, float salary, Employee employee) {
        this.payStartDate = payStartDate;
        this.payEndDate = payEndDate;
        this.salary = salary;
        this.employee = employee;
    }

    public PayStub(Date payStartDate, Date payEndDate, float salary) {
        this.payStartDate = payStartDate;
        this.payEndDate = payEndDate;
        this.salary = salary;
    }

    public PayStub() {
    }

    @Override
    public String toString() {
        return "payslips{" +
                "id=" + id +
                ", payStartDate=" + payStartDate +
                ", payEndDate=" + payEndDate +
                ", salary=" + salary +
                ", employee=" +employee.getName() +
                '}';
    }
}
