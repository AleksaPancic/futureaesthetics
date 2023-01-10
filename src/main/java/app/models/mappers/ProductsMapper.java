package app.models.mappers;

import app.models.dto.CategoryDTO;
import app.models.dto.ProductDTO;
import app.models.entities.ProductEntity;

public class ProductsMapper {
    public static ProductEntity toProductsEntity(final ProductDTO productDTO)
    {
         ProductEntity productEntity = new ProductEntity();
         productEntity.setId(productDTO.getId());
         productEntity.setTitle(productDTO.getTitle());
         productEntity.setPrice(productDTO.getPrice());
         productEntity.setDescription(productDTO.getDescription());
         productEntity.setImage(productDTO.getImage());
         productEntity.setCategory(CategoryMapper.toEntity(productDTO.getCategory()));
         return productEntity;
    }
    public static ProductDTO toProductsDTO(final ProductEntity products)
    {
         ProductDTO productDTO = new ProductDTO();
         productDTO.setId(products.getId());
         productDTO.setTitle(products.getTitle());
         productDTO.setPrice(products.getPrice());
         productDTO.setImage(products.getImage());
         productDTO.setDescription(products.getDescription());
         productDTO.setCategory(CategoryMapper.toDTO(products.getCategory()));
        return productDTO;
    }
}


