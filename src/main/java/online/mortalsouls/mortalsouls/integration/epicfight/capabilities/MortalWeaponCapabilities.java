package online.mortalsouls.mortalsouls.integration.epicfight.capabilities;

import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.skill.guard.GuardSkill;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.WeaponCapability;

public class MortalWeaponCapabilities extends WeaponCapability {
    public MortalWeaponCapabilities(CapabilityItem.Builder builder) {super(builder);}

    @Override
    public StaticAnimation getGuardMotion(GuardSkill skill, GuardSkill.BlockType blockType, PlayerPatch<?> playerpatch) {
        return GuardMapEnum.INSTANCE.getGuardMap().get(this.getWeaponCategory().toString()+this.getStyle(playerpatch))
                .getGuardAnimation(blockType);
    }


}
