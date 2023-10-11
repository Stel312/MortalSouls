package online.mortalsouls.mortalsouls.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.PlayMessages;

public class ShadowEntity extends Mob {
    private Player player;
    public ShadowEntity(EntityType<? extends Mob> entityType, Level level, Player player)
    {
        this(entityType, level);
        this.player = player;

    }
    public ShadowEntity(EntityType<? extends Mob> entityType, Level level) {
        super(entityType, level);
    }

    public ShadowEntity(PlayMessages.SpawnEntity spawnEntity, Level level) {
        super(ModEntity.TYPE_SHADOW.get(), level);
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return Mob.createLivingAttributes()
                .add(Attributes.FOLLOW_RANGE, 0)
                .add(Attributes.MOVEMENT_SPEED, 0.22D)
                .add(Attributes.MAX_HEALTH, 70.0D)
                .add(Attributes.ATTACK_DAMAGE, 1.0D)
                .add(Attributes.ATTACK_KNOCKBACK, 1.0D);
    }
    @Override
    protected void defineSynchedData() {

    }


    @Override
    public void tick() {
        super.tick();
        if(this.player == null)
            this.kill();
        else {
            this.setPos(player.position().x + player.getLookAngle().x, player.position().y + player.getLookAngle().y, player.position().z + .5);
            this.setRot((float) player.getLookAngle().x(),(float) player.getLookAngle().y());
        }
    }

    @Override
    public void spawnAnim() {
        super.spawnAnim();
    }

    @Override
    protected boolean shouldDespawnInPeaceful() {
        return false;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
