package online.mortalsouls.mortalsouls.integration.epicfight.skills;

import net.minecraft.network.FriendlyByteBuf;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.skill.*;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;

public class SpecialAttackCombo extends WeaponInnateSkill {
    private final StaticAnimation[] attackAnimations;
    private final SkillDataManager.SkillDataKey<Integer> combo = (SkillDataManager.SkillDataKey<Integer>) SkillDataManager.SkillDataKey
            .findById(0);

    public SpecialAttackCombo(Builder<? extends Skill> builder, StaticAnimation... animations) {
        super(builder);
        this.attackAnimations = animations;
    }

    @Override
    public boolean canExecute(PlayerPatch<?> executer) {
        return true;
    }

    @Override
    public void executeOnServer(ServerPlayerPatch executer, FriendlyByteBuf args) {
        super.executeOnServer(executer, args);
        SkillDataManager dataManager = executer.getSkill(SkillCategories.BASIC_ATTACK).getDataManager();
        int combo = dataManager.getDataValue(this.combo);

        if (attackAnimations != null && attackAnimations[combo] != null) {
            executer.playAnimationSynchronized(attackAnimations[combo], 0);
            dataManager.setData(this.combo, 0);
        }
    }

    @Override
    public void cancelOnServer(ServerPlayerPatch executer, FriendlyByteBuf args) {
        super.cancelOnServer(executer, args);
    }

    @Override
    public WeaponInnateSkill registerPropertiesToAnimation() {
        return null;
    }
}
