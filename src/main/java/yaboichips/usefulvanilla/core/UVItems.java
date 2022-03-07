package yaboichips.usefulvanilla.core;

import ca.weblite.objc.Proxy;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import yaboichips.usefulvanilla.UsefulVanilla;
import yaboichips.usefulvanilla.common.entities.TurtleBoat;
import yaboichips.usefulvanilla.common.items.ThrowableDragonsBreath;
import yaboichips.usefulvanilla.common.items.TurtleBoatItem;

import static yaboichips.usefulvanilla.common.entities.TurtleBoat.ModType.*;

public class UVItems {
    public static final DeferredRegister<Item> REGISTRAR = DeferredRegister.create(ForgeRegistries.ITEMS, UsefulVanilla.MOD_ID);
    public static final CreativeModeTab TAB = new CreativeModeTab(UsefulVanilla.MOD_ID) {
        @Override
        public ItemStack makeIcon() {
            return UVItems.AMETHYST_LANTERN.get().getDefaultInstance();
        }
    };
    public static final RegistryObject<Item> COPPER_HOPPER = REGISTRAR.register("copper_hopper", () -> new BlockItem(UVBlocks.COPPER_HOPPER.get(), new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> MASON_OVEN = createBlockItem("mason_oven", UVBlocks.MASON_OVEN);

    public static final RegistryObject<Item> TUFF_SLAB = createBlockItem("tuff_slab", UVBlocks.TUFF_SLAB);
    public static final RegistryObject<Item> TUFF_STAIRS = createBlockItem("tuff_stairs", UVBlocks.TUFF_STAIRS);
    public static final RegistryObject<Item> TUFF_WALL = createBlockItem("tuff_wall", UVBlocks.TUFF_WALL);
    public static final RegistryObject<Item> POLISHED_TUFF = createBlockItem("polished_tuff", UVBlocks.POLISHED_TUFF);
    public static final RegistryObject<Item> POLISHED_TUFF_SLAB = createBlockItem("polished_tuff_slab", UVBlocks.POLISHED_TUFF_SLAB);
    public static final RegistryObject<Item> POLISHED_TUFF_STAIRS = createBlockItem("polished_tuff_stairs", UVBlocks.POLISHED_TUFF_STAIRS);
    public static final RegistryObject<Item> POLISHED_TUFF_WALL = createBlockItem("polished_tuff_wall", UVBlocks.POLISHED_TUFF_WALL);
    public static final RegistryObject<Item> TUFF_BRICKS = createBlockItem("tuff_bricks", UVBlocks.TUFF_BRICKS);
    public static final RegistryObject<Item> TUFF_BRICK_SLAB = createBlockItem("tuff_brick_slab", UVBlocks.TUFF_BRICK_SLAB);
    public static final RegistryObject<Item> TUFF_BRICK_STAIRS = createBlockItem("tuff_brick_stair", UVBlocks.TUFF_BRICK_STAIRS);
    public static final RegistryObject<Item> TUFF_BRICK_WALL = createBlockItem("tuff_brick_wall", UVBlocks.TUFF_BRICK_WALL);


    public static final RegistryObject<Item> CALCITE_SLAB = createBlockItem("calcite_slab", UVBlocks.CALCITE_SLAB);
    public static final RegistryObject<Item> CALCITE_STAIRS = createBlockItem("calcite_stairs", UVBlocks.CALCITE_STAIRS);
    public static final RegistryObject<Item> CALCITE_WALL = createBlockItem("calcite_wall", UVBlocks.CALCITE_WALL);
    public static final RegistryObject<Item> POLISHED_CALCITE = createBlockItem("polished_calcite", UVBlocks.POLISHED_CALCITE);
    public static final RegistryObject<Item> POLISHED_CALCITE_SLAB = createBlockItem("polished_calcite_slab", UVBlocks.POLISHED_CALCITE_SLAB);
    public static final RegistryObject<Item> POLISHED_CALCITE_STAIRS = createBlockItem("polished_calcite_stairs", UVBlocks.POLISHED_CALCITE_STAIRS);
    public static final RegistryObject<Item> POLISHED_CALCITE_WALL = createBlockItem("polished_calcite_wall", UVBlocks.POLISHED_CALCITE_WALL);

    public static final RegistryObject<Item> CALCITE_BRICKS = createBlockItem("calcite_bricks", UVBlocks.CALCITE_BRICKS);
    public static final RegistryObject<Item> CALCITE_BRICK_SLAB = createBlockItem("calcite_brick_slab", UVBlocks.CALCITE_BRICK_SLAB);
    public static final RegistryObject<Item> CALCITE_BRICK_STAIRS = createBlockItem("calcite_brick_stairs", UVBlocks.CALCITE_BRICK_STAIRS);
    public static final RegistryObject<Item> CALCITE_BRICK_WALL = createBlockItem("calcite_brick_wall", UVBlocks.CALCITE_BRICK_WALL);


    public static final RegistryObject<Item> COPPER_BOOTS = createArmorItem("copper_boots", UVArmors.COPPER, EquipmentSlot.FEET);
    public static final RegistryObject<Item> COPPER_LEGGINGS = createArmorItem("copper_leggings", UVArmors.COPPER, EquipmentSlot.LEGS);
    public static final RegistryObject<Item> COPPER_CHESTPLATE = createArmorItem("copper_chestplate", UVArmors.COPPER, EquipmentSlot.CHEST);
    public static final RegistryObject<Item> COPPER_HELMET = createArmorItem("copper_helmet", UVArmors.COPPER, EquipmentSlot.HEAD);

    public static final RegistryObject<Item> RAW_LLAMA = createFoodItem("raw_llama", UVFoods.RAW_LLAMA);
    public static final RegistryObject<Item> CHARKI = createFoodItem("charki", UVFoods.CHARKI);
    public static final RegistryObject<Item> RAW_GOAT = createFoodItem("raw_goat", UVFoods.RAW_GOAT);
    public static final RegistryObject<Item> COOKED_GOAT = createFoodItem("cooked_goat", UVFoods.COOKED_GOAT);

    public static final RegistryObject<Item> HORSE_BONE = REGISTRAR.register("horse_bone", () -> new Item(new Item.Properties().tab(TAB).craftRemainder(Items.BONE)));
    public static final RegistryObject<Item> FOX_FUR = createItem("fox_fur");
    public static final RegistryObject<Item> TALLOW = createItem("tallow");
    public static final RegistryObject<Item> LLAMA_SPIT = createItem("llama_spit");
    public static final RegistryObject<Item> THROWABLE_DRAGONS_BREATH = REGISTRAR.register("throwable_dragons_breath", () -> new ThrowableDragonsBreath(new Item.Properties().tab(TAB)));

    public static final RegistryObject<Item> AMETHYST_LANTERN = createBlockItem("amethyst_lantern", UVBlocks.AMETHYST_LANTERN);
    public static final RegistryObject<Item> AMETHYST_END_ROD = createBlockItem("amethyst_end_rod", UVBlocks.AMETHYST_END_ROD);
    public static final RegistryObject<Item> COPPER_CHAIN = createBlockItem("copper_chain", UVBlocks.COPPER_CHAIN);
    public static final RegistryObject<Item> OAK_TURTLE_BOAT = createBoatItem(OAK_TURTLE, "oak_turtle_boat");
    public static final RegistryObject<Item> BIRCH_TURTLE_BOAT = createBoatItem(BIRCH_TURTLE, "birch_turtle_boat");
    public static final RegistryObject<Item> DARK_OAK_TURTLE_BOAT = createBoatItem(DARK_OAK_TURTLE, "dark_oak_turtle_boat");
    public static final RegistryObject<Item> ACACIA_TURTLE_BOAT = createBoatItem(ACACIA_TURTLE, "acacia_turtle_boat");
    public static final RegistryObject<Item> SPRUCE_TURTLE_BOAT = createBoatItem(SPRUCE_TURTLE, "spruce_turtle_boat");
    public static final RegistryObject<Item> JUNGLE_TURTLE_BOAT = createBoatItem(JUNGLE_TURTLE, "jungle_turtle_boat");

    public static RegistryObject<Item> createBlockItem(String id, RegistryObject<Block> block){
        return REGISTRAR.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(TAB)));
    }

    public static RegistryObject<Item> createItem(String id){
        return REGISTRAR.register(id, () -> new Item(new Item.Properties().tab(TAB)));
    }

    public static RegistryObject<Item> createBoatItem(TurtleBoat.ModType type, String id){
        return REGISTRAR.register(id, () -> new TurtleBoatItem(type, new Item.Properties().tab(TAB).stacksTo(1)));
    }

    public static RegistryObject<Item> createArmorItem(String id, ArmorMaterial material, EquipmentSlot slot){
        return REGISTRAR.register(id, () -> new ArmorItem(material, slot, new Item.Properties().tab(TAB)));
    }

    public static RegistryObject<Item> createFoodItem(String id, FoodProperties food){
        return REGISTRAR.register(id, () -> new Item(new Item.Properties().tab(TAB).food(food)));
    }
}