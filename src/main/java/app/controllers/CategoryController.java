
package app.controllers;

import app.models.dto.CategoryDTO;
import app.models.entities.CategoryEntity;
import app.models.mappers.CategoryMapper;
import app.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    @Autowired
    private final CategoryService categoryService;

    @GetMapping("-names")
    public List<String> getCategoryNames() {
        return categoryService.getCategoryNames();
    }

    @GetMapping("number/{id}")
    public CategoryDTO getCategoriesByName(@PathVariable final Long id) { //za get dto
        return CategoryMapper.toDTO(categoryService.getCategoryWithName(id));
    }

    @GetMapping("-present/{name}")
    public Boolean isCategoryPresent(@PathVariable final String name) {
        return categoryService.isCategoryPresent(name);
    }

    @PostMapping
    public List<CategoryEntity> sendCategories() { //entities za post
        return categoryService.getCategories();
    }
}

