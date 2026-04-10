package entity.actions;

import entity.Combatant;
import entity.TurnSummary;
import java.util.List;

public interface Action {
	TurnSummary execute(Combatant user, List<Combatant> targets);
}
