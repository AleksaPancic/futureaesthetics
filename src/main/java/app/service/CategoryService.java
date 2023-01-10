
package app.service;

import app.models.entities.CategoryEntity;
import java.util.List;

public interface CategoryService {
    List<String> getCategoryNames();
    List<CategoryEntity> getCategories();
    Boolean isCategoryPresent(String name);
    CategoryEntity getCategoryWithName(Long id);

}


