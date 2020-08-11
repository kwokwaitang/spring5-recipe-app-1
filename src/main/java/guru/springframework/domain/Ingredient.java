package guru.springframework.domain;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * An ingredient can be in one or more recipes
 */
@Entity
public class Ingredient {

    @Id /* Private key */
    @GeneratedValue(strategy = GenerationType.IDENTITY /* Leverage the underlying persistence framework to generate
    the ID */)
    private Long id;

    private String description;
    private BigDecimal amount;

    @ManyToOne /* No need to cascade here, you don't want to delete an ingredient used in multiple recipes */
    private Recipe recipe;

    /**
     * Ingredient is the owner and since the UnitOfMeasure is a look-up, there no operation to cascade down. So the
     * relationship define between Ingredient and UnitOfMeasure is unidirectional...
     */
    @OneToOne(fetch = FetchType.EAGER /* BTW, this is the default (as a UnitOfMeasure is a look-up table) but being
    explicit here... So the values are always loaded */)
    private UnitOfMeasure unitOfMeasure;

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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

}
