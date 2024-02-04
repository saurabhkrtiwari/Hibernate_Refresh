package in.saurabhkrtiwari;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "ACCESS_CARD")
public class AccessCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Temporal(TemporalType.DATE)
    private Date issuedDate;


    private boolean isActive;

    @OneToOne(mappedBy = "accessCard")
    private Employee owner;

    public Employee getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "AccessCard{" +
                "id=" + id +
                ", issuedDate=" + issuedDate +
                ", isActive=" + isActive +
                ", owner=" + owner.getName() +
                ", firmwareVersion='" + firmwareVersion + '\'' +
                '}';
    }

    public void setOwner(Employee owner) {
        this.owner = owner;
    }

    @Column(length = 42)
    private String firmwareVersion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    public void setFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }
}
