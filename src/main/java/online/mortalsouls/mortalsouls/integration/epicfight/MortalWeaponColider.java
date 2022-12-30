package online.mortalsouls.mortalsouls.integration.epicfight;

import yesman.epicfight.api.collider.Collider;
import yesman.epicfight.api.collider.OBBCollider;
import yesman.epicfight.gameasset.ColliderPreset;

public class MortalWeaponColider extends ColliderPreset {
    public static final Collider greatHammer = new OBBCollider(1, 5, 1, 0 ,0 ,0);
}
