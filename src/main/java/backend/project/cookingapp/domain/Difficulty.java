package backend.project.cookingapp.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="DIFFICULTLY")
public class Difficulty {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long difficultyId;
private String level;

@OneToMany(cascade = CascadeType.ALL, mappedBy = "difficulty")
private List<Recipe> recipes;

    public Difficulty(){

    }

    public Difficulty(String level){
        super();
        this.level=level;
    }

    public Long getDifficultyId() {
        return difficultyId;
    }

    public void setDifficultyId(Long difficultyId) {
        this.difficultyId = difficultyId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Difficulty [difficultyId=" + difficultyId + ", level=" + level + "]";
    }


    
}
