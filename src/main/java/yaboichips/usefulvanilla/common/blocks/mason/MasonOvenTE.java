package yaboichips.usefulvanilla.common.blocks.mason;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import yaboichips.usefulvanilla.core.UVRecipeTypes;
import yaboichips.usefulvanilla.core.UVTileEntities;

public class MasonOvenTE extends AbstractFurnaceBlockEntity {
    public MasonOvenTE(BlockPos pos, BlockState state) {
        super(UVTileEntities.MASON_OVEN, pos, state, UVRecipeTypes.MASON);
    }

    @Override
    protected Component getDefaultName() {
        return new TranslatableComponent("container.mason_oven");
    }

    protected int getBurnDuration(@NotNull final ItemStack stack) {
        return super.getBurnDuration(stack) / 2;
    }

    @Override
    protected @NotNull AbstractContainerMenu createMenu(int slot, @NotNull Inventory inv) {
        return new MasonMenu(slot, inv, this, this.dataAccess);
    }
}
