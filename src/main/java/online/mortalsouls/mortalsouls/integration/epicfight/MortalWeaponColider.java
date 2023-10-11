package online.mortalsouls.mortalsouls.integration.epicfight;

import yesman.epicfight.api.collider.Collider;
import yesman.epicfight.api.collider.OBBCollider;
import yesman.epicfight.gameasset.ColliderPreset;

/**
 * @author NStel
 * Class file for the colliders custom categories
 */
public class MortalWeaponColider extends ColliderPreset {
    public static final Collider greathammer = new OBBCollider(1, 5, 1, 0, 0, 0);
    public static final Collider glaive = new OBBCollider(1, 1, 1, 0, 0, 0);
    public static final Collider greatshield = new OBBCollider(.5, 1, .5, 0, 0, 0);
}
