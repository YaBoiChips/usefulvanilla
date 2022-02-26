package yaboichips.usefulvanilla.core;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.ForgeRegistries;
import yaboichips.usefulvanilla.common.blocks.CopperHopper;
import yaboichips.usefulvanilla.util.UVRegistrar;

public class UVBlocks {
    public static final UVRegistrar<Block> REGISTRAR = new UVRegistrar<>(ForgeRegistries.BLOCKS);

    public static final Block COPPER_HOPPER = REGISTRAR.add("copper_hopper", new CopperHopper(BlockBehaviour.Properties.of(Material.METAL)));
}
