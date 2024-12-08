package lombard.microservice.client;

import jakarta.persistence.*;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "client_id_gen", sequenceName = "client_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_id_gen")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone", unique = true, nullable = false)
    private String phone;

    @Column(name = "balance")
    private Float balance;

    public Client() { /* конструктор для сущности */ }

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
