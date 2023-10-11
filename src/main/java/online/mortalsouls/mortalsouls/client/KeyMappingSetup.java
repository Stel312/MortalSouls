package online.mortalsouls.mortalsouls.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import online.mortalsouls.mortalsouls.MortalSouls;


@Mod.EventBusSubscriber(value = Dist.CLIENT, bus=Mod.EventBusSubscriber.Bus.MOD)
public class KeyMappingSetup {
    public enum Keybinds{
        SUMMON_SHADOW("key." + MortalSouls.MODID + ".summon_shadow", InputConstants.KEY_G);
        final KeyMapping key;
        Keybinds(String s, int key) {
            this.key = new KeyMapping(s, key, "key." + MortalSouls.MODID + ".combat");
        }
        public KeyMapping getKey() {
            return key;
        }
    }

    @SubscribeEvent
    public static void registerKeys(RegisterKeyMappingsEvent event)
    {
        for(Keybinds key : Keybinds.values())
        event.register(key.getKey());
    }
}
