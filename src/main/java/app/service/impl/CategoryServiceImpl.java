
package app.service.impl;

import app.models.entities.CategoryEntity;
import app.models.entities.ProductEntity;
import app.repository.CategoryRepository;
import app.service.CategoryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    public CategoryServiceImpl(CategoryRepository categoryRepository)
    {
        this.categoryRepository = categoryRepository;
    }

//    public String toWantedCategoryJSON(CategoryEntity category) throws JsonProcessingException, IllegalAccessException
//    {
//        List<String> fields = List.of("name");
//        String json = category.toCategoryJson(fields);
//        return json;
//    }
    public List<String> getCategoryNames()
    {
        return categoryRepository.getCategoryNames();
    }

    public List<CategoryEntity> getCategories() {
        return categoryRepository.getCategories();
    }
    public Boolean isCategoryPresent(String name) { //vrati mi ako postoji kategorija poy
        return getCategories().stream()
                       .anyMatch(category-> category.getName().equals(name)); //da li postoji neka kategorija sa ovim imenom
    }

    public CategoryEntity getCategoryWithName(Long id) {
        return categoryRepository.getReferenceById(id);
    }
}



        /*
        for(int i = 0; i < getCategories().size(); i++) {
            if(getCategories().get(i).getId().equals(id)) {
                return getCategories().get(i);
            }
        }
        return  null;

         */
