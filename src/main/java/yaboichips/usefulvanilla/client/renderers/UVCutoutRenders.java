package yaboichips.usefulvanilla.client.renderers;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import yaboichips.usefulvanilla.UsefulVanilla;
import yaboichips.usefulvanilla.core.UVBlocks;
import yaboichips.usefulvanilla.core.UVItems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class UVCutoutRenders {
    public static void renderCutOuts(){
        Block[] blocks = {
                UVBlocks.AMETHYST_LANTERN.get(),
                UVBlocks.COPPER_HOPPER.get(),
                UVBlocks.COPPER_CHAIN.get()
        };

        Arrays.stream(blocks).forEach((block) -> ItemBlockRenderTypes.setRenderLayer(block, RenderType.cutoutMipped()));

    }
}
