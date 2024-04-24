package backend.project.cookingapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import backend.project.cookingapp.domain.Cuisine;
import backend.project.cookingapp.domain.CuisineRepository;
import backend.project.cookingapp.domain.Difficulty;
import backend.project.cookingapp.domain.DifficultyRepository;
import backend.project.cookingapp.domain.Recipe;
import backend.project.cookingapp.domain.RecipeRepository;
import backend.project.cookingapp.domain.UserRepository;
import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class CookingappApplication {
	private static final Logger log = (Logger) LoggerFactory.getLogger(CookingappApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CookingappApplication.class, args);
	}



	@Bean
	public CommandLineRunner cookingapp(RecipeRepository repository, CuisineRepository drepository, DifficultyRepository frepository, UserRepository urepository){

		return (args) -> {

			log.info("save a couple of recepies");


			drepository.save(new Cuisine("Mexican"));
			drepository.save(new Cuisine("Italian"));
			drepository.save(new Cuisine("Japanese"));
			drepository.save(new Cuisine("Chinese"));
			drepository.save(new Cuisine("Other"));

			frepository.save(new Difficulty("Easy"));
			frepository.save(new Difficulty("Medium"));
			frepository.save(new Difficulty("Hard"));

			

				

			repository.save(new Recipe("Mabo Tofu", 60, "instructions", drepository.findByType("Chinese").get(0), frepository.findByLevel("Medium").get(0)));
			repository.save(new Recipe("Karaage", 45, "instructions", drepository.findByType("Japanese").get(0), frepository.findByLevel("Easy").get(0)));
			repository.save(new Recipe("Carnitas", 120, "instructions", drepository.findByType("Mexican").get(0), frepository.findByLevel("Easy").get(0)));


			log.info("fetch all Recipes");
			for(Recipe recipes : repository.findAll()){
				log.info(recipes.toString());
			}
			
		};
		
	}
	
}
