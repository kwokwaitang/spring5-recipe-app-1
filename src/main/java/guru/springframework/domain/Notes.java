package guru.springframework.domain;

import javax.persistence.*;

@Entity
public class Notes {

    @Id /* Private key */
    @GeneratedValue(strategy = GenerationType.IDENTITY /* Leverage the underlying persistence framework to generate
    the ID */)
    private Long id;

    @OneToOne /* No need to specify a cascade operation as Recipe will own this notes */
    private Recipe recipe;

    @Lob /* Set-up as a Large object i.e. it becomes a CLOB for text > 255 characters??? */
    private String recipeNotes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public String getRecipeNotes() {
        return recipeNotes;
    }

    public void setRecipeNotes(String recipeNotes) {
        this.recipeNotes = recipeNotes;
    }

}
