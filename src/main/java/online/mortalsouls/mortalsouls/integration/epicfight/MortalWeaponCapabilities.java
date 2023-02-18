package online.mortalsouls.mortalsouls.integration.epicfight;

import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.skill.GuardSkill;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.Style;
import yesman.epicfight.world.capabilities.item.WeaponCapability;

import java.util.HashMap;
import java.util.Map;

public class MortalWeaponCapabilities extends WeaponCapability {
    private final Map<String, GuardObject> map = new HashMap<>();
    protected MortalWeaponCapabilities(CapabilityItem.Builder builder) {
        super(builder);
        map.put(this.getWeaponCategory().toString()+ Styles.TWO_HAND, new GuardObject(Animations.GREATSWORD_GUARD_HIT, Animations.GREATSWORD_GUARD_BREAK, Animations.GREATSWORD_GUARD_HIT));
    }

    @Override
    public StaticAnimation getGuardMotion(GuardSkill skill, GuardSkill.BlockType blockType, PlayerPatch<?> playerpatch) {
        return map.get(this.getWeaponCategory().toString()+this.getStyle(playerpatch).toString()).getGuardAnimation(blockType);
    }
}
