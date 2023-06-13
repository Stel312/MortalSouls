package online.mortalsouls.mortalsouls.integration.epicfight.skills;

import yesman.epicfight.skill.SkillCategory;

public enum EpicMortalSkillCategories implements SkillCategory {
    SPECIALATTACK(false, false, false);

    boolean shouldSaved;
    boolean shouldSyncronized;
    boolean modifiable;
    int id;

    EpicMortalSkillCategories(boolean shouldSaved, boolean shouldSyncronized, boolean modifiable)
    {
        this.shouldSaved = shouldSaved;
        this.shouldSyncronized = shouldSyncronized;
        this.modifiable = modifiable;
        this.id = SkillCategory.ENUM_MANAGER.assign(this);
    }
    @Override
    public boolean shouldSave() {
        return shouldSaved;
    }

    @Override
    public boolean shouldSynchronize() {
        return shouldSyncronized;
    }

    @Override
    public boolean learnable() {
        return modifiable;
    }

    @Override
    public int universalOrdinal() {
        return id;
    }
}
