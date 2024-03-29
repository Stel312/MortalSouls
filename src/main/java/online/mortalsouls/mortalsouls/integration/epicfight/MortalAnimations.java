package online.mortalsouls.mortalsouls.integration.epicfight;

import net.minecraft.stats.Stat;
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
    public static StaticAnimation GREATSHIELD_DUAL_BLOCK;
    public static StaticAnimation GREATSHIELD_COMBO1;
    public static StaticAnimation GREATSHIELD_AIR_SLASH;
    public static StaticAnimation GREATSHIELD_DASH;
    public static StaticAnimation GREATHAMMER_IDLE;
    public static StaticAnimation GREATHAMMER_GUARD;
    public static StaticAnimation TWINBLADE_IDLE;
    private MortalAnimations() {}

    public static void register(AnimationRegistryEvent event) {
        event.getRegistryMap().put(MortalSouls.MODID, MortalAnimations::build);
    }

    private static void build() {
        GREATSHIELD_DUAL_BLOCK = new StaticAnimation( true, "biped/living/dual_shield_block", Armatures.BIPED)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,(self, entitypatch, speed, elapsedTime) -> .5F);
        GREATSHIELD_COMBO1 = new BasicAttackAnimation(0.13F, 0.0F, 0.3F, 0.4F, null,
                Armatures.BIPED.toolR, "biped/combat/greatshield_combo1", Armatures.BIPED)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,(self, entitypatch, speed, elapsedTime) -> 1.0F);
        GREATSHIELD_AIR_SLASH = new BasicAttackAnimation(0.13F, 0.0F, 0.3F, 0.4F, null,
                Armatures.BIPED.toolR, "biped/combat/greatshield_air_slash", Armatures.BIPED)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,(self, entitypatch, speed, elapsedTime) -> 1.5F);

        GREATSHIELD_DASH = new BasicAttackAnimation(0.18F, 0.0F, 0.5F, 0.7F, null,
                Armatures.BIPED.toolR, "biped/combat/greatshield_dash", Armatures.BIPED)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,(self, entitypatch, speed, elapsedTime) -> 1.5F);

        GREATHAMMER_IDLE = new StaticAnimation(true, "biped/living/greathammer_idle", Armatures.BIPED);
        GREATHAMMER_GUARD = new StaticAnimation(true, "biped/skill/guard_greathammer", Armatures.BIPED);


        TWINBLADE_IDLE = new StaticAnimation(true, "biped/living/twinblade_idle", Armatures.BIPED)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,(self, entitypatch, speed, elapsedTime) ->.25F);






    }
}
