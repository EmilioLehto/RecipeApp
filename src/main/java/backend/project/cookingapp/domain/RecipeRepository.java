package backend.project.cookingapp.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
    List<Recipe> findByDish(String dish);
    
} 
