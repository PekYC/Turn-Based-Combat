package control;

import entity.BattleState;
import entity.Combatant;
import entity.actions.Action;

public interface ActionDecider {
	Action decide(Combatant self, BattleState state);
}
