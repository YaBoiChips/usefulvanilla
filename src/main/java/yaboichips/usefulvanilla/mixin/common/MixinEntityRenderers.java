package yaboichips.usefulvanilla.mixin.common;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import yaboichips.usefulvanilla.client.renderers.TurtleBoatRenderer;
import yaboichips.usefulvanilla.core.UVEntities;

@Mixin(EntityRenderers.class)
public abstract class MixinEntityRenderers {

    @Shadow
    private static <T extends Entity> void register(EntityType<? extends T> entityType, EntityRendererProvider<T> entityRendererProvider) {
        throw new Error("Mixin did not apply!");
    }

    @Inject(method = "<clinit>", at = @At("RETURN"))
    private static void registerUVRenderers(CallbackInfo ci) {
        register(UVEntities.TURTLE_BOAT.get(), TurtleBoatRenderer::new);
    }
}
