package yaboichips.usefulvanilla.common.entities;

import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.Level;
import yaboichips.usefulvanilla.core.UVEntities;

public class TurtleBoat extends Boat {
    public TurtleBoat(EntityType<? extends TurtleBoat> type, Level world) {
        super(type, world);
    }

    public TurtleBoat(Level world, double x, double y, double z) {
        this(UVEntities.TURTLE_BOAT.get(), world);
        this.setPos(x, y, z);
        this.xo = x;
        this.yo = y;
        this.zo = z;
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
                f += 0.01F;
            }

            this.setYRot(this.getYRot() + this.deltaRotation);
            if (this.inputUp) {
                f += 0.08F;
            }

            if (this.inputDown) {
                f -= 0.01F;
            }

            this.setDeltaMovement(this.getDeltaMovement().add(Mth.sin(-this.getYRot() * ((float) Math.PI / 180F)) * f, 0.0D, Mth.cos(this.getYRot() * ((float) Math.PI / 180F)) * f));
            this.setPaddleState(this.inputRight && !this.inputLeft || this.inputUp, this.inputLeft && !this.inputRight || this.inputUp);
        }
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return new ClientboundAddEntityPacket(this);
    }

    @Override
    public void animateHurt() {
        this.setHurtDir(-this.getHurtDir());
        this.setHurtTime(10);
        this.setDamage(this.getDamage() * 11.0F);
    }

    public enum ModType {
        OAK_TURTLE("oak_turtle"),
        SPRUCE_TURTLE("oak_turtle"),
        BIRCH_TURTLE("oak_turtle"),
        DARK_OAK_TURTLE("oak_turtle"),
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
