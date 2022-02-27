package yaboichips.usefulvanilla.core;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCookingSerializer;
import net.minecraftforge.registries.ForgeRegistries;
import yaboichips.usefulvanilla.common.MasonRecipe;
import yaboichips.usefulvanilla.util.UVRegistrar;

public class UVRecipeSerializers {

    public static final UVRegistrar<RecipeSerializer<?>> REGISTRAR = new UVRegistrar<>(ForgeRegistries.RECIPE_SERIALIZERS);

    public static final RecipeSerializer<MasonRecipe> MASON = REGISTRAR.add("building", new SimpleCookingSerializer<>(MasonRecipe::new, 100));

}
