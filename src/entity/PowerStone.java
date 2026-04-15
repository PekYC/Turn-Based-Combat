package entity;

import java.util.List;

import entity.actions.SpecialAbility;

public class PowerStone extends Item {
	SpecialAbility ability;

    public PowerStone(SpecialAbility ability) {
		super("Power Stone", "Free use of special skill (no cooldown change)", ability.getTargeting());
		this.ability = ability;
	}

	@Override
	public TurnSummary use(Combatant user, List<Combatant> targets) {
		return ability.performSpecialEffect(user, targets);
	}
}
