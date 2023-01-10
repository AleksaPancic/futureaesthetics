package app.models.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

@Entity(name = "order")
@Table(name = "orders")
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    @OneToMany(mappedBy = "order") //in one order goes many ordered items
    private List<OrderItem> orderedItems;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false)
    private Long phone;
    @Column(nullable = false)
    private String mail;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String number;
    @Column(nullable = false)
    private String zip;
    @Column(nullable = false)
    private String street;
    @Column()
    private BigDecimal total;

    public Order(Long orderId,
                 String name,
                 String surname,
                 List<OrderItem> orderedItems,
                 String number,
                 String zip,
                 BigDecimal total
    ){
        this.orderId = orderId;
        this.name = name;
        this.surname = surname;
        this.orderedItems = orderedItems;
        this.number = number;
        this.zip = zip;
        this.total = total;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public List<OrderItem> getOrderedItems(Long id) {
        this.orderId = id;
        return orderedItems;
    }

    public void setOrderedItems(List<OrderItem> orderedItems) {
        this.orderedItems = orderedItems;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }


}
