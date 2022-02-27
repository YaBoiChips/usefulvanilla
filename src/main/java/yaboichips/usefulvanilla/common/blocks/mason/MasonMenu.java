package yaboichips.usefulvanilla.common.blocks.mason;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeBookType;
import yaboichips.usefulvanilla.core.UVMenus;
import yaboichips.usefulvanilla.core.UVRecipeTypes;

public class MasonMenu extends AbstractFurnaceMenu {
    public MasonMenu(int slot, Inventory inv) {
        super(UVMenus.MASON_OVEN, UVRecipeTypes.MASON, RecipeBookType.BLAST_FURNACE, slot, inv);
    }

    public MasonMenu(int slot, Inventory inv, Container container, ContainerData data) {
        super(UVMenus.MASON_OVEN, UVRecipeTypes.MASON, RecipeBookType.BLAST_FURNACE, slot, inv, container, data);
    }
}
