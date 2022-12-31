package online.mortalsouls.mortalsouls.integration.epicfight;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import yesman.epicfight.api.animation.LivingMotion;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.api.collider.Collider;
import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.ShieldCapability;
import yesman.epicfight.world.capabilities.item.Style;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class ShieldRework extends ShieldCapability {

    protected final Function<LivingEntityPatch<?>, Style> stylegetter;
    protected final Collider weaponCollider;
    protected final Map<Style, List<StaticAnimation>> autoAttackMotions;

    protected final Map<Style, Map<LivingMotion, StaticAnimation>> livingMotionModifiers;

    protected ShieldRework(CapabilityItem.Builder builder) {
        super(builder);
        Builder shieldBuilder = (Builder) builder;
        this.autoAttackMotions = shieldBuilder.autoAttackMotionMap;
        this.livingMotionModifiers = shieldBuilder.livingMotionModifiers;
        this.stylegetter = shieldBuilder.styleProvider;
        this.weaponCollider = shieldBuilder.collider;
    }

    @Override
    public final List getAutoAttckMotion(PlayerPatch<?> playerpatch) {
        return (List)this.autoAttackMotions.get(this.getStyle(playerpatch));
    }

    @Override
    public Style getStyle(LivingEntityPatch<?> entitypatch) {
        return super.getStyle(entitypatch);
    }

    @Override
    public Collider getWeaponCollider() {
        return super.getWeaponCollider();
    }

    public static class Builder extends CapabilityItem.Builder {
        private Function<LivingEntityPatch<?>, Style> styleProvider;
        private Collider collider;
        private Map<Style, List<StaticAnimation>> autoAttackMotionMap;
        Map<Style, Map<LivingMotion, StaticAnimation>> livingMotionModifiers;

        public ShieldRework.Builder livingMotionModifier(Style wieldStyle, LivingMotion livingMotion, StaticAnimation animation) {
            if (this.livingMotionModifiers == null) {
                this.livingMotionModifiers = Maps.newHashMap();
            }

            if (!this.livingMotionModifiers.containsKey(wieldStyle)) {
                this.livingMotionModifiers.put(wieldStyle, Maps.newHashMap());
            }

            ((Map)this.livingMotionModifiers.get(wieldStyle)).put(livingMotion, animation);
            return this;
        }

        public ShieldRework.Builder collider(Collider collider) {
            this.collider = collider;
            return this;
        }

        public ShieldRework.Builder newStyleCombo(Style style, StaticAnimation... animation) {
            this.autoAttackMotionMap.put(style, Lists.newArrayList(animation));
            return this;
        }



    }
}
