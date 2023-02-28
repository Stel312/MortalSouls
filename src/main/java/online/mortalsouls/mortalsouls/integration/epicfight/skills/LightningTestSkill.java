package online.mortalsouls.mortalsouls.integration.epicfight.skills;

import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.WeaponInnateSkill;

public class LightningTestSkill extends WeaponInnateSkill {
    public LightningTestSkill(Builder<? extends Skill> builder) {
        super(builder);
    }




    @Override
    public WeaponInnateSkill registerPropertiesToAnimation() {
        return null;
    }
}
