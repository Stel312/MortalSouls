package online.mortalsouls.mortalsouls.integration.epicfight.skills;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.SkillCategories;
import yesman.epicfight.skill.SkillDataManager;
import yesman.epicfight.skill.WeaponInnateSkill;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;

public class LightningTestSkill extends WeaponInnateSkill {
    public LightningTestSkill(Builder<? extends Skill> builder) {
        super(builder);
    }

    @Override
    public boolean canExecute(PlayerPatch<?> executer) {
        return true;
    }

    @Override
    public boolean isExecutableState(PlayerPatch<?> executer) {
        return true;
    }

    @Override
    public void executeOnServer(ServerPlayerPatch executer, FriendlyByteBuf args) {
        super.executeOnServer(executer, args);
        executer.playAnimationSynchronized(Animations.SWORD_COMBO1, 0);
        double x;
        double y;
        double z;
        if(executer.getTarget() != null)
        {
            LivingEntity target = executer.getTarget();
            x = target.getX();
            y = target.getY();
            z = target.getZ();
        }
        else
        {
            ServerPlayer player = executer.getOriginal();
            Vec3 lookVector = player.getLookAngle();
            x = player.getX() + lookVector.x * 5;
            y = player.getY();
            z = player.getZ() + lookVector.z * 5;
        }
        LightningBolt lightningBolt = new LightningBolt(EntityType.LIGHTNING_BOLT,
                executer.getOriginal().getLevel());
        lightningBolt.setPos(x, y, z);
        executer.getOriginal().getLevel().addFreshEntity(lightningBolt);
    }

    @Override
    public WeaponInnateSkill registerPropertiesToAnimation() {
        return this;
    }


}
