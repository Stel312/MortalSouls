package online.mortalsouls.mortalsouls.datagen.init;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.RecipeProvider;

public class Recipes extends RecipeProvider {

    private final DataGenerator dataGenerator;
    public Recipes(DataGenerator generatorIn) {
        super(generatorIn);
        this.dataGenerator = generatorIn;
    }
}
