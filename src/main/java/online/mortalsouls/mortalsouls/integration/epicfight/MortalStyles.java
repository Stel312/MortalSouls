package online.mortalsouls.mortalsouls.integration.epicfight;

import yesman.epicfight.world.capabilities.item.Style;
import yesman.epicfight.world.capabilities.item.WeaponCategory;

public class MortalStyles implements Style {

    final int id;

    MortalStyles() {
        this.id = Style.ENUM_MANAGER.assign(this);
    }

    @Override
    public int universalOrdinal() {
        return this.id;
    }

    @Override
    public boolean canUseOffhand() {
        return false;
    }
}
