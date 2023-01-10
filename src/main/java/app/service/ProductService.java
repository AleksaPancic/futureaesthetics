package app.service;

import app.exceptions.ProductNotFoundException;
import app.models.entities.ProductEntity;
import java.util.List;

public interface ProductService {
    ProductEntity findById(Long id) throws ProductNotFoundException;
    List<ProductEntity> getAllProducts();
    void deleteProduct(Long id);
    ProductEntity saveProduct(ProductEntity newEntity);
    ProductEntity ifNullSetString(ProductEntity product);
    List<String> getCategories();
    String getProductCategoryById(Long id);
    String getProductCategoryByTitle(String title);

}
