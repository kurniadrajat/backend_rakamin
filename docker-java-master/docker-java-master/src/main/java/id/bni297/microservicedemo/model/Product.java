package id.bni297.microservicedemo.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")

    private Double price;

    public Product(){}

    public Product(Long id, String name, Double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ",name='" + name +'\'' +
                ",price='" + price +
                "}";
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return  true;
        if(!(obj instanceof Product)) return false;
        Product product = (Product)obj;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) &&
                Objects.equals(price, product.price);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }
}
