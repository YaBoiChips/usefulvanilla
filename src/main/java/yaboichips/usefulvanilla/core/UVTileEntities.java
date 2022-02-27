package yaboichips.usefulvanilla.core;

import com.mojang.datafixers.types.Type;
import net.minecraft.Util;
import net.minecraft.util.datafix.fixes.References;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.ForgeRegistries;
import yaboichips.usefulvanilla.common.te.CopperHopperTE;
import yaboichips.usefulvanilla.common.blocks.mason.MasonOvenTE;
import yaboichips.usefulvanilla.util.UVRegistrar;

public class UVTileEntities {
    public static final UVRegistrar<BlockEntityType<?>> REGISTRAR = new UVRegistrar<>(ForgeRegistries.BLOCK_ENTITIES);

    public static final BlockEntityType<CopperHopperTE> COPPER_HOPPER = register("copper_hopper", BlockEntityType.Builder.of(CopperHopperTE::new, UVBlocks.COPPER_HOPPER));
    public static final BlockEntityType<MasonOvenTE> MASON_OVEN = register("mason_oven", BlockEntityType.Builder.of(MasonOvenTE::new, UVBlocks.MASON_OVEN));

    private static <T extends BlockEntity> BlockEntityType<T> register(String key, BlockEntityType.Builder<T> builder) {
        Type<?> type = Util.fetchChoiceType(References.BLOCK_ENTITY, key);
        BlockEntityType<T> blockEntityType = builder.build(type);
        return REGISTRAR.add(key, blockEntityType);
    }
}
