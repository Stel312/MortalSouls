package online.mortalsouls.mortalsouls.item;

import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import online.mortalsouls.mortalsouls.MortalSouls;

/**
 * @author NStel
 * Class for registering and defining items
 */
public class ModItems {

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MortalSouls.MODID);
    public static final RegistryObject<Item> wardenSword = createWeapon("wardensword");
    public static final RegistryObject<Item> greathammer = createWeapon("greathammer");
    public static final RegistryObject<Item> shieldDoorR = createNewShield("giantdoorshieldr");
    public static final RegistryObject<Item> shieldDoorL = createNewShield("giantdoorshieldl");

    private ModItems() {
    }

    public static DeferredRegister<Item> getITEMS() {
        return ITEMS;
    }

    public static RegistryObject<Item> createWeapon(String name) {
        return ITEMS.register(name, () -> new SwordItem(Tiers.NETHERITE, 4, -2.4F, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1)));
    }

    public static RegistryObject<Item> createShield(String name) {
        return ITEMS.register(name, () -> new ShieldItem((new Item.Properties()).durability(336)
                .tab(CreativeModeTab.TAB_COMBAT)));
    }

    public static RegistryObject<Item> createNewShield(String name) {
        return ITEMS.register(name, () -> new ShieldAttackItem(Tiers.NETHERITE, 4, -2.4F,
                new Item.Properties().durability(336).tab(CreativeModeTab.TAB_COMBAT)));
    }
}
