
package app.models.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class CategoryDTO {

    Long id;
    String name;
    public CategoryDTO(Long id,
                       String name
    )
    {
        this.id = id;
        this.name = name;
    }
}


