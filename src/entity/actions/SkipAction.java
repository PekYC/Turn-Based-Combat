package entity.actions;

import java.util.List;

import entity.Combatant;
import entity.TurnSummary;

public class SkipAction extends Action {

	public SkipAction(String name) {
		super(name, TargetType.SELF);
	}

	@Override
	public TurnSummary execute(Combatant user, List<Combatant> targets) {
		return new TurnSummary(
			user.getName(),
			this.getName(),
			ActionType.STUNNED_SKIP,
			0,
			0,
			false,
			false,
			false,
			user.getHp(),
			user.getHp(),
			0,
			0
		);
	}

}
