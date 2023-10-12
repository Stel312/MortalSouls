package online.mortalsouls.mortalsouls.client.handler;

import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import online.mortalsouls.mortalsouls.client.KeyMappingSetup.Keybinds;
import online.mortalsouls.mortalsouls.network.PacketHandler;
import online.mortalsouls.mortalsouls.network.cts.CSSummonShadow;

public class InputHandler {

    @SubscribeEvent
    public static void  handleKeyInputEvent(InputEvent.Key event) {
        Keybinds keyMapping = getPressedKey();
        if(keyMapping != null)
            switch(keyMapping) {
                case SUMMON_SHADOW -> summonShadow();
            }
    }

    private static void summonShadow()
    {
        PacketHandler.sendToServer(new CSSummonShadow());
    }

    private static Keybinds getPressedKey() {
        for(Keybinds key : Keybinds.values())
            if(key.getKey().consumeClick())
                return key;
        return null;
    }
}
