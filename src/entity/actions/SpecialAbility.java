package entity.actions;

import java.util.List;

import control.EndTurnHandler;
import entity.Combatant;
import entity.TurnSummary;

public abstract class SpecialAbility extends Action implements EndTurnHandler {
	private int maxCooldown;
	private int currentCooldown;
	
	public SpecialAbility(String name, TargetType targeting, int cooldown) {
		super(name, targeting);
		this.maxCooldown = cooldown;
		this.currentCooldown = 0;
	}
	
	public boolean isReady() {
		return currentCooldown <= 0;
	}

	public void endTurn() {
		if (currentCooldown > 0) {
			currentCooldown--;
		}
	}
	
	public TurnSummary execute(Combatant user, List<Combatant> targets) {
		TurnSummary summary = performSpecialEffect(user, targets);
		this.currentCooldown = maxCooldown;
		return summary;
	}
	
	protected abstract TurnSummary performSpecialEffect(Combatant user, List<Combatant> targets);

}
