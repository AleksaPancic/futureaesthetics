
package app.models.entities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Data
@Entity(name = "category")
@Table(name = "categories") //db table name
@NoArgsConstructor
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "category")
    List<ProductEntity> products;

    public CategoryEntity(
                            Long id,
                            String name
    )
    {
        this.id = id;
        this.name = name;
    }

//    public Map<String, Object> getFields(List<String> fields) throws IllegalAccessException {
//        Map<String, Object> map = new HashMap<>();
//        for (Field field : getClass().getDeclaredFields()) {
//
//            field.setAccessible(true);
//            if (fields.contains(field.getName()))
//            {
//                    map.put(field.getName(), field.get(this));
//            }
//        }
//        return map;
//    }
//
//    public String toCategoryJson(List<String> fields) throws IllegalAccessException, JsonProcessingException {
//        ObjectMapper mapper = new ObjectMapper();
//        return mapper.writeValueAsString(getFields(fields));
//    }

}

