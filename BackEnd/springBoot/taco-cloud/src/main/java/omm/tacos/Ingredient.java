package omm.tacos;


//public record Ingredient(String id, String name, omm.tacos.Ingredient.Type type) {
//    public enum Type {
//        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
//    }
//}

//the above code equals to  the bellow code , which we use record version.

import lombok.Data;

@Data
 public class Ingredient {
    private final String id;
    private final String name;
    private final Type ingredientType;

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}


