package yaboichips.usefulvanilla.core;

import com.mojang.datafixers.types.Type;
import net.minecraft.Util;
import net.minecraft.util.datafix.fixes.References;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import yaboichips.usefulvanilla.UsefulVanilla;
import yaboichips.usefulvanilla.common.blocks.hopper.CopperHopperTE;
import yaboichips.usefulvanilla.common.blocks.mason.MasonOvenTE;

public class UVTileEntities {
    public static final DeferredRegister<BlockEntityType<?>> REGISTRAR =  DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, UsefulVanilla.MOD_ID);

    public static final RegistryObject<BlockEntityType<CopperHopperTE>> COPPER_HOPPER = REGISTRAR.register("copper_hopper", () -> BlockEntityType.Builder.of(CopperHopperTE::new, UVBlocks.COPPER_HOPPER.get()).build(null));
    public static final RegistryObject<BlockEntityType<MasonOvenTE>> MASON_OVEN = REGISTRAR.register("mason_oven", () -> BlockEntityType.Builder.of(MasonOvenTE::new, UVBlocks.MASON_OVEN.get()).build(null));

}
