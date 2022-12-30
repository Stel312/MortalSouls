package online.mortalsouls.mortalsouls.integration.epicfight;

import yesman.epicfight.world.capabilities.item.WeaponCategory;

public class MyEpicWeapons {

    public enum MyWeaponCategories  implements WeaponCategory {GREATHAMMERS;

        @Override
        public int universalOrdinal() {
            return 0;
        }
    }

}
