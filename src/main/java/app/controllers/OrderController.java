package app.controllers;


import app.exceptions.ItemNotFoundException;
import app.exceptions.OrderNotFoundException;
import app.models.dto.Cart;
import app.models.dto.UserInfo;
import app.models.entities.Order;
import app.models.entities.OrderItem;
import app.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    @Autowired
    private final OrderService orderService;

    @GetMapping("/{orderId}")
    public Order getOrderById(@PathVariable final Long orderId) throws OrderNotFoundException
    {
        return orderService.findOrder(orderId);
    }
    @GetMapping(" ")
    public List<Order> getOrders()
    {
        return orderService.findAllOrders();
    }

    @GetMapping("/get-item-quantity/{id}")
    public Long getOrderItemQuantity(@PathVariable final Long id) throws ItemNotFoundException
    {
            return orderService.getItemQuantity(id);
    }
    @GetMapping("/get-single-item-price/{orderItemId}")
    public BigDecimal getOrderItemPrice(@PathVariable final Long orderItemId) throws ItemNotFoundException
    {
            return orderService.getSingleItemPrice(orderItemId);
    }
    @GetMapping("/get-item-total/{id}")
    public BigDecimal getItemSum(@PathVariable final Long id) throws ItemNotFoundException
    {
        return orderService.getItemSum(id);
    }
    @PostMapping("/get-items-of-same-order/{id}")
    public List<OrderItem> getItemsOfSameOrder(@PathVariable final Long id) throws OrderNotFoundException
    {
        return orderService.getItemsWithinOrder(id);
    }


    @PostMapping("/post")
    public Order createOrder(@RequestBody final UserInfo userInfo, @RequestBody final Cart cart) throws OrderNotFoundException, ItemNotFoundException
    {
        orderService.sendOrderEmail(userInfo, cart);
    }

    @PostMapping("/update/{id}")
    public Order updateOrder(@RequestBody final OrderItem newOrderItem, @PathVariable final Long orderId) throws OrderNotFoundException, ItemNotFoundException {
        return orderService.updateOrder(newOrderItem, orderId);
    }

    @GetMapping("/get-total-sum/{orderId}")
    public BigDecimal getOrderTotalSum(@PathVariable final Long orderId) throws OrderNotFoundException, ItemNotFoundException
    {
        return orderService.getOrderTotal(orderId);
    }
}
