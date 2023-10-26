package online.mortalsouls.mortalsouls.network.cts;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkEvent;
import online.mortalsouls.mortalsouls.capabilities.IPlayerCapabilities;
import online.mortalsouls.mortalsouls.capabilities.ModCapabilities;
import online.mortalsouls.mortalsouls.entity.ModEntity;
import online.mortalsouls.mortalsouls.entity.ShadowEntity;

import java.util.function.Supplier;

public class CSSummonShadow {

    public CSSummonShadow()
    {

    }


    public void encode(FriendlyByteBuf buffer) {

    }

    public static CSSummonShadow decode(FriendlyByteBuf buffer) {
        return new CSSummonShadow();
    }

    public static void handle(CSSummonShadow message, final Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(()->{
            Player player = ctx.get().getSender();
            IPlayerCapabilities pc = ModCapabilities.getPlayer(player);
            if(!player.getLevel().isClientSide())
            {
                if(pc.getShadow() == null || !pc.isSummoned())
                {
                    ShadowEntity shadowEntity = ModEntity.TYPE_SHADOW.get().create(player.level);
                    shadowEntity.setPlayer(player);
                    shadowEntity.setHealth(player.getMaxHealth());
                    shadowEntity.setPos(player.position());
                    Level level = player.getLevel();
                    level.addFreshEntity(shadowEntity);
                    pc.setSummon(true);
                    pc.setShadow(shadowEntity);
                }
                else{
                    pc.getShadow().kill();
                    pc.setSummon(false);
                }

            }
        });

        ctx.get().setPacketHandled(true );
    }
}
