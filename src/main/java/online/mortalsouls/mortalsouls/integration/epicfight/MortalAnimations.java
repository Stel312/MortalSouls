package online.mortalsouls.mortalsouls.integration.epicfight;

import online.mortalsouls.mortalsouls.MortalSouls;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.BasicAttackAnimation;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.api.forgeevent.AnimationRegistryEvent;
import yesman.epicfight.gameasset.Armatures;

/**
 * @author NStel
 * Class for adding custom animations
 */

public class MortalAnimations {
    public static StaticAnimation GREATSHIELD_DUAL_BLOCK, GREATSHILED_COMBO1;

    private MortalAnimations() {

    }

    public static void register(AnimationRegistryEvent event) {
        event.getRegistryMap().put(MortalSouls.MODID, MortalAnimations::build);
    }

    private static void build() {
        GREATSHIELD_DUAL_BLOCK = new StaticAnimation( true, "biped/living/dual_shield_block", Armatures.BIPED)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED, .5F);
        GREATSHILED_COMBO1 = new BasicAttackAnimation(0.13F, 0.0F, 0.3F, 0.4F, null,
                Armatures.BIPED.toolR, "biped/combat/greatshield_combo1", Armatures.BIPED)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED, .75F);
    }
}
