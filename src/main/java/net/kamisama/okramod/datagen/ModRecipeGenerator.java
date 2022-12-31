package net.kamisama.okramod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.kamisama.okramod.Item.ModItems;
import net.minecraft.data.server.RecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.CookingRecipeSerializer;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {
        //example generator: Remove this later
        offerReversibleCompactingRecipes(exporter, ModItems.OKRA_SEEDS, ModItems.OKRA);

        // veggie knife recipe
        ShapedRecipeJsonBuilder.create(ModItems.VEGGIE_KNIFE).pattern("# ").pattern("$ ").input('#',
                Items.IRON_INGOT).input('$', Items.STICK).criterion(RecipeProvider.hasItem(Items.IRON_INGOT),
                RecipeProvider.conditionsFromItem(Items.IRON_INGOT)).criterion(RecipeProvider.hasItem(Items.STICK),
                RecipeProvider.conditionsFromItem(Items.STICK)).offerTo(exporter,
                new Identifier(RecipeProvider.getRecipeName(ModItems.VEGGIE_KNIFE)));

        offerCookingRecipe(exporter, "campfire_cooking", CookingRecipeSerializer.CAMPFIRE_COOKING, 20 * 30,
                ModItems.SLICED_OKRA,
                ModItems.COOKED_OKRA, 0.1f);

        offerCookingRecipe(exporter, "smoking", CookingRecipeSerializer.SMOKING, 20 * 30, ModItems.SLICED_OKRA,
                ModItems.COOKED_OKRA, 0.1f);

        offerCookingRecipe(exporter, "furnace", CookingRecipeSerializer.SMELTING, 20 * 15, ModItems.SLICED_OKRA,
                ModItems.COOKED_OKRA, 0.1f);
    }
}
