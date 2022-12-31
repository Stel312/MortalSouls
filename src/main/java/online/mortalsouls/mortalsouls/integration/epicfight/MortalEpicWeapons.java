package online.mortalsouls.mortalsouls.integration.epicfight;

import com.ibm.icu.text.RelativeDateTimeFormatter;
import net.minecraft.world.item.Item;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.api.forgeevent.WeaponCapabilityPresetRegistryEvent;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.ColliderPreset;
import yesman.epicfight.gameasset.EpicFightSounds;
import yesman.epicfight.gameasset.Skills;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.ShieldCapability;
import yesman.epicfight.world.capabilities.item.WeaponCapability;
import yesman.epicfight.world.capabilities.item.WeaponCategory;

import java.util.function.Function;

public class MortalEpicWeapons {

    private  MortalEpicWeapons() {
    }


    public static final Function<Item, CapabilityItem.Builder> GREATHAMMER = (item) -> {
        return WeaponCapability.builder().category(CapabilityItem.WeaponCategories.GREATSWORD).styleProvider((playerpatch) -> {
            return CapabilityItem.Styles.TWO_HAND;
        }).collider(ColliderPreset.GREATSWORD).swingSound(EpicFightSounds.WHOOSH_BIG).hitSound(EpicFightSounds.BLADE_HIT)
                .canBePlacedOffhand(false)
                .newStyleCombo(CapabilityItem.Styles.TWO_HAND, new StaticAnimation[]{Animations.GREATSWORD_AUTO1,
                        Animations.GREATSWORD_AUTO2, Animations.GREATSWORD_DASH, Animations.GREATSWORD_AIR_SLASH})
                .specialAttack(CapabilityItem.Styles.TWO_HAND, Skills.GIANT_WHIRLWIND)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.IDLE, Animations.BIPED_HOLD_GREATSWORD)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.WALK, Animations.BIPED_HOLD_GREATSWORD)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.CHASE, Animations.BIPED_HOLD_GREATSWORD)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.RUN, Animations.BIPED_HOLD_GREATSWORD)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.JUMP, Animations.BIPED_HOLD_GREATSWORD)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.KNEEL, Animations.BIPED_HOLD_GREATSWORD)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.SNEAK, Animations.BIPED_HOLD_GREATSWORD)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.SWIM, Animations.BIPED_HOLD_GREATSWORD)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.BLOCK, Animations.GREATSWORD_GUARD);

    };
    public static final Function<Item, CapabilityItem.Builder> GREATSHIELD = (item) -> {
        return new ShieldRework.Builder().category(MortalWeaponCategories.GREATSHIELD).collider(MortalWeaponColider.greatshield)
                .newStyleCombo(CapabilityItem.Styles.ONE_HAND, Animations.DAGGER_AUTO1, Animations.DAGGER_AUTO2);
    };
    public static void register(WeaponCapabilityPresetRegistryEvent event) {
        event.getTypeEntry().put(MortalWeaponCategories.GREATHAMMER.toString().toLowerCase(), GREATHAMMER);
    }
    public enum MortalWeaponCategories implements WeaponCategory {
        GREATHAMMER, SHIELD, GREATSHIELD;
        final int id;

        private MortalWeaponCategories() {
            this.id = WeaponCategory.ENUM_MANAGER.assign(this);
        }

        @Override
        public int universalOrdinal() {
            return this.id;
        }
    }

}
