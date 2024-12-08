package lombard.microservice.view;

import java.util.Date;

public class Loan {
    private Long id;
    private Long clientId;
    private Long propertyId;
    private Date open;
    private Date close;
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
