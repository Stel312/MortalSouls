package online.mortalsouls.mortalsouls.integration.epicfight.skills;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import online.mortalsouls.mortalsouls.MortalSouls;
import yesman.epicfight.api.data.reloader.SkillManager;
import yesman.epicfight.api.forgeevent.SkillBuildEvent;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.SkillCategories;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
@Mod.EventBusSubscriber(modid = MortalSouls.MODID, bus= Mod.EventBusSubscriber.Bus.FORGE)
public class MortalSkills {
    public static Skill lightningSkill;
    public static Skill comboTest;
    private MortalSkills()
    {}

    public static void register()
    {
        SkillManager.register(LightningTestSkill::new, WeaponInnateSkill.createWeaponInnateBuilder(),
                MortalSouls.MODID, "lightning_test");
        SkillManager.register(builder -> new SpecialAttackCombo.SpecialBuilder().setAttackAnimations(Animations.SWORD_AUTO1,
                        Animations.SWORD_AUTO2, Animations.SWORD_AUTO3, Animations.DAGGER_AUTO3)
                        .setJumpAttack(Animations.SWORD_AIR_SLASH).setDashAttack(Animations.DAGGER_DUAL_DASH).build(builder),
                (new Skill.Builder<WeaponInnateSkill>()).setCategory(SkillCategories.WEAPON_INNATE)
                        .setResource(Skill.Resource.NONE), MortalSouls.MODID, "combo_test");
    }

    @SubscribeEvent
    public static void buildSkillsEvent(SkillBuildEvent event)
    {
            lightningSkill = event.build(MortalSouls.MODID, "lightning_test");
            comboTest = event.build(MortalSouls.MODID, "combo_test");

    }
}
