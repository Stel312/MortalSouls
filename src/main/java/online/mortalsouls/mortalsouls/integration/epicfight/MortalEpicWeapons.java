package online.mortalsouls.mortalsouls.integration.epicfight;

import net.minecraft.world.item.Item;
import online.mortalsouls.mortalsouls.integration.epicfight.capabilities.MortalShieldCapabilities;
import online.mortalsouls.mortalsouls.integration.epicfight.capabilities.MortalWeaponCapabilities;
import online.mortalsouls.mortalsouls.integration.epicfight.skills.MortalSkills;
import online.mortalsouls.mortalsouls.item.ModItems;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.forgeevent.WeaponCapabilityPresetRegistryEvent;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.ColliderPreset;
import yesman.epicfight.gameasset.EpicFightSounds;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.WeaponCapability;
import yesman.epicfight.world.capabilities.item.WeaponCategory;

import java.util.function.Function;

/**
 * @author NStel
 * Class file for declaring and registering custom weapon types
 */

public class MortalEpicWeapons {

    public static final Function<Item, CapabilityItem.Builder> GREATHAMMER = item ->
            WeaponCapability.builder().category(MortalWeaponCategories.GREATHAMMER).styleProvider(playerpatch ->
                            CapabilityItem.Styles.TWO_HAND).collider(ColliderPreset.GREATSWORD)
                    .swingSound(EpicFightSounds.WHOOSH_BIG).hitSound(EpicFightSounds.BLADE_HIT).canBePlacedOffhand(false)
                    .newStyleCombo(CapabilityItem.Styles.TWO_HAND, Animations.GREATSWORD_AUTO1, Animations.GREATSWORD_AUTO2,
                            Animations.SWORD_COMBO2, Animations.GREATSWORD_DASH, Animations.GREATSWORD_AIR_SLASH)
                    .innateSkill(CapabilityItem.Styles.TWO_HAND, itemstack -> MortalSkills.comboTest)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.IDLE, MortalAnimations.GREATHAMMER_IDLE)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.WALK, MortalAnimations.GREATHAMMER_IDLE)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.CHASE, MortalAnimations.GREATHAMMER_IDLE)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.RUN, MortalAnimations.GREATHAMMER_IDLE)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.JUMP, MortalAnimations.GREATHAMMER_IDLE)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.KNEEL, MortalAnimations.GREATHAMMER_IDLE)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.SNEAK, MortalAnimations.GREATHAMMER_IDLE)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.SWIM, MortalAnimations.GREATHAMMER_IDLE)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.BLOCK, MortalAnimations.GREATHAMMER_GUARD)
                    .constructor(MortalWeaponCapabilities::new);

    public static final Function<Item, CapabilityItem.Builder> TWINBLADE = item ->
            WeaponCapability.builder().category(MortalWeaponCategories.TWINBLADE).styleProvider(playerpatch ->
                            CapabilityItem.Styles.TWO_HAND).collider(ColliderPreset.GREATSWORD)
                    .swingSound(EpicFightSounds.WHOOSH_BIG).hitSound(EpicFightSounds.BLADE_HIT).canBePlacedOffhand(false)
                    .newStyleCombo(CapabilityItem.Styles.TWO_HAND, Animations.SWORD_COMBO1, Animations.SWORD_COMBO2,
                            Animations.SWORD_COMBO3, Animations.SWORD_DASH, Animations.SWORD_AIR_SLASH)
                    .innateSkill(CapabilityItem.Styles.TWO_HAND, itemstack -> MortalSkills.comboTest)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.IDLE, MortalAnimations.TWINBLADE_IDLE)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.WALK, MortalAnimations.TWINBLADE_IDLE)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.CHASE, MortalAnimations.TWINBLADE_IDLE)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.RUN, MortalAnimations.TWINBLADE_IDLE)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.JUMP, MortalAnimations.TWINBLADE_IDLE)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.KNEEL, MortalAnimations.TWINBLADE_IDLE)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.SNEAK, MortalAnimations.TWINBLADE_IDLE)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.SWIM, MortalAnimations.TWINBLADE_IDLE)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.BLOCK, MortalAnimations.TWINBLADE_IDLE)
                    .constructor(MortalWeaponCapabilities::new);
    public static final Function<Item, CapabilityItem.Builder> GREATSHIELD = item ->
            WeaponCapability.builder().category(CapabilityItem.WeaponCategories.SHIELD)
                    .styleProvider(playerpatch ->
                            playerpatch.getOriginal().getMainHandItem().getItem().equals(ModItems.shieldDoorR.get()) &&
                                    playerpatch.getOriginal().getOffhandItem().getItem().equals(ModItems.shieldDoorL.get())
                                    ? CapabilityItem.Styles.TWO_HAND : CapabilityItem.Styles.ONE_HAND)
                    .weaponCombinationPredicator(entitypatch ->
                            entitypatch.getOriginal().getMainHandItem().getItem().equals(ModItems.shieldDoorR.get()) &&
                                    entitypatch.getOriginal().getOffhandItem().getItem().equals(ModItems.shieldDoorL.get()))
                    .newStyleCombo(CapabilityItem.Styles.TWO_HAND, Animations.SWORD_DUAL_COMBO1, Animations.SWORD_DUAL_COMBO2, Animations.SWORD_DUAL_COMBO3, Animations.SWORD_DUAL_DASH, Animations.SWORD_DUAL_AIR_SLASH)
                    .newStyleCombo(CapabilityItem.Styles.ONE_HAND, MortalAnimations.GREATSHIELD_COMBO1, MortalAnimations.GREATSHIELD_DASH, MortalAnimations.GREATSHIELD_AIR_SLASH)
                    .collider(MortalWeaponColider.greatshield)
                    .livingMotionModifier(CapabilityItem.Styles.ONE_HAND, LivingMotions.BLOCK_SHIELD, Animations.BIPED_BLOCK)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.BLOCK_SHIELD, MortalAnimations.GREATSHIELD_DUAL_BLOCK)
                    .canBePlacedOffhand(true).constructor(MortalShieldCapabilities::new);


    private MortalEpicWeapons() {}

    public static void register(WeaponCapabilityPresetRegistryEvent event) {
        event.getTypeEntry().put(MortalWeaponCategories.GREATHAMMER.toString().toLowerCase(), GREATHAMMER);
        event.getTypeEntry().put(MortalWeaponCategories.GREATSHIELD.toString().toLowerCase(), GREATSHIELD);
        event.getTypeEntry().put(MortalWeaponCategories.TWINBLADE.toString().toLowerCase(), TWINBLADE);
    }

    public enum MortalWeaponCategories implements WeaponCategory {
        GREATHAMMER, GREATSHIELD, TWINBLADE;
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
