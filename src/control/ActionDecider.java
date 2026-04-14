package control;

import entity.BattleState;
import entity.Combatant;
import entity.TurnSummary;

public interface ActionDecider {
	TurnSummary decide(Combatant self, BattleState state);
}
