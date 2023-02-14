package online.mortalsouls.mortalsouls.integration.epicfight;

import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.skill.GuardSkill;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.WeaponCapability;

public class MortalWeaponCapabilities extends WeaponCapability {

    protected MortalWeaponCapabilities(CapabilityItem.Builder builder) {
        super(builder);
    }

    @Override
    public StaticAnimation getGuardMotion(GuardSkill skill, GuardSkill.BlockType blockType, PlayerPatch<?> playerpatch) {
        StaticAnimation staticAnimation = MortalAnimations.GREATHAMMER_GUARD;
        return staticAnimation;
        //return super.getGuardMotion(skill, blockType, playerpatch);
    }
}
