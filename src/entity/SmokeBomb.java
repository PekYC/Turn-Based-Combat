package entity;

import java.util.List;

import entity.actions.TargetType;
import entity.effects.SmokeBombEffect;

public class SmokeBomb extends Item {
    public SmokeBomb() {
		super("Smoke Bomb", "Enemy attacks deal 0 damage for 2 turns", TargetType.SELF);
	}

	@Override
	public TurnSummary use(Combatant user, List<Combatant> targets) {
    	user.applyStatus(new SmokeBombEffect());
		return new TurnSummary();
	}
}
