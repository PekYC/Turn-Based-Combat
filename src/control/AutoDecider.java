package control;

import java.util.List;

import entity.BattleState;
import entity.Combatant;
import entity.TurnSummary;
import entity.actions.Action;
import entity.actions.BasicAttack;

public class AutoDecider implements ActionDecider {

	@Override
	public TurnSummary decide(Combatant self, BattleState state) {
		Action action = new BasicAttack();
		return action.execute(self, List.of(state.getPlayer()));
	}

}
