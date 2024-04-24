package backend.project.cookingapp.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import backend.project.cookingapp.domain.CuisineRepository;
import backend.project.cookingapp.domain.DifficultyRepository;
import backend.project.cookingapp.domain.Recipe;
import backend.project.cookingapp.domain.RecipeRepository;





@Controller
public class RecipeController {

@Autowired
private RecipeRepository repository;

@Autowired
private CuisineRepository drepository;


@Autowired
private DifficultyRepository frepository;



@GetMapping("recipelist")
public String recipelist(Model model) {
    model.addAttribute("recipe", repository.findAll());

    return "recipelist";
}

@GetMapping(value="/recipe")
    public @ResponseBody List<Recipe> RecipeListRest() {	
        return (List<Recipe>) repository.findAll();
    }    

    @RequestMapping(value="/recipe/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Recipe> findRecipeRest(@PathVariable("id") Long recipeId) {	
    	return repository.findById(recipeId);
    } 

@RequestMapping(value="/add")
public String addRecipe(Model model) {
    model.addAttribute("recipe", new Recipe());
    model.addAttribute("cuisine", drepository.findAll());
    model.addAttribute("difficulty", frepository.findAll());
    return "add"; 
}

@RequestMapping(value="/save", method=RequestMethod.POST)
public String save(Recipe recipe) {
   repository.save(recipe);
   System.out.println(recipe);
   return "redirect:/recipelist";
}

@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
//@PreAuthorize("hasAuthority('ADMIN')")
public String deleteRecipe(@PathVariable("id") Long recipeId, Model model) {
    repository.deleteById(recipeId);
    return "redirect:../recipelist";
}

@RequestMapping(value="/edit/{id}")
public String showModRec(@PathVariable("id") Long recipeId, Model model) {
    model.addAttribute("recipe", repository.findById(recipeId));
    model.addAttribute("cuisine", drepository.findAll());
    model.addAttribute("difficulty", frepository.findAll());
    return "edit";
}


@RequestMapping(value="/login")
public String login() {	
    return "login";
}	

@GetMapping("/logout")
public String logout() {
    return "redirect:/login?logout"; 
}

}
