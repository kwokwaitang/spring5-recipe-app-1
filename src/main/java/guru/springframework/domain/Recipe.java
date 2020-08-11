package guru.springframework.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Recipe {

    @Id /* Private key */
    @GeneratedValue(strategy = GenerationType.IDENTITY /* Leverage the underlying persistence framework to generate
    the ID */)
    private Long id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;

    @Lob /* Set-up as a Large object i.e. it becomes a BLOB */
    private Byte[] image;

    private Difficulty difficulty;

    /**
     * One-to-one with Notes, so Recipe will own Notes so any operations here regarding the Notes will be cascaded down
     */
    @OneToOne(cascade = CascadeType.ALL)
    private Notes recipeNotes;

    /**
     * There will be one or more ingredients and the Recipe will be the owner, hence any operations will be cascaded
     * down
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe" /* Establishes the relationship between Recipe & the
    Ingredients */)
    private Set<Ingredient> ingredients;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

    public Integer getCookTime() {
        return cookTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public Integer getServings() {
        return servings;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Notes getRecipeNotes() {
        return recipeNotes;
    }

    public void setRecipeNotes(Notes recipeNotes) {
        this.recipeNotes = recipeNotes;
    }

}
