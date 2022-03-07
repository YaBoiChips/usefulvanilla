package yaboichips.usefulvanilla.common.blocks.mason;

import net.minecraft.core.BlockPos;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import yaboichips.usefulvanilla.core.UVTileEntities;

public class MasonOven extends AbstractFurnaceBlock {
    public MasonOven(Properties properties) {
        super(properties);
    }

    @Override
    protected void openContainer(Level world, BlockPos pos, Player player) {
        BlockEntity blockentity = world.getBlockEntity(pos);
        if (blockentity instanceof MasonOvenTE) {
            player.openMenu((MenuProvider)blockentity);
        }
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new MasonOvenTE(pos, state);
    }

    @javax.annotation.Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return createFurnaceTicker(level, type, UVTileEntities.MASON_OVEN.get());
    }
}
