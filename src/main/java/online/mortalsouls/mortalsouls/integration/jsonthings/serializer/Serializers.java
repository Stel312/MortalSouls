package online.mortalsouls.mortalsouls.integration.jsonthings.serializer;

import com.google.gson.JsonObject;
import dev.gigaherz.jsonthings.things.IFlexItem;
import dev.gigaherz.jsonthings.things.serializers.FlexItemType;
import dev.gigaherz.jsonthings.things.serializers.IItemSerializer;
import joptsimple.internal.Strings;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.TieredItem;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.Objects;

public class Serializers {
    public static <T extends TieredItem & IFlexItem> IItemSerializer<T> glaiveSerializer(FlexItemType.DiggerFactory2<T> factory)
    {
        return data -> {

            String tier = parseTier(data);

            int damage = GsonHelper.getAsInt(data, "damage");
            float speed = GsonHelper.getAsFloat(data, "speed");

            return (props, builder) -> factory.create(Objects.requireNonNull(TierSortingRegistry.byName(new ResourceLocation(tier)), "The specified tier has not been found in the tier sorting registry"), damage, speed, props, builder);
        };
    }

    private static String parseTier(JsonObject data)
    {
        String tierName;
        if (data.has("tier"))
        {
            String str = data.get("tier").getAsString();
            if (!Strings.isNullOrEmpty(str))
                tierName = str;
            else
                throw new RuntimeException("Tool tier must be a non-empty string.");

        }
        else
            throw new RuntimeException("Tool info must have a non-empty 'tier' string.");
        return tierName;
    }
}
