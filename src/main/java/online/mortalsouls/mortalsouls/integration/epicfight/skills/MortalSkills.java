package online.mortalsouls.mortalsouls.integration.epicfight.skills;

import online.mortalsouls.mortalsouls.MortalSouls;
import yesman.epicfight.api.data.reloader.SkillManager;
import yesman.epicfight.api.forgeevent.SkillBuildEvent;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.WeaponInnateSkill;

public class MortalSkills {
    public static Skill lightningSkill;
    private MortalSkills()
    {}


    public static void register()
    {
        SkillManager.register(LightningTestSkill::new, WeaponInnateSkill.createWeaponInnateBuilder().setActivateType(Skill.ActivateType.ONE_SHOT), MortalSouls.MODID, "lightning_test");
    }

    public static void buildSkillsEvent(SkillBuildEvent event)
    {
            lightningSkill = ((WeaponInnateSkill)event.build(MortalSouls.MODID, "lightning_test"));
    }
}
