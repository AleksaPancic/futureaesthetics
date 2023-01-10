
package app.models.mappers;

import app.models.dto.CategoryDTO;
import app.models.entities.CategoryEntity;


public class CategoryMapper {
    public static CategoryDTO toDTO(CategoryEntity categoryEntity)
    {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(categoryEntity.getId());
        categoryDTO.setName(categoryEntity.getName());
        return categoryDTO;
    }

    public static CategoryEntity toEntity(CategoryDTO categoryDTO)
    {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(categoryDTO.getId());
        categoryEntity.setName(categoryDTO.getName());
        return  categoryEntity;
    }

}






