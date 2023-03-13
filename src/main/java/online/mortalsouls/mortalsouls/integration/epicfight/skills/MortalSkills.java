package online.mortalsouls.mortalsouls.integration.epicfight.skills;

import online.mortalsouls.mortalsouls.MortalSouls;
import yesman.epicfight.api.data.reloader.SkillManager;
import yesman.epicfight.api.forgeevent.SkillBuildEvent;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.WeaponInnateSkill;

public class MortalSkills {
    public static Skill lightningSkill;
    public static Skill combo_test;
    private MortalSkills()
    {}


    public static void register()
    {
        SkillManager.register(LightningTestSkill::new, WeaponInnateSkill.createWeaponInnateBuilder()
                .setActivateType(Skill.ActivateType.ONE_SHOT), MortalSouls.MODID, "lightning_test");
        SkillManager.register(builder -> new SpecialAttackCombo(builder, Animations.SWORD_COMBO1, Animations.SWORD_COMBO2,
                Animations.SWORD_COMBO3, Animations.DAGGER_AUTO3), WeaponInnateSkill.createWeaponInnateBuilder(), MortalSouls.MODID,
        "combo_test");

    }

    public static void buildSkillsEvent(SkillBuildEvent event)
    {
            lightningSkill = event.build(MortalSouls.MODID, "lightning_test");
            combo_test = event.build(MortalSouls.MODID, "combo_test");

    }
}
