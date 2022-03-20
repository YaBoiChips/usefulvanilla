package yaboichips.usefulvanilla.core;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import yaboichips.usefulvanilla.UsefulVanilla;
import yaboichips.usefulvanilla.common.blocks.hopper.CopperHopper;
import yaboichips.usefulvanilla.common.blocks.mason.MasonOven;
import yaboichips.usefulvanilla.mixin.access.StairBlockAccess;

public class UVBlocks {
    public static final DeferredRegister<Block> REGISTRAR = DeferredRegister.create(ForgeRegistries.BLOCKS, UsefulVanilla.MOD_ID);

    public static final RegistryObject<Block> COPPER_HOPPER = REGISTRAR.register("copper_hopper", () -> new CopperHopper(BlockBehaviour.Properties.copy(Blocks.HOPPER).noOcclusion()));
    public static final RegistryObject<Block> MASON_OVEN = REGISTRAR.register("mason_oven", () -> new MasonOven(BlockBehaviour.Properties.copy(Blocks.BLAST_FURNACE)));

    public static final RegistryObject<Block> COPPER_CHAIN = REGISTRAR.register("copper_chain", () -> new ChainBlock(BlockBehaviour.Properties.copy(Blocks.CHAIN)));
    public static final RegistryObject<Block> AMETHYST_LANTERN = REGISTRAR.register("amethyst_lantern", () -> new LanternBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN).noOcclusion()));
    public static final RegistryObject<Block> AMETHYST_END_ROD = REGISTRAR.register("amethyst_end_rod", () -> new EndRodBlock(BlockBehaviour.Properties.copy(Blocks.END_ROD)));

    public static final RegistryObject<Block> TUFF_SLAB = REGISTRAR.register("tuff_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.TUFF)));
    public static final RegistryObject<Block> TUFF_STAIRS = REGISTRAR.register("tuff_stairs", () -> StairBlockAccess.create(Blocks.TUFF.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.TUFF)));
    public static final RegistryObject<Block> TUFF_WALL = REGISTRAR.register("tuff_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.TUFF)));
    public static final RegistryObject<Block> POLISHED_TUFF = REGISTRAR.register("polished_tuff", () -> new Block(BlockBehaviour.Properties.copy(Blocks.TUFF)));
    public static final RegistryObject<Block> POLISHED_TUFF_SLAB = REGISTRAR.register("polished_tuff_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.TUFF)));
    public static final RegistryObject<Block> POLISHED_TUFF_STAIRS = REGISTRAR.register("polished_tuff_stairs", () -> StairBlockAccess.create(POLISHED_TUFF.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.TUFF)));
    public static final RegistryObject<Block> POLISHED_TUFF_WALL = REGISTRAR.register("polished_tuff_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.TUFF)));
    public static final RegistryObject<Block> TUFF_BRICKS = REGISTRAR.register("tuff_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.TUFF)));
    public static final RegistryObject<Block> TUFF_BRICK_SLAB = REGISTRAR.register("tuff_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.TUFF)));
    public static final RegistryObject<Block> TUFF_BRICK_STAIRS = REGISTRAR.register("tuff_brick_stairs", () -> StairBlockAccess.create(TUFF_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.TUFF)));
    public static final RegistryObject<Block> TUFF_BRICK_WALL = REGISTRAR.register("tuff_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.TUFF)));

    public static final RegistryObject<Block> CALCITE_SLAB = REGISTRAR.register("calcite_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final RegistryObject<Block> CALCITE_STAIRS = REGISTRAR.register("calcite_stairs", () -> StairBlockAccess.create(Blocks.CALCITE.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final RegistryObject<Block> CALCITE_WALL = REGISTRAR.register("calcite_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final RegistryObject<Block> POLISHED_CALCITE = REGISTRAR.register("polished_calcite", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final RegistryObject<Block> POLISHED_CALCITE_SLAB = REGISTRAR.register("polished_calcite_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final RegistryObject<Block> POLISHED_CALCITE_STAIRS = REGISTRAR.register("polished_calcite_stairs", () -> StairBlockAccess.create(POLISHED_CALCITE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final RegistryObject<Block> POLISHED_CALCITE_WALL = REGISTRAR.register("polished_calcite_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final RegistryObject<Block> CALCITE_BRICKS = REGISTRAR.register("calcite_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final RegistryObject<Block> CALCITE_BRICK_SLAB = REGISTRAR.register("calcite_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final RegistryObject<Block> CALCITE_BRICK_STAIRS = REGISTRAR.register("calcite_brick_stairs", () -> StairBlockAccess.create(CALCITE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final RegistryObject<Block> CALCITE_BRICK_WALL = REGISTRAR.register("calcite_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.CALCITE)));
}