package online.mortalsouls.mortalsouls.integration.epicfight;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.loading.FMLEnvironment;
import online.mortalsouls.mortalsouls.MortalSouls;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.api.client.model.ClientModels;
import yesman.epicfight.api.forgeevent.AnimationRegistryEvent;
import yesman.epicfight.gameasset.Models;

/**
 * @author NStel
 * Class for adding custom animations
 */

public class MortalAnimations {
    public static StaticAnimation dualShieldBlock;

    private MortalAnimations() {

    }

    public static void register(AnimationRegistryEvent event) {
        event.getRegistryMap().put(MortalSouls.MODID, MortalAnimations::build);

    }

    private static void build() {
        Models<?> models = FMLEnvironment.dist == Dist.CLIENT ? ClientModels.LOGICAL_CLIENT : Models.LOGICAL_SERVER;
        dualShieldBlock = new StaticAnimation( true, "biped/living/dual_shield_block", models.biped)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED, .25F);
    }
}
