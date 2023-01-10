package app.service;

import app.exceptions.ItemNotFoundException;
import app.exceptions.OrderNotFoundException;
import app.models.dto.Cart;
import app.models.dto.UserInfo;
import app.models.entities.Order;
import app.models.entities.OrderItem;
import java.math.BigDecimal;
import java.util.List;

public interface OrderService {

    // vezano za item iz order
    OrderItem findOrderItem(Long id) throws ItemNotFoundException;
    Long getItemQuantity(Long id) throws ItemNotFoundException;
    BigDecimal getSingleItemPrice(Long id) throws ItemNotFoundException;
    BigDecimal getItemSum(Long id) throws ItemNotFoundException;

    //vezano za ceo order
    Order findOrder(Long id) throws OrderNotFoundException;
    List<Order> findAllOrders();
    List<OrderItem> getItemsWithinOrder(Long orderId) throws OrderNotFoundException;
    BigDecimal getOrderTotal(Long orderId) throws OrderNotFoundException, ItemNotFoundException;
    void sendOrderEmail(UserInfo userInfo, Cart cart);
    Order updateOrder(OrderItem newOrderItem, Long orderId) throws OrderNotFoundException, ItemNotFoundException;


}
