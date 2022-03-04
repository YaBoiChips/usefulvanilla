package yaboichips.usefulvanilla.core;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.ForgeRegistries;
import yaboichips.usefulvanilla.UsefulVanilla;
import yaboichips.usefulvanilla.mixin.access.StairBlockAccess;
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

    public static final Item TUFF_SLAB = createBlockItem(UVBlocks.TUFF_SLAB);
    public static final Item TUFF_STAIRS = createBlockItem(UVBlocks.TUFF_STAIRS);
    public static final Item TUFF_WALL = createBlockItem(UVBlocks.TUFF_WALL);
    public static final Item POLISHED_TUFF = createBlockItem(UVBlocks.POLISHED_TUFF);
    public static final Item POLISHED_TUFF_SLAB = createBlockItem(UVBlocks.POLISHED_TUFF_SLAB);
    public static final Item POLISHED_TUFF_STAIRS = createBlockItem(UVBlocks.POLISHED_TUFF_STAIRS);
    public static final Item POLISHED_TUFF_WALL = createBlockItem(UVBlocks.POLISHED_TUFF_WALL);
    public static final Item TUFF_BRICKS = createBlockItem(UVBlocks.TUFF_BRICKS);
    public static final Item TUFF_BRICK_SLAB = createBlockItem(UVBlocks.TUFF_BRICK_SLAB);
    public static final Item TUFF_BRICK_STAIRS = createBlockItem(UVBlocks.TUFF_BRICK_STAIRS);
    public static final Item TUFF_BRICK_WALL = createBlockItem(UVBlocks.TUFF_BRICK_WALL);


    public static final Item CALCITE_SLAB = createBlockItem(UVBlocks.CALCITE_SLAB);
    public static final Item CALCITE_STAIRS = createBlockItem(UVBlocks.CALCITE_STAIRS);
    public static final Item CALCITE_WALL = createBlockItem(UVBlocks.CALCITE_WALL);
    public static final Item POLISHED_CALCITE = createBlockItem(UVBlocks.POLISHED_CALCITE);
    public static final Item POLISHED_CALCITE_SLAB = createBlockItem(UVBlocks.POLISHED_CALCITE_SLAB);
    public static final Item POLISHED_CALCITE_STAIRS = createBlockItem(UVBlocks.POLISHED_CALCITE_STAIRS);
    public static final Item POLISHED_CALCITE_WALL = createBlockItem(UVBlocks.POLISHED_CALCITE_WALL);

    public static final Item CALCITE_BRICKS = createBlockItem(UVBlocks.CALCITE_BRICKS);
    public static final Item CALCITE_BRICK_SLAB = createBlockItem(UVBlocks.CALCITE_BRICK_SLAB);
    public static final Item CALCITE_BRICK_STAIRS = createBlockItem(UVBlocks.CALCITE_BRICK_STAIRS);
    public static final Item CALCITE_BRICK_WALL = createBlockItem(UVBlocks.CALCITE_BRICK_WALL);


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