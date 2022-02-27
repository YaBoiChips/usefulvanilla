package yaboichips.usefulvanilla.core;

import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.registries.ForgeRegistries;
import yaboichips.usefulvanilla.common.blocks.mason.MasonMenu;
import yaboichips.usefulvanilla.util.UVRegistrar;

public class UVMenus {
    public static final UVRegistrar<MenuType<?>> REGISTRAR = new UVRegistrar<>(ForgeRegistries.CONTAINERS);


    public static final MenuType<MasonMenu> MASON_OVEN = REGISTRAR.add("blast_furnace", new MenuType<>(MasonMenu::new));
}
