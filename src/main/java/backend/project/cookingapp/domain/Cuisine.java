package backend.project.cookingapp.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="CUISINE")
public class Cuisine {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cuisineId;
    private String type;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuisine")
    private List<Recipe> recipes;

    public Cuisine(){}


    public Cuisine(String type) {
        super();
        this.type = type;
    }


    public Long getCuisineId() {
        return cuisineId;
    }


    public void setCuisineId(Long cuisineId) {
        this.cuisineId = cuisineId;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "Cuisine [cuisineId=" + cuisineId + ", type=" + type + "]";
    }

    


    

}
