package online.mortalsouls.mortalsouls.integration.epicfight;

import yesman.epicfight.world.capabilities.item.Style;

public enum MortalStyles implements Style {
    DUAL_GREASHIELD(true);

    private final int id;
    private final boolean canUseOffHand;

    MortalStyles(boolean canUseOffHand) {
        this.id = Style.ENUM_MANAGER.assign(this);
        this.canUseOffHand = canUseOffHand;
    }

    @Override
    public int universalOrdinal() {
        return this.id;
    }

    @Override
    public boolean canUseOffhand() {
        return canUseOffHand;
    }
}
