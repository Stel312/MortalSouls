package online.mortalsouls.mortalsouls.integration.epicfight;

import net.minecraft.world.item.Item;
import online.mortalsouls.mortalsouls.item.ModItems;
import org.antlr.runtime.ANTLRInputStream;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.forgeevent.WeaponCapabilityPresetRegistryEvent;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.ColliderPreset;
import yesman.epicfight.gameasset.EpicFightSounds;
import yesman.epicfight.gameasset.Skills;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.Style;
import yesman.epicfight.world.capabilities.item.WeaponCapability;
import yesman.epicfight.world.capabilities.item.WeaponCategory;

import java.util.function.Function;

/**
 * @author NStel
 * Class file for declaring and registering custom weapon types
 */

public class MortalEpicWeapons {

    public static final Function<Item, CapabilityItem.Builder> GREATHAMMER = item ->
            WeaponCapability.builder().category(CapabilityItem.WeaponCategories.GREATSWORD).styleProvider(playerpatch ->
                            CapabilityItem.Styles.TWO_HAND
                    ).collider(ColliderPreset.GREATSWORD).swingSound(EpicFightSounds.WHOOSH_BIG).hitSound(EpicFightSounds.BLADE_HIT)
                    .canBePlacedOffhand(false)
                    .newStyleCombo(CapabilityItem.Styles.TWO_HAND, Animations.GREATSWORD_AUTO1,
                            Animations.GREATSWORD_AUTO2, Animations.SWORD_AUTO3, Animations.GREATSWORD_DASH, Animations.GREATSWORD_AIR_SLASH)
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
    public static final Function<Item, CapabilityItem.Builder> GREATSHIELD = item ->
            MortalShieldCapabilities.builder().constructor(MortalShieldCapabilities::new).category(MortalWeaponCategories.GREATSHIELD)
                    .styleProvider(playerpatch ->
                            playerpatch.getOriginal().getMainHandItem().getItem().equals(ModItems.shieldDoorR.get()) &&
                                    playerpatch.getOriginal().getOffhandItem().getItem().equals(ModItems.shieldDoorL.get())
                                    ? CapabilityItem.Styles.TWO_HAND : CapabilityItem.Styles.ONE_HAND)
                    .weaponCombinationPredicator(entitypatch ->
                            entitypatch.getOriginal().getMainHandItem().getItem().equals(ModItems.shieldDoorR.get()) &&
                                    entitypatch.getOriginal().getOffhandItem().getItem().equals(ModItems.shieldDoorL.get()))
                    .newStyleCombo(CapabilityItem.Styles.TWO_HAND, Animations.SWORD_DUAL_AUTO1, Animations.SWORD_DUAL_AUTO2, Animations.SWORD_DUAL_AUTO3, Animations.SWORD_DUAL_DASH, Animations.SWORD_DUAL_AIR_SLASH)
                    .newStyleCombo(CapabilityItem.Styles.ONE_HAND, Animations.LONGSWORD_AUTO1, Animations.DAGGER_AUTO2, Animations.SWORD_DASH)
                    .collider(MortalWeaponColider.greatshield)
                    .livingMotionModifier(CapabilityItem.Styles.ONE_HAND, LivingMotions.BLOCK, Animations.BIPED_BLOCK)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.BLOCK, MortalAnimations.dualShieldBlock);


    private MortalEpicWeapons() {
    }

    public static void register(WeaponCapabilityPresetRegistryEvent event) {
        event.getTypeEntry().put(MortalWeaponCategories.GREATHAMMER.toString().toLowerCase(), GREATHAMMER);
        event.getTypeEntry().put(MortalWeaponCategories.GREATSHIELD.toString().toLowerCase(), GREATSHIELD);
    }

    public enum MortalWeaponCategories implements WeaponCategory {
        GREATHAMMER, GREATSHIELD;
        final int id;

        MortalWeaponCategories() {
            this.id = WeaponCategory.ENUM_MANAGER.assign(this);
        }

        @Override
        public int universalOrdinal() {
            return this.id;
        }
    }

}
