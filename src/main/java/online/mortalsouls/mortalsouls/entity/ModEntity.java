package online.mortalsouls.mortalsouls.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import online.mortalsouls.mortalsouls.MortalSouls;
import online.mortalsouls.mortalsouls.client.renderer.GlaiveRenderer;
import online.mortalsouls.mortalsouls.client.renderer.ShadowEntityRenderer;

import java.util.function.BiFunction;

@Mod.EventBusSubscriber(modid = MortalSouls.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)

public class ModEntity {

    private ModEntity(){}

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MortalSouls.MODID);
    public static final RegistryObject<EntityType<ShadowEntity>> TYPE_SHADOW = createEntityType(ShadowEntity::new, ShadowEntity::new, MobCategory.MISC, "shadow", 0.1F, 0.1F);


    public static final RegistryObject<EntityType<GlaiveProjectile>> GLAIVE_THROWABLE = ENTITIES.register("entity_glaive",
            () -> EntityType.Builder.<GlaiveProjectile>of((e, w) -> new GlaiveProjectile(w), MobCategory.MISC).sized(2.5F, 0.75F).clientTrackingRange(10)
                    .build("entity_glaive"));

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(GLAIVE_THROWABLE.get(), GlaiveRenderer::new);
        event.registerEntityRenderer(TYPE_SHADOW.get(), ShadowEntityRenderer::new);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(TYPE_SHADOW.get(), ShadowEntity.registerAttributes().build());
    }

    public static <T extends Entity> RegistryObject<EntityType<T>> createEntityType(EntityType.EntityFactory<T> factory, BiFunction<PlayMessages.SpawnEntity, Level, T> clientFactory, MobCategory classification, String name, float sizeX, float sizeY) {
        return ENTITIES.register(name, () -> EntityType.Builder.of(factory, classification)
                .setCustomClientFactory(clientFactory)
                .setShouldReceiveVelocityUpdates(false)
                .setUpdateInterval(1)
                .setTrackingRange(8)
                .sized(sizeX, sizeY)
                .build(name));
    }

}



