package app.repository;

import app.models.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface ItemRepository extends JpaRepository<OrderItem, Long>,
        PagingAndSortingRepository<OrderItem, Long> {

    @Query("SELECT i.product.price FROM order_item i WHERE i.id = :id")
    BigDecimal getSingleItemPrice(@Param("id") Long id);

}
