package online.mortalsouls.mortalsouls;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import online.mortalsouls.mortalsouls.integration.epicfight.MortalAnimations;
import online.mortalsouls.mortalsouls.integration.epicfight.MortalEpicWeapons;
import online.mortalsouls.mortalsouls.integration.epicfight.skills.MortalSkills;
import online.mortalsouls.mortalsouls.item.ModItems;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MortalSouls.MODID)
public class MortalSouls {
    public static final String MODID = "mortalsouls";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public MortalSouls() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading

        ModItems.getITEMS().register(modEventBus);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        MortalSkills.register();
        modEventBus.addListener(MortalSkills::buildSkillsEvent);
        modEventBus.addListener(MortalAnimations::register);
        modEventBus.addListener(MortalEpicWeapons::register);
    }

    private void setup(final FMLCommonSetupEvent event) {

    }

}
