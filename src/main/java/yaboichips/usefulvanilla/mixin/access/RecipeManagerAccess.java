package yaboichips.usefulvanilla.mixin.access;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.Map;

@Mixin(RecipeManager.class)
public interface RecipeManagerAccess {
    @Invoker("byType")
    <E extends Container, T extends Recipe<E>> Map<ResourceLocation, Recipe<E>> getUVRecipes(RecipeType<T> type);
}
