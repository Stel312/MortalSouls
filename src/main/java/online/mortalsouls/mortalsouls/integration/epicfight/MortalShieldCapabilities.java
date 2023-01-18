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
import yesman.epicfight.world.capabilities.item.WeaponCategory;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @author NStel
 * Class for shield items but applying a hit box for time
 */
public class MortalShieldCapabilities extends CapabilityItem {
    private final Map<Style, List<StaticAnimation>> autoAttackMotionMap;
    private final Function<LivingEntityPatch<?>, Style> styleProvider;

    private final Function<LivingEntityPatch<?>, Boolean> weaponCombinationPredicator;
    private final Collider collider;
    private final Map<Style, Map<LivingMotion, StaticAnimation>> livingMotionModifiers;

    protected MortalShieldCapabilities(CapabilityItem.Builder builder) {
        super(builder);
        Builder builder1 = (Builder) builder;
        this.autoAttackMotionMap = builder1.autoAttackMotionMap;
        this.collider = builder1.collider;
        this.livingMotionModifiers = builder1.livingMotionModifiers;
        this.styleProvider = builder1.styleProvider;
        this.weaponCombinationPredicator = builder1.weaponCombinationPredicator;
    }

    public static MortalShieldCapabilities.Builder builder() {
        return new MortalShieldCapabilities.Builder();
    }

    @Override
    public UseAnim getUseAnimation(LivingEntityPatch<?> entitypatch) {
        return UseAnim.NONE;
    }

    @Override
    public Style getStyle(LivingEntityPatch<?> entitypatch) {
        return this.styleProvider.apply(entitypatch);
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

    @Override
    public List<StaticAnimation> getAutoAttckMotion(PlayerPatch<?> playerpatch) {
        return this.autoAttackMotionMap.get(this.getStyle(playerpatch));
    }

    @Override
    public boolean checkOffhandValid(LivingEntityPatch<?> entitypatch) {
        return super.checkOffhandValid(entitypatch) || this.weaponCombinationPredicator.apply(entitypatch);
    }

    @Override
    public Collider getWeaponCollider() {

        return this.collider != null ? this.collider : super.getWeaponCollider();
    }

    public static class Builder extends CapabilityItem.Builder {
        private final Map<Style, List<StaticAnimation>> autoAttackMotionMap;
        private Function<LivingEntityPatch<?>, Style> styleProvider;

        private Function<LivingEntityPatch<?>, Boolean> weaponCombinationPredicator;
        private Collider collider;
        private Map<Style, Map<LivingMotion, StaticAnimation>> livingMotionModifiers;

        private Builder() {
            this.autoAttackMotionMap = Maps.newHashMap();
        }


        @Override
        public MortalShieldCapabilities.Builder category(WeaponCategory category) {
            super.category(category);
            return this;
        }

        public MortalShieldCapabilities.Builder livingMotionModifier(Style wieldStyle, LivingMotion livingMotion, StaticAnimation animation) {
            if (this.livingMotionModifiers == null) {
                this.livingMotionModifiers = Maps.newHashMap();
            }

            if (!this.livingMotionModifiers.containsKey(wieldStyle)) {
                this.livingMotionModifiers.put(wieldStyle, Maps.newHashMap());
            }

            (this.livingMotionModifiers.get(wieldStyle)).put(livingMotion, animation);
            return this;
        }

        public MortalShieldCapabilities.Builder collider(Collider collider) {
            this.collider = collider;
            return this;
        }

        public MortalShieldCapabilities.Builder newStyleCombo(Style style, StaticAnimation... animation) {
            this.autoAttackMotionMap.put(style, Lists.newArrayList(animation));
            return this;
        }

        public MortalShieldCapabilities.Builder styleProvider(Function<LivingEntityPatch<?>, Style> styleProvider) {
            this.styleProvider = styleProvider;
            return this;
        }

        @Override
        public MortalShieldCapabilities.Builder constructor(Function<CapabilityItem.Builder, CapabilityItem> constructor) {
            super.constructor(constructor);
            return this;
        }

        public MortalShieldCapabilities.Builder weaponCombinationPredicator(Function<LivingEntityPatch<?>, Boolean> predicator) {
            this.weaponCombinationPredicator = predicator;
            return this;
        }
    }
}
