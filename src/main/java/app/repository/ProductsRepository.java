package app.repository;

import app.models.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<ProductEntity, Long>,
        PagingAndSortingRepository<ProductEntity, Long> {
    @Query("SELECT title FROM product")
    List<String> getProductsTitles();
    @Query("SELECT category FROM product")
    List<String> getCategories();
    @Query("SELECT p.category FROM product p WHERE p.id = :id")
    String getProductCategoryById(@Param("id") Long id);
    @Query("SELECT p.category FROM product p WHERE p.title = :title")
    String getProductCategoryByTitle(@Param("title") String title);
    @Query("SELECT p.price FROM product p WHERE p.id = :id")
    BigDecimal getProductPriceById(Long id);
    @Query("SELECT p.price FROM product p WHERE p.title = :title")
    BigDecimal getProductPriceByTitle(String title);
/*
    @Query("SELECT category FROM product WHERE id = ?id")
    String getProductCategoryByTitle(Long id);

 */




/*
    @Repository
    @Transactional(readOnly = true)
    public interface UsersRepository extends JpaRepository<Users, Long>, PagingAndSortingRepository<Users, Long> {
	Users findByUsername(String username);

	@Query("select u from Users u where (upper(u.firstName) like concat('%', upper(:name),'%')) or (upper(u.lastName) " +
            "like concat('%', upper(:name),'%'))")
	Page<Users> findAllByBothName(String name, Pageable page);

	@Query("select count(u) from Users u where (upper(u.firstName) like concat('%', upper(:name),'%')) or (upper(u.lastName) " +
            "like concat('%', upper(:name),'%'))")
	int findAllByBothNameCount(String name);

	List<Users> findAllByFirstName(String firstName, Pageable paging);

     */
}


