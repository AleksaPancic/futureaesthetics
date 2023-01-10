package app.service.impl;

import app.exceptions.ItemNotFoundException;
import app.exceptions.OrderNotFoundException;
import app.models.entities.Order;
import app.models.entities.OrderItem;
import app.repository.ItemRepository;
import app.repository.OrderRepository;
import app.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslJpaRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    @Autowired
    private final ItemRepository orderItemRepository;

    @Autowired
    private final OrderRepository orderRepository;

    public Order findOrder(Long id) throws OrderNotFoundException {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }

    public List<Order> findAllOrders()
    {
        return orderRepository.findAll();
    }
    public OrderItem findOrderItem(Long id) throws ItemNotFoundException {
        return orderItemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    public Order ifNullSetString(Order order)
    {
        if(order.getTotal() == null)
        {
            order.setTotal(BigDecimal.ZERO);
        }

        return order;

        //order.setCity(order.getCity() == null ? "" : order.getCity()); TERNARY OPERATOR
        //order.setCity(Objects.requireNonNull(order.getCity(), ""));
    }

    @Override //returns a single item quantity
    public Long getItemQuantity(Long id) throws ItemNotFoundException {
        return findOrderItem(id).getQuantity();
    }

    @Override //returns a price of a single item - product price
    public BigDecimal getSingleItemPrice(Long id) throws ItemNotFoundException {
        findOrderItem(id);
        return orderItemRepository.getSingleItemPrice(id);
    }

    @Override //returns a single item price multiplied by its quantity
    public BigDecimal getItemSum(Long id) throws ItemNotFoundException {
          BigDecimal price = getSingleItemPrice(id);
          Long quantity = getItemQuantity(id);
          BigDecimal sum = price.multiply(BigDecimal.valueOf(quantity));
          return sum;
    }

    @Override //returns all items within a particular order
    public List<OrderItem> getItemsWithinOrder(Long orderId) throws OrderNotFoundException {
        return findOrder(orderId).getOrderedItems(orderId);
    }

    @Override //uses all items within a particular order, iterates through them,
              // takes their itemTotals and sums them up into orderTotal
    public BigDecimal getOrderTotal(Long orderId) throws OrderNotFoundException, ItemNotFoundException {
        List<OrderItem> items = getItemsWithinOrder(orderId);

        BigDecimal total = BigDecimal.ZERO; //initial value
        int count = 0;

        if (items.isEmpty()) {
            return BigDecimal.ZERO;
        }

        for (OrderItem item : items) {
                total = total.add(getItemSum(item.getId()));
                count++;
        }
        return total;
    }

    @Override //create order with one item inside
    public Order createOrder(Order newOrder, OrderItem newOrderItem) throws OrderNotFoundException, ItemNotFoundException {
        //save without total
        Order savedOrder = orderRepository.save(newOrder);

        //create orderItem and put it into a List
        OrderItem item = orderItemRepository.save(newOrderItem);
        List<OrderItem> firstItem = List.of(item);

        //set a newly created orderItem inside a list in new order
        savedOrder.setOrderedItems(firstItem);

        //calculate total of savedOrder and set it
        savedOrder.setTotal(item.getSum());

        //save it and return
        return orderRepository.save(savedOrder);
    }

    @Override //part of order
    public Order updateOrder(OrderItem newOrderItem, Long orderId) throws OrderNotFoundException, ItemNotFoundException {
        //find desired order you want to update
        Order orderForUpdate = findOrder(orderId);

        //create a new orderItem and save it
        OrderItem newItem = orderItemRepository.save(newOrderItem);

        //put it into a list for an Order object and set it
        List<OrderItem> previousItems = orderForUpdate.getOrderedItems(orderForUpdate.getOrderId());

         //add another item into a an order
        previousItems.add(newItem);
        orderForUpdate.setTotal(orderForUpdate.getTotal().add(newItem.getSum()));
        return orderForUpdate;
    }

}