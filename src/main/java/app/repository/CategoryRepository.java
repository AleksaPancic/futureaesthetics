
package app.repository;

import app.models.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>,
        PagingAndSortingRepository<CategoryEntity, Long> {

    @Query("SELECT name from category") //NAME from entity, not base
    List<String> getCategoryNames();

    @Query("SELECT id, name from category") //NAME from entity, not base
    List<CategoryEntity> getCategories();



}

