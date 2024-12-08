package lombard.microservice.property;

import jakarta.persistence.*;

@Entity
@Table(name = "properties")
public class Property {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "property_id_gen", sequenceName = "property_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "property_id_gen")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price")
    private Float price;

    public Property() { /* конструктор для сущности */ }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Float getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}

