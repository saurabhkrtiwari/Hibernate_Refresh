package in.saurabhkrtiwari;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "EMPLOYEE_DATA")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "employee_name")
    private String name;

    private int age;

    @Column(name = "ssn", unique = true, nullable = false)
    private String ssn;

    @Temporal(TemporalType.DATE)
    private java.util.Date dob;

    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date updateTime;

    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ACCESS_CARD_ID")
    private AccessCard accessCard;

    @OneToMany(mappedBy = "employee",fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    private List<PayStub> payStubs;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "DEPARTMENT_EMPLOYEE_MAPPING",joinColumns = @JoinColumn(name = "EMP_ID"),inverseJoinColumns = @JoinColumn(name = "DEP_ID"))
    private List<Department> departments = new ArrayList<>();

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<PayStub> getPayStubs() {
        return payStubs;
    }

    public void setPayStubs(List<PayStub> payStubs) {
        this.payStubs = payStubs;
    }

    public AccessCard getAccessCard() {
        return accessCard;
    }

    public void setAccessCard(AccessCard accessCard) {
        this.accessCard = accessCard;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", ssn='" + ssn + '\'' +
                ", dob=" + dob +
                ", updateTime=" + updateTime +
                ", employeeType=" + employeeType +
                ", accessCard=" + accessCard +
                ", payStubs=" + payStubs +
                ", departments=" + departments +
                '}';
    }
}
