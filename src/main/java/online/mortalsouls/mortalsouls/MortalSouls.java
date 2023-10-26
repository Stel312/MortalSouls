package online.mortalsouls.mortalsouls;

import com.mojang.logging.LogUtils;
import dev.gigaherz.jsonthings.things.serializers.FlexItemType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import online.mortalsouls.mortalsouls.capabilities.ModCapabilities;
import online.mortalsouls.mortalsouls.client.handler.InputHandler;
import online.mortalsouls.mortalsouls.entity.ModEntity;
import online.mortalsouls.mortalsouls.integration.epicfight.MortalAnimations;
import online.mortalsouls.mortalsouls.integration.epicfight.MortalEpicWeapons;
import online.mortalsouls.mortalsouls.integration.epicfight.PatchProvider;
import online.mortalsouls.mortalsouls.integration.epicfight.skills.MortalSkills;
import online.mortalsouls.mortalsouls.integration.jsonthings.flexItemType.FlexGlaiveItem;
import online.mortalsouls.mortalsouls.integration.jsonthings.serializer.Serializers;
import online.mortalsouls.mortalsouls.item.ModItems;
import online.mortalsouls.mortalsouls.network.PacketHandler;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MortalSouls.MODID)
public class MortalSouls {
    public static final String MODID = "mortalsouls";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    FlexItemType<FlexGlaiveItem> GLAIVE;
    public MortalSouls() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        initFlexItems();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        ModItems.getITEMS().register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(ModCapabilities::register);
        MinecraftForge.EVENT_BUS.register(ModCapabilities.class);
        ModEntity.ENTITIES.register(modEventBus);
        MinecraftForge.EVENT_BUS.addListener(InputHandler::handleKeyInputEvent);
        MortalSkills.register();
        modEventBus.addListener(MortalAnimations::register);
        modEventBus.addListener(MortalEpicWeapons::register);

    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(PacketHandler::register);
        event.enqueueWork(PatchProvider::registerEntityPatches);
    }

    private void initFlexItems()
    {
        GLAIVE = FlexItemType.register("glaive", Serializers.glaiveSerializer(FlexGlaiveItem::new));
    }

}
