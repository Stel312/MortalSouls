package online.mortalsouls.mortalsouls.integration.epicfight;

import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.world.capabilities.item.CapabilityItem;

import java.util.HashMap;
import java.util.Map;

public enum GuardMapEnum {
    INSTANCE;
    private final Map<String, GuardObject> guardMap = new HashMap<>();
    GuardMapEnum()
    {
        guardMap.put(MortalEpicWeapons.MortalWeaponCategories.GREATSHIELD.toString()+ CapabilityItem.Styles.TWO_HAND,
                new GuardObject(Animations.GREATSWORD_GUARD_HIT, Animations.GREATSWORD_GUARD_BREAK,
                        Animations.GREATSWORD_GUARD_HIT));

    }

    public Map<String, GuardObject> getGuardMap() {
        return this.guardMap;
    }
}
