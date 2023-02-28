package online.mortalsouls.mortalsouls.integration.epicfight.capabilities;

import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.skill.GuardSkill;

public class GuardObject {
    private StaticAnimation guardHit;
    private StaticAnimation guardBreak;
    private StaticAnimation advancedGuard;

    public GuardObject(StaticAnimation guardHit, StaticAnimation guardBreak, StaticAnimation advancedGuard)
    {
        this.guardHit = guardHit;
        this.guardBreak = guardBreak;
        this.advancedGuard = advancedGuard;
    }

    public StaticAnimation getGuardAnimation(GuardSkill.BlockType blockType)
    {
        return switch (blockType) {
            case GUARD -> guardHit;
            case GUARD_BREAK -> guardBreak;
            case ADVANCED_GUARD -> advancedGuard;
        };
    }


}
