package yaboichips.usefulvanilla.core;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
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
            return UVItems.AMETHYST_LANTERN.getDefaultInstance();
        }
    };
    public static final Item COPPER_HOPPER = createBlockItem(UVBlocks.COPPER_HOPPER);
    public static final Item MASON_OVEN = createBlockItem(UVBlocks.MASON_OVEN);

    public static final Item COPPER_BOOTS = createArmorItem("copper_boots", UVArmors.COPPER, EquipmentSlot.FEET);
    public static final Item COPPER_LEGGINGS = createArmorItem("copper_leggings", UVArmors.COPPER, EquipmentSlot.LEGS);
    public static final Item COPPER_CHESTPLATE = createArmorItem("copper_chestplate", UVArmors.COPPER, EquipmentSlot.CHEST);
    public static final Item COPPER_HELMET = createArmorItem("copper_helmet", UVArmors.COPPER, EquipmentSlot.HEAD);

    public static final Item RAW_LLAMA = createFoodItem("raw_llama", UVFoods.RAW_LLAMA);
    public static final Item CHARKI = createFoodItem("charki", UVFoods.CHARKI);
    public static final Item RAW_GOAT = createFoodItem("raw_goat", UVFoods.RAW_GOAT);
    public static final Item COOKED_GOAT = createFoodItem("cooked_goat", UVFoods.COOKED_GOAT);

    public static final Item HORSE_BONE = REGISTRAR.add("horse_bone", new Item(new Item.Properties().tab(TAB).craftRemainder(Items.BONE)));
    public static final Item FOX_FUR = createItem("fox_fur");
    public static final Item TALLOW = createItem("tallow");
    public static final Item LLAMA_SPIT = createItem("llama_spit");

    public static final Item AMETHYST_LANTERN = createBlockItem(UVBlocks.AMETHYST_LANTERN);
    public static final Item AMETHYST_END_ROD = createBlockItem(UVBlocks.AMETHYST_END_ROD);
    public static final Item COPPER_CHAIN = createBlockItem(UVBlocks.COPPER_CHAIN);

    public static Item createBlockItem(Block block){
        return REGISTRAR.add(block.getRegistryName().getPath(), new BlockItem(block, new Item.Properties().tab(TAB)));
    }

    public static Item createItem(String id){
        return REGISTRAR.add(id, new Item(new Item.Properties().tab(TAB)));
    }

    public static Item createArmorItem(String id, ArmorMaterial material, EquipmentSlot slot){
        return REGISTRAR.add(id, new ArmorItem(material, slot, new Item.Properties().tab(TAB)));
    }

    public static Item createFoodItem(String id, FoodProperties food){
        return REGISTRAR.add(id, new Item(new Item.Properties().tab(TAB).food(food)));
    }
}