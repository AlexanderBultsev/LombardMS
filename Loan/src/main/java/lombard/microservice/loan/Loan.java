package lombard.microservice.loan;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "loans")
public class Loan {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "loan_id_gen", sequenceName = "loan_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loan_id_gen")
    private Long id;

    @Column(name = "client_id", nullable = false)
    private Long clientId;

    @Column(name = "property_id", nullable = false)
    private Long propertyId;

    @Column(name = "open")
    private Date open;

    @Column(name = "close")
    private Date close;

    @Column(name = "status")
    private String status;

    public Loan() {}

    public Long getId() {
        return id;
    }

    public Long getClientId() {
        return clientId;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public Date getOpen() {
        return open;
    }

    public Date getClose() {
        return close;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public void setOpen(Date open) {
        this.open = open;
    }

    public void setClose(Date close) {
        this.close = close;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

