package online.mortalsouls.mortalsouls.integration.epicfight;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.loading.FMLEnvironment;
import online.mortalsouls.mortalsouls.MortalSouls;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.BasicAttackAnimation;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.api.client.model.ClientModels;
import yesman.epicfight.api.forgeevent.AnimationRegistryEvent;
import yesman.epicfight.gameasset.Models;

/**
 * @author NStel
 * Class for adding custom animations
 */

public class MortalAnimations {
    public static StaticAnimation GREATSHIELD_DUAL_BLOCK, GREATSHILED_AUTO1;

    private MortalAnimations() {

    }

    public static void register(AnimationRegistryEvent event) {
        event.getRegistryMap().put(MortalSouls.MODID, MortalAnimations::build);

    }

    private static void build() {
        Models<?> models = FMLEnvironment.dist == Dist.CLIENT ? ClientModels.LOGICAL_CLIENT : Models.LOGICAL_SERVER;
        GREATSHIELD_DUAL_BLOCK = new StaticAnimation( true, "biped/living/dual_shield_block", models.biped)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED, .5F);
        GREATSHILED_AUTO1 = new BasicAttackAnimation(0.13F, 0.0F, 0.15F, 0.3F, null,
                "Tool_R", "biped/combat/greatshield_auto1", models.biped)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED, 2F);
    }
}
