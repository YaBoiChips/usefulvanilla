package yaboichips.usefulvanilla.client;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import yaboichips.usefulvanilla.UsefulVanilla;
import yaboichips.usefulvanilla.core.UVBlocks;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class UVCutoutRenders {
    public static void renderCutOuts(Consumer<Map<Block, RenderType>> mapConsumer) {
        UsefulVanilla.LOGGER.debug("Rendering Texture Cutouts...");
        Map<Block, RenderType> map = new HashMap<>();

        map.put(UVBlocks.AMETHYST_LANTERN, RenderType.cutout());
    }
}
