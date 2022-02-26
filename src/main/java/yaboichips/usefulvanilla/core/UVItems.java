package yaboichips.usefulvanilla.core;

import net.minecraft.core.Registry;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import yaboichips.usefulvanilla.UsefulVanilla;
import yaboichips.usefulvanilla.util.UVRegistrar;

public class UVItems {
    public static final UVRegistrar<Item> REGISTRAR = new UVRegistrar<>(ForgeRegistries.ITEMS);
    public static final CreativeModeTab TAB = new CreativeModeTab(UsefulVanilla.MOD_ID) {
        @Override
        public ItemStack makeIcon() {
            return Items.APPLE.getDefaultInstance();
        }
    };
    public static final Item COPPER_HOPPER = createBlockItem(UVBlocks.COPPER_HOPPER);

    public static Item createBlockItem(Block block){
        return REGISTRAR.add(block.getRegistryName().getPath(), new BlockItem(block, new Item.Properties().tab(TAB)));
    }
}
