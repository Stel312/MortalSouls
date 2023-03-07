package online.mortalsouls.mortalsouls.integration.epicfight.skills;

import yesman.epicfight.api.forgeevent.SkillBuildEvent;
import yesman.epicfight.skill.Skill;

public class MortalSkills {
    public static Skill lightningSkill;
    private MortalSkills()
    {}


    public static void register()
    {
        // TODO document why this method is empty
        //SkillManager.register(LightningTestSkill::new);
    }

    public static void buildSkillsEvent(SkillBuildEvent event)
    {

    }
}
