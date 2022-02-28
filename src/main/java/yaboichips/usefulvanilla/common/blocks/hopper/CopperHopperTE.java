package yaboichips.usefulvanilla.common.blocks.hopper;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Container;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.Hopper;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import yaboichips.usefulvanilla.core.UVTileEntities;

import java.util.List;

public class CopperHopperTE extends BlockEntity implements Hopper, Container {

    public static final String INVENTORY = "inv";

    ItemStackHandler inventory = new ItemStackHandler(1);
    private LazyOptional<IItemHandler> inventoryCap = LazyOptional.of(() -> inventory);

    public CopperHopperTE(BlockPos pos, BlockState state) {
        super(UVTileEntities.COPPER_HOPPER, pos, state);
    }

    public CopperHopperTE(BlockEntityType<CopperHopperTE> t, BlockPos pos, BlockState state) {
        super(t, pos, state);
    }


    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag syncData = super.getUpdateTag();
        this.saveAdditional(syncData);
        return syncData;
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
        this.load(pkt.getTag());
        super.onDataPacket(net, pkt);
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public boolean isPowered() {
        return this.getLevel().hasNeighborSignal(this.getBlockPos());
    }

    @Override
    public void invalidateCaps() {
        inventoryCap.invalidate();
        super.invalidateCaps();
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return inventoryCap.cast();
        }
        return super.getCapability(cap, side);
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, CopperHopperTE tile) {
        tile.tick();
    }

    public static <E extends BlockEntity> void clientTick(Level level, BlockPos pos, BlockState state, CopperHopperTE tile) {
        tile.tick();
    }

    public void tick() {
        if (this.isPowered()) {
            return;
        }
        this.tryPullFromWorld(worldPosition.relative(Direction.UP));
        this.tryExtract(inventory, Direction.UP, getFlow(), null);
        Direction exportToSide = this.getBlockState().getValue(CopperHopper.FACING);
        this.moveItems(exportToSide, getFlow(), inventory);
    }

    public int getFlow() {
        return 1;
    }

    private int getRadius() {
        return 1;
    }

    public void tryExtract(IItemHandler myself, Direction extractSide, int qty, ItemStackHandler nullableFilter) {
        if (extractSide == null || !myself.getStackInSlot(0).isEmpty()) {
            return;
        }
        BlockPos posTarget = worldPosition.relative(extractSide);
        BlockEntity tile = level.getBlockEntity(posTarget);
        if (tile != null) {
            IItemHandler itemHandlerFrom = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, extractSide.getOpposite()).orElse(null);
            ItemStack itemTarget;
            if (itemHandlerFrom != null) {
                for (int i = 0; i < itemHandlerFrom.getSlots(); i++) {
                    itemTarget = itemHandlerFrom.extractItem(i, qty, true);
                    if (itemTarget.isEmpty()) {
                        continue;
                    }
                    itemTarget = itemHandlerFrom.extractItem(i, qty, false);
                    ItemStack result = myself.insertItem(0, itemTarget.copy(), false);
                    itemTarget.setCount(result.getCount());
                    return;
                }
            }
        }
    }

    public boolean moveItems(Direction myFacingDir, int max, IItemHandler handlerHere) {
        return moveItems(myFacingDir, worldPosition.relative(myFacingDir), max, handlerHere, 0);
    }

    public boolean moveItems(Direction facing, BlockPos pos, int max, IItemHandler handler, int hopperSlot) {
        if (this.level.isClientSide()) {
            return false;
        }
        if (handler == null) {
            return false;
        }
        Direction themFacingMe = facing.getOpposite();
        BlockEntity tileTarget = this.level.getBlockEntity(pos);
        if (tileTarget == null) {
            return false;
        }
        IItemHandler handlerOutput = tileTarget.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, themFacingMe).orElse(null);
        if (handlerOutput != null) {
            ItemStack drain = handler.extractItem(hopperSlot, max, true);
            int sizeStarted = drain.getCount();
            if (!drain.isEmpty()) {
                for (int slot = 0; slot < handlerOutput.getSlots(); slot++) {
                    drain = handlerOutput.insertItem(slot, drain, false);
                    if (drain.isEmpty()) {
                        break; //done draining
                    }
                }
            }
            int sizeAfter = sizeStarted - drain.getCount();
            if (sizeAfter > 0) {
                handler.extractItem(hopperSlot, sizeAfter, false);
            }
            return sizeAfter > 0;
        }
        return false;
    }

    private void tryPullFromWorld(BlockPos pos) {
        int radius = getRadius();
        AABB aabb = new AABB(
                pos.getX() - radius, pos.getY(), pos.getZ() - radius,
                pos.getX() + radius + 1, pos.getY(), pos.getZ() + radius + 1);
        List<ItemEntity> list = level.getEntitiesOfClass(ItemEntity.class, aabb, (entity) -> {
            return entity.isAlive() && !entity.getItem().isEmpty();
        });
        if (list.size() > 0) {
            ItemEntity stackEntity = list.get(level.random.nextInt(list.size()));
            ItemStack remainder = stackEntity.getItem();
            remainder = inventory.insertItem(0, remainder, false);
            stackEntity.setItem(remainder);
            if (remainder.isEmpty()) {
                stackEntity.remove(Entity.RemovalReason.KILLED);
            }
        }
    }

    @Override
    public void load(CompoundTag tag) {
        inventory.deserializeNBT(tag.getCompound("inv"));
        super.load(tag);
    }

    @Override
    public void saveAdditional(CompoundTag tag) {
        tag.put("inv", inventory.serializeNBT());
        super.saveAdditional(tag);
    }

    @Deprecated
    @Override
    public int getContainerSize() {
        return 0;
    }

    @Deprecated
    @Override
    public boolean isEmpty() {
        return true;
    }

    @Deprecated
    @Override
    public ItemStack getItem(int index) {
        return ItemStack.EMPTY;
    }

    @Deprecated
    @Override
    public ItemStack removeItem(int index, int count) {
        return ItemStack.EMPTY;
    }

    @Deprecated
    @Override
    public ItemStack removeItemNoUpdate(int index) {
        return ItemStack.EMPTY;
    }

    @Deprecated
    @Override
    public void setItem(int index, ItemStack stack) {
    }

    @Deprecated
    @Override
    public boolean stillValid(Player player) {
        return false;
    }

    @Override
    public double getLevelX() {
        return this.getBlockPos().getX();
    }

    @Override
    public double getLevelY() {
        return this.getBlockPos().getY();
    }

    @Override
    public double getLevelZ() {
        return this.getBlockPos().getZ();
    }

    @Override
    public void clearContent() {
    }
}
