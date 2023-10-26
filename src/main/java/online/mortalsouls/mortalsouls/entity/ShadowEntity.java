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
    public ShadowEntity(EntityType<? extends Mob> entityType, Level level) {
        super(entityType, level);
        this.noCulling = true;
        this.setInvulnerable(true);
    }

    public ShadowEntity(PlayMessages.SpawnEntity spawnEntity, Level level) {
        super(ModEntity.TYPE_SHADOW.get(), level);
        this.noCulling = true;
        this.setInvulnerable(true);
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
        super.defineSynchedData();
    }


    @Override
    public void tick() {
        super.tick();
        if(this.player == null)
            this.kill();
        else {
            double lookz = player.getLookAngle().z;
            double lookx = player.getLookAngle().x;
            double posx = player.position().x;
            double posy = player.position().y;
            double posz = player.position().z;
            double scale = Math.sqrt((lookx * lookx) + (lookz * lookz));

            this.setPos(posx - lookx / scale , posy + .5, posz - lookz / scale);
            this.setYBodyRot(player.yBodyRot);
            this.setYHeadRot(player.yHeadRot);
            this.setRot((float) lookz,(float) lookx);

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
    public Player getPlayer()
    {
        return this.player;
    }

}
