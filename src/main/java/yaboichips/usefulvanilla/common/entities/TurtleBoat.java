package yaboichips.usefulvanilla.common.entities;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import yaboichips.usefulvanilla.core.UVEntities;
import yaboichips.usefulvanilla.core.UVItems;

public class TurtleBoat extends Boat {

    private static final EntityDataAccessor<Integer> BOAT_TYPE = SynchedEntityData.defineId(TurtleBoat.class, EntityDataSerializers.INT);

    public TurtleBoat(Level world, double x, double y, double z) {
        this(UVEntities.TURTLE_BOAT.get(), world);
        this.setPos(x, y, z);
        this.setDeltaMovement(Vec3.ZERO);
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }

    public TurtleBoat(EntityType<? extends Boat> boatEntityType, Level worldType) {
        super(boatEntityType, worldType);
    }

    @Override
    public Item getDropItem() {
        return switch (this.getModBoatType()) {
            default -> UVItems.OAK_TURTLE_BOAT.get();
            case BIRCH_TURTLE -> UVItems.BIRCH_TURTLE_BOAT.get();
            case ACACIA_TURTLE -> UVItems.ACACIA_TURTLE_BOAT.get();
            case JUNGLE_TURTLE -> UVItems.JUNGLE_TURTLE_BOAT.get();
            case SPRUCE_TURTLE -> UVItems.SPRUCE_TURTLE_BOAT.get();
            case DARK_OAK_TURTLE -> UVItems.DARK_OAK_TURTLE_BOAT.get();
        };
    }

    public ModType getTypeFromVanilla(Type type){
        return switch (type) {
            default -> ModType.OAK_TURTLE;
            case BIRCH -> ModType.BIRCH_TURTLE;
            case ACACIA -> ModType.ACACIA_TURTLE;
            case JUNGLE -> ModType.JUNGLE_TURTLE;
            case SPRUCE -> ModType.SPRUCE_TURTLE;
            case DARK_OAK -> ModType.DARK_OAK_TURTLE;
        };
    }

    @Override
    public void tick() {
        super.tick();
        this.floatBoat();
    }

    @Override
    public void controlBoat() {
        if (this.isVehicle()) {
            float f = 0.0F;
            if (this.inputLeft) {
                --this.deltaRotation;
            }

            if (this.inputRight) {
                ++this.deltaRotation;
            }

            if (this.inputRight != this.inputLeft && !this.inputUp && !this.inputDown) {
                f += 0.02F;
            }

            this.setYRot(this.getYRot() + this.deltaRotation);
            if (this.inputUp) {
                f += 0.1F;
            }

            if (this.inputDown) {
                f -= 0.02F;
            }

            this.setDeltaMovement(this.getDeltaMovement().add(Mth.sin(-this.getYRot() * ((float) Math.PI / 180F)) * f, 0.0D, Mth.cos(this.getYRot() * ((float) Math.PI / 180F)) * f));
            this.setPaddleState(this.inputRight && !this.inputLeft || this.inputUp, this.inputLeft && !this.inputRight || this.inputUp);
        }
    }

    public ModType getModBoatType() {
        return ModType.byId(this.entityData.get(BOAT_TYPE));
    }

    public void setModBoatType(ModType boatType) {
        this.entityData.set(BOAT_TYPE, boatType.ordinal());
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return new ClientboundAddEntityPacket(this);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(BOAT_TYPE, ModType.OAK_TURTLE.ordinal());
    }


    @Override
    protected void addAdditionalSaveData(CompoundTag compound) {
        compound.putString("Type", this.getModBoatType().getName());
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compound) {
        if (compound.contains("Type", 8)) {
            this.setModBoatType(ModType.getTypeFromString(compound.getString("Type")));
        }
    }

    @Override
    public void animateHurt() {
        this.setHurtDir(-this.getHurtDir());
        this.setHurtTime(10);
        this.setDamage(this.getDamage() * 11.0F);
    }

    public enum ModType {
        OAK_TURTLE("oak_turtle"),
        SPRUCE_TURTLE("spruce_turtle"),
        BIRCH_TURTLE("birch_turtle"),
        DARK_OAK_TURTLE("dark_oak_turtle"),
        JUNGLE_TURTLE("jungle_turtle"),
        ACACIA_TURTLE("acacia_turtle");


        private final String name;

        ModType(String string) {
            this.name = string;
        }

        public static ModType byId(int id) {
            ModType[] values = values();
            if (id < 0 || id >= values.length) {
                id = 0;
            }

            return values[id];
        }

        public static ModType getTypeFromString(String nameIn) {
            ModType[] values = values();

            for (ModType ModType : values) {
                if (ModType.getName().equals(nameIn)) {
                    return ModType;
                }
            }

            return values[0];
        }

        public String getName() {
            return this.name;
        }

        public String toString() {
            return this.name;
        }
    }
}
