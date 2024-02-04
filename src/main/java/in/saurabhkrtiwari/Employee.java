package in.saurabhkrtiwari;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "EMPLOYEE_DATA")
public class Employee {

    @Id
    private int id;

    @Column(name = "employee_name")
    private String name;

    private int age;

    @Column(name = "ssn",unique = true,nullable = false)
    private String ssn;

    @Temporal(TemporalType.DATE)
    private java.util.Date dob;

    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date updateTime;

    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;

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
}
