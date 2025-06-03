package omm.tacos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.List;



@Data
public class Taco {

    private long id;
    private Date createdAt = new Date();
    @NotNull
    @Size(min = 5, message = "name must be at least 5 character.")
    String name;
    @NotNull
    @Size(min = 1, message = "must be select at least 1 ingredients.")
    List<Ingredient> ingredients;
}
