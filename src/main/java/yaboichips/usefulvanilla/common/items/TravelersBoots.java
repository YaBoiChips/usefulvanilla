package yaboichips.usefulvanilla.common.items;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Abilities;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class TravelersBoots extends ArmorItem {
    public TravelersBoots(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
        super(material, slot, properties);
    }


    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if (player.getItemBySlot(EquipmentSlot.FEET) == stack) {
            Abilities abilities = player.getAbilities();
            if (player.isSprinting()) {
                player.maxUpStep = 1.0f;
                abilities.setWalkingSpeed(abilities.getWalkingSpeed() * 0.5F);
            }
            if (!player.isSprinting()) {
                player.maxUpStep = 0.6f;
                abilities.setWalkingSpeed(0.1F);
            }
            super.onArmorTick(stack, level, player);
        }
    }
}
