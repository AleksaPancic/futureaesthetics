package app.models.dto;

public class Cart {
    private final Integer id;
    private final Integer quantity;
//idk
    public Cart(Integer id, Integer quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
