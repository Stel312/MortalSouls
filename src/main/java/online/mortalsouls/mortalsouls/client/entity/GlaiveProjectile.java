package online.mortalsouls.mortalsouls.client.entity;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class GlaiveProjectile extends ThrowableItemProjectile {

    public static final EntityDataAccessor<ItemStack> ITEMSTACK = SynchedEntityData.defineId(GlaiveProjectile.class, EntityDataSerializers.ITEM_STACK);
    //private static final EntityDataAccessor<Integer> ROTATION_POINT = SynchedEntityData.defineId(GlaiveProjectile.class, EntityDataSerializers.INT);
    //private static final EntityDataAccessor<Integer> BOUNCE_NUM = SynchedEntityData.defineId(GlaiveProjectile.class, EntityDataSerializers.INT);

    public GlaiveProjectile(EntityType<? extends ThrowableItemProjectile> entityType, Level world) {
        super(entityType, world);
    }

    public GlaiveProjectile(Level world)
    {
        this(ModEntity.GLAIVE_THROWABLE.get(), world);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(ITEMSTACK, ItemStack.EMPTY);

    }

    @Override
    protected Item getDefaultItem() {
        return null;
    }

    @Override
    protected void onHit(HitResult p_37260_) {
        super.onHit(p_37260_);
    }

}
