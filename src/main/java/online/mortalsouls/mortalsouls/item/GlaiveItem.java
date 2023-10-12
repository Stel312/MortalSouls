package online.mortalsouls.mortalsouls.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import online.mortalsouls.mortalsouls.client.entity.GlaiveProjectile;

public class GlaiveItem extends SwordItem {


    public GlaiveItem(Tier tier, int baseDamage, float attackSpeed, Properties properties) {
        super(tier, baseDamage, attackSpeed, properties);
    }


    @Override
    public int getUseDuration(ItemStack itemStack) {
        return 72000;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack itemStack) {
        return UseAnim.BOW;
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        if(!world.isClientSide && itemStack != null)
        {
            GlaiveProjectile glaiveProjectile = new GlaiveProjectile(world);
            int d = itemStack.getDamageValue();
            System.out.println(d);
            itemStack.setDamageValue(10);
            glaiveProjectile.getEntityData().set(GlaiveProjectile.ITEMSTACK, itemStack);
            glaiveProjectile.setPos(player.getX(), player.getY(), player.getZ());
            glaiveProjectile.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0f, 3f, 0);
            world.addFreshEntity(glaiveProjectile);

        }

        return super.use(world, player, interactionHand);
    }

}
