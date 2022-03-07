package yaboichips.usefulvanilla.core;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import yaboichips.usefulvanilla.UsefulVanilla;
import yaboichips.usefulvanilla.common.entities.DragonsBreathEntity;
import yaboichips.usefulvanilla.common.entities.TurtleBoat;

public class UVEntities {
    public static final DeferredRegister<EntityType<?>> REGISTRAR =  DeferredRegister.create(ForgeRegistries.ENTITIES, UsefulVanilla.MOD_ID);

    public static final RegistryObject<EntityType<DragonsBreathEntity>> DRAGON_BREATH = REGISTRAR.register("dragons_breath_entity", () -> EntityType.Builder.<DragonsBreathEntity>of(DragonsBreathEntity::new, MobCategory.AMBIENT).build("dragons_breath_entity"));
    public static final RegistryObject<EntityType<TurtleBoat>> TURTLE_BOAT = REGISTRAR.register("turtle_boat", () -> EntityType.Builder.<TurtleBoat>of(TurtleBoat::new, MobCategory.AMBIENT).build("turtle_boat"));

}
