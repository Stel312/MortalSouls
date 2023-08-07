package online.mortalsouls.mortalsouls.integration.jsonthings.flexItemType;

import dev.gigaherz.jsonthings.things.IFlexItem;
import dev.gigaherz.jsonthings.things.StackContext;
import dev.gigaherz.jsonthings.things.builders.ItemBuilder;
import dev.gigaherz.jsonthings.things.events.FlexEventHandler;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Tier;
import online.mortalsouls.mortalsouls.item.GlaiveItem;
import org.jetbrains.annotations.Nullable;

public class FlexGlaiveItem extends GlaiveItem implements IFlexItem {
    public FlexGlaiveItem(Tier tier, int baseDamage, float attackSpeed, Properties properties, ItemBuilder itemBuilder) {
        super(tier, baseDamage, attackSpeed, properties);
        System.out.println("test");
    }

    @Override
    public void addCreativeStack(StackContext stackContext, Iterable<CreativeModeTab> iterable) {

    }

    @Override
    public void addEventHandler(String s, FlexEventHandler flexEventHandler) {

    }

    @Nullable
    @Override
    public FlexEventHandler getEventHandler(String s) {
        return null;
    }
}
