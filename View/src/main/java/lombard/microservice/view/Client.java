package lombard.microservice.view;

public class Client {
    private Long id;
    private String name;
    private String phone;
    private Float balance;

    public Client() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public Float getBalance() {
        return balance;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }
}
