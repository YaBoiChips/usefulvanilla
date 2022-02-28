package yaboichips.usefulvanilla;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.gui.screens.inventory.BlastFurnaceScreen;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.animal.horse.Llama;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import yaboichips.usefulvanilla.client.UVCutoutRenders;
import yaboichips.usefulvanilla.common.blocks.mason.MasonScreen;
import yaboichips.usefulvanilla.core.*;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(UsefulVanilla.MOD_ID)
public class UsefulVanilla {

    // Directly reference a log4j logger.
    public static final String MOD_ID = "usefulvanilla";
    public static final Logger LOGGER = LogManager.getLogger();

    public UsefulVanilla() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);
        bus.addListener(this::enqueueIMC);
        bus.addListener(this::processIMC);
        bus.addListener(this::doClientThings);
        UVBlocks.REGISTRAR.initialize();
        UVItems.REGISTRAR.initialize();
        UVTileEntities.REGISTRAR.initialize();
        UVMenus.REGISTRAR.initialize();
        UVRecipeSerializers.REGISTRAR.initialize();
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void doClientThings(final FMLClientSetupEvent event){
        System.out.println("doing client things");
        UVCutoutRenders.renderCutOuts();
        MenuScreens.register(UVMenus.MASON_OVEN, MasonScreen::new);
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        InterModComms.sendTo("usefulvanilla", "helloworld", () -> {
            LOGGER.info("Hello world from the MDK");
            return "Hello world";
        });
    }

    private void processIMC(final InterModProcessEvent event) {
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m -> m.messageSupplier().get()).
                collect(Collectors.toList()));
    }

    @SubscribeEvent
    public void doNightVision(LivingEntityUseItemEvent.Finish event){
        if (event.getEntityLiving() instanceof Player player) {
            if (event.getResultStack().getItem() == Items.GLOW_BERRIES){
                if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() == UVItems.COPPER_HELMET && !player.hasEffect(MobEffects.NIGHT_VISION)){
                    player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 1000, 1, false, false));
                    player.level.playSound(player, player.blockPosition(), SoundEvents.BEACON_POWER_SELECT, SoundSource.NEUTRAL, 1, 1);
                }
            }
        }
    }

    @SubscribeEvent
    public void doLlamaSpit(PlayerInteractEvent.EntityInteract event){
        Player player = event.getPlayer();
        if (event.getTarget() instanceof Llama){
            ItemStack stack = player.getMainHandItem();
            if (stack.getItem() == Items.GLASS_BOTTLE){
                turnBottleIntoPot(stack, player, UVItems.LLAMA_SPIT.getDefaultInstance());
                player.level.playSound(player, player.blockPosition(), SoundEvents.LLAMA_SPIT, SoundSource.NEUTRAL, 0.5F, 0.5F);
            }
        }
    }

    private ItemStack turnBottleIntoPot(ItemStack stack, Player player, ItemStack result) {
        player.awardStat(Stats.ITEM_USED.get(player.getMainHandItem().getItem()));
        return ItemUtils.createFilledResult(stack, player, result);
    }

    /*
    llama
    foxes?
     */
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }
}
