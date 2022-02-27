package yaboichips.usefulvanilla.core;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import yaboichips.usefulvanilla.UsefulVanilla;
import yaboichips.usefulvanilla.common.MasonRecipe;

import java.util.Optional;

public class UVRecipeTypes {
    public static final RecipeType<MasonRecipe> MASON = new RecipeType<MasonRecipe>() {
        @Override
        public <C extends Container> Optional<MasonRecipe> tryMatch(Recipe<C> recipe, Level worldIn, C inv) {
            return recipe.matches(inv, worldIn) ? Optional.of((MasonRecipe) recipe) : Optional.empty();
        }
    };

    static {
        Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(UsefulVanilla.MOD_ID, "mason"), MASON);
    }
}
