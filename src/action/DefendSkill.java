package action;

import entity.Combatants;
import entity.TurnSummary;
import entity.ActionType;
import java.util.List;

public class DefendSkill implements Action {
	@Override
    public TurnSummary execute(Combatants user, List<Combatants> targets) {
        // Increases defense by 10 for the current round and the next round (2 turns) 
        user.setDefending(2);

        return new TurnSummary(
            user.getName(), 
            user.getName(), 
            ActionType.DEFEND, 
            0, 
            0, 
            false, 
            false,
            false
        );
    }
}