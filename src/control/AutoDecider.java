package control;

import java.util.List;

import entity.BattleState;
import entity.Combatant;
import entity.actions.Action;
import entity.actions.BasicAttack;

public class AutoDecider implements ActionDecider {

	@Override
	public void decide(Combatant self, BattleState state) {
		Action toPlay = new BasicAttack();
		toPlay.execute(self, List.of(state.getPlayer()));
	}

}
