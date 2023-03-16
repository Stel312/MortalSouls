package online.mortalsouls.mortalsouls.integration.epicfight.skills;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.SkillCategories;
import yesman.epicfight.skill.SkillDataManager;
import yesman.epicfight.skill.WeaponInnateSkill;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;

public class SpecialAttackCombo extends WeaponInnateSkill {
    private final StaticAnimation[] attackAnimations;
    private final StaticAnimation jumpAttack;
    private final StaticAnimation dashAttack;
    private final SkillDataManager.SkillDataKey<Integer> combo = (SkillDataManager.SkillDataKey<Integer>) SkillDataManager.SkillDataKey
            .findById(0);
    private final Skill specialSkill = MortalSkills.lightningSkill;



    public SpecialAttackCombo(Builder<? extends Skill> builder,StaticAnimation dashAttack,
                              StaticAnimation jumpAttack, StaticAnimation... heavyAnimations) {
        super(builder);
        this.attackAnimations = heavyAnimations;
        this.dashAttack = dashAttack;
        this.jumpAttack = jumpAttack;
    }

    @Override
    public boolean canExecute(PlayerPatch<?> executer) {
        return true;
    }

    @Override
    public void executeOnServer(ServerPlayerPatch executer, FriendlyByteBuf args) {
        super.executeOnServer(executer, args);
        ServerPlayer serverPlayer = executer.getOriginal();
        SkillDataManager dataManager = executer.getSkill(SkillCategories.BASIC_ATTACK).getDataManager();
        int combo = dataManager.getDataValue(this.combo);
        if(serverPlayer.isShiftKeyDown()) {
            specialSkill.executeOnServer(executer,args);
        } else if (!serverPlayer.isOnGround() && serverPlayer.fallDistance <2) {
            executer.playAnimationSynchronized(jumpAttack,0);
        } else if(serverPlayer.isSprinting()) {
            executer.playAnimationSynchronized(dashAttack, 0);
        } else if (attackAnimations != null && attackAnimations[combo] != null) {
            executer.playAnimationSynchronized(attackAnimations[combo], 0);
            dataManager.setData(this.combo, 0);
        }
    }

    @Override
    public ResourceLocation getSkillTexture() {
        return specialSkill.getSkillTexture();
    }

    @Override
    public WeaponInnateSkill registerPropertiesToAnimation() {
        return this;
    }
}
