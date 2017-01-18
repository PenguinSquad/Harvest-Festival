package joshie.harvest.quests.player.recipes;

import joshie.harvest.api.quests.HFQuest;
import joshie.harvest.npcs.HFNPCs;
import joshie.harvest.quests.base.QuestRecipe;

@HFQuest("recipe.salad")
public class QuestJenni5KSalad extends QuestRecipe {
    public QuestJenni5KSalad() {
        super("salad", HFNPCs.GS_OWNER, 5000);
    }
}
