package online.mortalsouls.mortalsouls.capabilities;

import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.util.INBTSerializable;
import online.mortalsouls.mortalsouls.client.entity.ShadowEntity;

public interface IPlayerCapabilities extends INBTSerializable<CompoundTag> {

    ShadowEntity getShadow();

    void setShadow(ShadowEntity shadowEntity);

    boolean isSummoned();

    void setSummon(boolean summoned);
}
