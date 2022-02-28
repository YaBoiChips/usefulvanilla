package yaboichips.usefulvanilla.core;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.ForgeRegistries;
import yaboichips.usefulvanilla.common.blocks.CopperHopper;
import yaboichips.usefulvanilla.common.blocks.mason.MasonOven;
import yaboichips.usefulvanilla.mixin.access.StairBlockAccess;
import yaboichips.usefulvanilla.util.UVRegistrar;

public class UVBlocks {
    public static final UVRegistrar<Block> REGISTRAR = new UVRegistrar<>(ForgeRegistries.BLOCKS);

    public static final Block COPPER_HOPPER = REGISTRAR.add("copper_hopper", new CopperHopper(BlockBehaviour.Properties.copy(Blocks.HOPPER).noOcclusion()));
    public static final Block MASON_OVEN = REGISTRAR.add("mason_oven", new MasonOven(BlockBehaviour.Properties.copy(Blocks.BLAST_FURNACE)));

    public static final Block COPPER_CHAIN = REGISTRAR.add("copper_chain", new ChainBlock(BlockBehaviour.Properties.copy(Blocks.CHAIN)));
    public static final Block AMETHYST_LANTERN = REGISTRAR.add("amethyst_lantern", new LanternBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN).noOcclusion()));
    public static final Block AMETHYST_END_ROD = REGISTRAR.add("amethyst_end_rod", new EndRodBlock(BlockBehaviour.Properties.of(Material.AMETHYST).instabreak().color(MaterialColor.COLOR_PURPLE)));

    public static final Block TUFF_SLAB = REGISTRAR.add("tuff_slab", new SlabBlock(BlockBehaviour.Properties.copy(Blocks.TUFF)));
    public static final Block TUFF_STAIRS = REGISTRAR.add("tuff_stairs", StairBlockAccess.create(Blocks.TUFF.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.TUFF)));
    public static final Block POLISHED_TUFF = REGISTRAR.add("polished_tuff", new Block(BlockBehaviour.Properties.copy(Blocks.TUFF)));
    public static final Block POLISHED_TUFF_SLAB = REGISTRAR.add("polished_tuff_slab", new SlabBlock(BlockBehaviour.Properties.copy(Blocks.TUFF)));
    public static final Block POLISHED_TUFF_STAIRS = REGISTRAR.add("polished_tuff_stairs", StairBlockAccess.create(POLISHED_TUFF.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.TUFF)));
    public static final Block TUFF_BRICKS = REGISTRAR.add("tuff_brick", new Block(BlockBehaviour.Properties.copy(Blocks.TUFF)));
    public static final Block TUFF_BRICK_SLAB = REGISTRAR.add("tuff_brick_slab", new SlabBlock(BlockBehaviour.Properties.copy(Blocks.TUFF)));
    public static final Block TUFF_BRICK_STAIRS = REGISTRAR.add("tuff_brick_stairs", StairBlockAccess.create(TUFF_BRICKS.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.TUFF)));

    public static final Block CALCITE_SLAB = REGISTRAR.add("calcite_slab", new SlabBlock(BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final Block CALCITE_STAIRS = REGISTRAR.add("calcite_stairs", StairBlockAccess.create(Blocks.CALCITE.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final Block POLISHED_CALCITE = REGISTRAR.add("polished_calcite", new Block(BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final Block POLISHED_CALCITE_SLAB = REGISTRAR.add("polished_calcite_slab", new SlabBlock(BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final Block POLISHED_CALCITE_STAIRS = REGISTRAR.add("polished_calcite_stairs", StairBlockAccess.create(POLISHED_CALCITE.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final Block CALCITE_BRICKS = REGISTRAR.add("calcite_brick", new Block(BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final Block CALCITE_BRICK_SLAB = REGISTRAR.add("calcite_brick_slab", new SlabBlock(BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final Block CALCITE_BRICK_STAIRS = REGISTRAR.add("calcite_brick_stairs", StairBlockAccess.create(CALCITE_BRICKS.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.CALCITE)));
}
