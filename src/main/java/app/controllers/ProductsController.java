package app.controllers;

import app.exceptions.ProductNotFoundException;
import app.models.dto.ProductDTO;
import app.models.mappers.ProductsMapper;
import app.service.ProductService;
import lombok.RequiredArgsConstructor;
import app.models.entities.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductsController {

    //private final ProductsServiceImpl productsService;
    //it's a good practice to use an instance of an interface rather than interface implementation
    @Autowired
    private final ProductService productService;

//    public ProductDTO specialJSON(final Long id) throws ProductNotFoundException{
//        ProductEntity product = productService.findById(id);
//        productService.ifNullSetString(product);
//
//        return
//    }



    @GetMapping("/{id}")
    public ProductDTO findMeProduct(@PathVariable final Long id) throws ProductNotFoundException
    {
        ProductEntity product = productService.findById(id);
        productService.ifNullSetString(product);
        return ProductsMapper.toProductsDTO(product);
    }

    @PostMapping("/get-by/{id}")
    public ProductEntity findProduct(@PathVariable final Long id) throws ProductNotFoundException
    {
        ProductEntity product = productService.findById(id);
        productService.ifNullSetString(product);
        return product;
    }

    @GetMapping(" ")
    public List<ProductDTO> getMeAllProducts()
    {
        return productService.getAllProducts().stream()
                .map(productService::ifNullSetString)
                .map(ProductsMapper::toProductsDTO)
                .toList(); //IMMUTABLE
        //.collect(Collectors.toList()) FOR MUTABLE
    }
    @PostMapping(" ")
    public List<ProductEntity> getAllProducts()
    {
        return productService.getAllProducts().stream()
                .map(productService::ifNullSetString)
                .toList(); //IMMUTABLE
        //.collect(Collectors.toList()) FOR MUTABLE
    }

    //ZA GET DTO, TVOJ GET JE NJEGOV POST
    @GetMapping("/get-created-product")
    public ProductDTO getCreatedProduct(final ProductEntity productEntity)
    {
        return ProductsMapper.toProductsDTO(productService.saveProduct(productEntity));
    }
    //ZA POST ENTITY, TVOJ POST JE NJEMU GET
    @PostMapping("/post")
    public ProductEntity createProduct(@RequestBody final ProductDTO productDTO)
    {
        final ProductEntity product = ProductsMapper.toProductsEntity(productDTO);
        return productService.saveProduct(product);
    }

    @GetMapping("/get-categories")
    public List<String> getCategories()
    {
        return productService.getCategories();
    }

    @GetMapping("/get-category-by-id/{id}")
    public String getProductCategoryByProductId(@PathVariable final Long id)
    {
        return productService.getProductCategoryById(id);
    }

    @GetMapping("/get-category-by-title/{title}")
    public String getProductCategoryByProductTitle(@PathVariable final String title)
    {
        return productService.getProductCategoryByTitle(title);
    }

    /*
    @PostMapping("product-title/{id}")
    public String getProductCategoryByTitle(@PathVariable Long id)
    {
        return productService.getProductCategoryByTitle(id);
    }
    */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProductById(@PathVariable final Long id) {
        productService.deleteProduct(id);
    }
}



