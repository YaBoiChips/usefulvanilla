package yaboichips.usefulvanilla.client;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import yaboichips.usefulvanilla.UsefulVanilla;
import yaboichips.usefulvanilla.core.UVBlocks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class UVCutoutRenders {
    public static void renderCutOuts(){
        Block[] blocks = {
                UVBlocks.AMETHYST_LANTERN,
                UVBlocks.COPPER_HOPPER
        };

        Arrays.stream(blocks).forEach((block) -> ItemBlockRenderTypes.setRenderLayer(block, RenderType.cutoutMipped()));

    }
}
