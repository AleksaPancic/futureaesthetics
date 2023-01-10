package app.models.entities;

import app.models.dto.CategoryDTO;
import app.serializers.CategorySerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.*;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity(name = "product")
@Table(name = "products") //db table name
@NoArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //database is responsible for assigning the next primary key
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column()
    private String description;
    @Column()
    private String image;
    @Column(nullable = false)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "category")
    private CategoryEntity category;

    private String categoryName;

    public ProductEntity(Long id,
                         String title,
                         String description,
                         BigDecimal price,
                         String image,
                         CategoryEntity category
    )
    {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.image = image;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }



//    public Map<String, Object> getFields(List<String> fields) throws IllegalAccessException {
//        Map<String, Object> map = new HashMap<>();
//        for (Field field : getClass().getDeclaredFields()) {
//
//            field.setAccessible(true);
//            if (fields.contains(field.getName()))
//            {
//                map.put(field.getName(), field.get(this));
//            }
//        }
//        return map;
//    }
//
//    public String toProductJson(List<String> fields) throws IllegalAccessException, JsonProcessingException{
//        ObjectMapper mapper = new ObjectMapper();
//        return mapper.writeValueAsString(getFields(fields));
//    }


    }



