package control;

import entity.BattleState;
import entity.Combatant;

public interface ActionDecider {
	void decide(Combatant self, BattleState state);
}
