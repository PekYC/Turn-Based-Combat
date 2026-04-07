package action;

import entity.Combatants;
import entity.TurnSummary;
import java.util.List;

public interface Action {
	TurnSummary execute(Combatants user, List<Combatants> targets);
}
