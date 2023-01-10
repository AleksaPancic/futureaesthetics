package app.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Entity(name = "order_item")
@Table(name = "order_item")
@NoArgsConstructor

public class OrderItem { //POJEDINACNO ZA SVAKI PRODUKT
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne()
    @JoinColumn(name = "orderId")
    private Order order;
    @OneToOne() //when JPA sees this, it evaluates it and 'pastes' all the info about a particular product
    @JoinColumn(name = "product")
    private ProductEntity product;
    @Column(nullable = false) //at least one product per order_item
    private Long quantity;
    @Column()  // price * quantity
    private BigDecimal sum;

    public OrderItem(Long id,
                     Order orderId,
                     ProductEntity product,
                     Long quantity,
                     BigDecimal sum
    ) {
        this.id = id;
        this.order = orderId;
        this.product = product;
        this.quantity = quantity;
        this.sum = sum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Long getQuantity() {
        return quantity;
    }
    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }
    public BigDecimal getSum() {
        return sum;
    }

    public void setSum() {
        this.sum = sum;
    }
}
