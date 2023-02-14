package online.mortalsouls.mortalsouls.datagen.init;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import online.mortalsouls.mortalsouls.item.ModItems;

import java.util.function.Consumer;

public class Recipes extends RecipeProvider {

    private final DataGenerator dataGenerator;
    public Recipes(DataGenerator generatorIn) {
        super(generatorIn);
        this.dataGenerator = generatorIn;
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
            super.buildCraftingRecipes(consumer);
        ShapedRecipeBuilder.shaped(ModItems.shieldDoorL.get()).define('I', Tags.Items.INGOTS_IRON)
                .define('S', Items.SHIELD).pattern("II").pattern("IS").pattern("II")
                .unlockedBy("shield", InventoryChangeTrigger.TriggerInstance.hasItems(Items.SHIELD.asItem()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(ModItems.shieldDoorR.get()).define('I', Tags.Items.INGOTS_IRON)
                .define('S', Items.SHIELD).pattern("II").pattern("SI").pattern("II")
                .unlockedBy("shield", InventoryChangeTrigger.TriggerInstance.hasItems(Items.SHIELD.asItem()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(ModItems.greathammer.get()).define('S', Items.STICK).define('G', Tags.Items.INGOTS_GOLD)
                .define('O', Tags.Items.OBSIDIAN).pattern(" GO").pattern(" SG").pattern("S  ")
                .unlockedBy("obsidian", InventoryChangeTrigger.TriggerInstance.hasItems(Items.OBSIDIAN.asItem()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(ModItems.wardenSword.get()).define('S', Items.IRON_SWORD).define('I', Tags.Items.INGOTS_IRON)
                .define('C', Items.COAL).pattern("  I").pattern(" C ").pattern("S  ")
                .unlockedBy("iron", InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_SWORD.asItem()))
                .save(consumer);
    }
}
