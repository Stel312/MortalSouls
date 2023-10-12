package online.mortalsouls.mortalsouls.capabilities;

import net.minecraft.nbt.CompoundTag;
import online.mortalsouls.mortalsouls.client.entity.ShadowEntity;

public class PlayerCapabilities implements IPlayerCapabilities{

    private ShadowEntity shadowEntity;
    private boolean isSummoned = false;
    @Override
    public ShadowEntity getShadow() {
        return shadowEntity;
    }

    @Override
    public void setShadow(ShadowEntity shadowEntity) {
        this.shadowEntity = shadowEntity;
    }

    @Override
    public boolean isSummoned() {
        return isSummoned;
    }

    @Override
    public void setSummon(boolean summoned) {
        this.isSummoned = summoned;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag storage = new CompoundTag();
        if(shadowEntity != null)
            storage.put("shadow",shadowEntity.serializeNBT());
        storage.putBoolean("summoned", isSummoned);
        return storage;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        if(shadowEntity!= null)
        {
            this.shadowEntity.deserializeNBT(nbt.getCompound("shadow"));
        }
        this.setSummon(nbt.getBoolean("summoned"));
    }
}
