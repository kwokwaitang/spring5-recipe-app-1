package guru.springframework.domain;

import javax.persistence.*;

/**
 * Just a look-up table detail various units of measure
 */
@Entity
public class UnitOfMeasure {

    @Id /* Private key */
    @GeneratedValue(strategy = GenerationType.IDENTITY /* Leverage the underlying persistence framework to generate
    the ID */)
    private Long id;

    private String description;

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

}
