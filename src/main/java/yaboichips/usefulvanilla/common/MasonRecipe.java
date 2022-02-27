package yaboichips.usefulvanilla.common;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import yaboichips.usefulvanilla.core.UVBlocks;
import yaboichips.usefulvanilla.core.UVRecipeSerializers;
import yaboichips.usefulvanilla.core.UVRecipeTypes;

public class MasonRecipe extends AbstractCookingRecipe {
    public MasonRecipe(ResourceLocation location, String id, Ingredient ingredient, ItemStack result, float p_43797_, int p_43798_) {
        super(UVRecipeTypes.MASON, location, id, ingredient, result, p_43797_, p_43798_);
    }

    public ItemStack getToastSymbol() {
        return new ItemStack(UVBlocks.MASON_OVEN);
    }

    public RecipeSerializer<?> getSerializer() {
        return UVRecipeSerializers.MASON;
    }
}
