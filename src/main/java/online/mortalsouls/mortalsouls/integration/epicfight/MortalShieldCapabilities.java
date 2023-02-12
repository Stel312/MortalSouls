package online.mortalsouls.mortalsouls.integration.epicfight;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.UseAnim;
import yesman.epicfight.api.animation.LivingMotion;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.api.collider.Collider;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.Style;
import yesman.epicfight.world.capabilities.item.WeaponCapability;
import yesman.epicfight.world.capabilities.item.WeaponCategory;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @author NStel
 * Class for shield items but applying a hit box for time
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
                return Map.of(LivingMotions.BLOCK, this.livingMotionModifiers.get(this.getStyle(playerdata))
                    .get(LivingMotions.BLOCK));
        } else
            return super.getLivingMotionModifier(playerdata, hand);
    }



}
