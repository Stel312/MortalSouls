package online.mortalsouls.mortalsouls.integration.epicfight;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.UseAnim;
import yesman.epicfight.api.animation.LivingMotion;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.WeaponCapability;

import java.util.Map;

/**
 * @author NStel
 * Class for shield capabilities
 */
public class MortalShieldCapabilities extends WeaponCapability {

    protected MortalShieldCapabilities(CapabilityItem.Builder builder) {
        super(builder);
    }

    @Override
    public boolean canHoldInOffhandAlone() {
        return true;
    }

    @Override
    public UseAnim getUseAnimation(LivingEntityPatch<?> entitypatch) {
        return UseAnim.NONE;
    }

    @Override
    public Map<LivingMotion, StaticAnimation> getLivingMotionModifier(LivingEntityPatch<?> playerdata, InteractionHand hand) {
        if (this.livingMotionModifiers != null) {
            if (hand != InteractionHand.OFF_HAND)
                return this.livingMotionModifiers.get(this.getStyle(playerdata));
            else
                return Map.of(LivingMotions.BLOCK_SHIELD, Animations.BIPED_BLOCK);
        } else
            return super.getLivingMotionModifier(playerdata, hand);
    }
}
