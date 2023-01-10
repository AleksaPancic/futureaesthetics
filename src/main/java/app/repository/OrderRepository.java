package app.repository;

import app.models.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long>,
        PagingAndSortingRepository<Order, Long> {

/*
    @Query("SELECT i FROM order_item i WHERE i.orderId.orderId = :orderId")
    List<OrderItem> getItemsWithingOrder(@Param("orderId") Long orderId);

 */


}
