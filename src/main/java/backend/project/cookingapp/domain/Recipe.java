package backend.project.cookingapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="RECIPE")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long recipeId;
    private String dish;
    private int time;
    private String instructions;

    @ManyToOne
    @JoinColumn(name= "cuisineId")
    private Cuisine cuisine;

    @ManyToOne
    @JoinColumn(name="difficultyId")
    private Difficulty difficulty;

public Recipe(){

}

public Recipe(String dish, int time, String instructions, Cuisine cuisine, Difficulty difficulty) {
    this.dish = dish;
    this.time = time;
    this.instructions = instructions;
    this.cuisine=cuisine;
    this.difficulty=difficulty;
}



public String getDish() {
    return dish;
}

public void setDish(String dish) {
    this.dish = dish;
}

public int getTime() {
    return time;
}

public void setTime(int time) {
    this.time = time;
}

public String getInstructions() {
    return instructions;
}

public void setInstructions(String instructions) {
    this.instructions = instructions;
}

public Cuisine getCuisine() {
    return cuisine;
}

public void setCuisine(Cuisine cuisine) {
    this.cuisine = cuisine;
}

public Difficulty getDifficulty() {
    return difficulty;
}

public void setDifficulty(Difficulty difficulty) {
    this.difficulty = difficulty;
}


public Long getRecipeId() {
    return recipeId;
}

public void setRecipeId(Long recipeId) {
    this.recipeId = recipeId;
}

@Override
public String toString() {
    return "Recipe [recipeId=" + recipeId + ", dish=" + dish + ", time=" + time + ", instructions=" + instructions
            + ", cuisine=" + cuisine + ", difficulty=" + difficulty + "]";
}


}