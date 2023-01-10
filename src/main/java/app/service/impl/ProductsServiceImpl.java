package app.service.impl;

import app.exceptions.ProductNotFoundException;
import app.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import app.models.entities.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.repository.ProductsRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductsServiceImpl implements ProductService {
    @Autowired
    private final ProductsRepository productsRepository;

//    private String toWantedProductJSON(ProductEntity product) throws JsonProcessingException, IllegalAccessException
//    {
//
//        List<String> fields = List.of("title", "description", "image", "price");
//        String json = product.toProductJson(fields);
//        return json;
//    }

    @Override
    public ProductEntity findById(Long id) throws ProductNotFoundException
    {
        return productsRepository.findById(id)
                .orElseThrow(()-> new ProductNotFoundException(id));
    }
    @Override
    public List<ProductEntity> getAllProducts()
    {
        return productsRepository.findAll();
    }

    public List<String> getProductsTitles()
    {
        return productsRepository.getProductsTitles();
    }
    @Override
    public void deleteProduct(Long id) {
        productsRepository.deleteById(id);
    }

    @Override
    public ProductEntity saveProduct(ProductEntity newEntity) {
        return productsRepository.save(newEntity);
    }

    @Override
    public ProductEntity ifNullSetString(ProductEntity product) {
        if(product.getTitle() == null)
        {
            product.setTitle("");
        }

        if(product.getDescription() == null)
        {
            product.setDescription("");
        }
        if(product.getImage() == null)
        {
            product.setImage("");
        }


        return product;
    }

    @Override
    public List<String> getCategories() {
        return productsRepository.getCategories();
    }
    @Override
    public String getProductCategoryById(Long id) {
        return productsRepository.getProductCategoryById(id);
    }

    @Override
    public String getProductCategoryByTitle(String title) {
        return productsRepository.getProductCategoryByTitle(title);
    }

}

