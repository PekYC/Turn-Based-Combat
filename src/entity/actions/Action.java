package entity.actions;

import entity.Combatant;
import entity.TurnSummary;
import java.util.List;

public abstract class Action {
	private String name;
	protected TargetType targeting;
	
	public Action(String name, TargetType targeting) {
		this.name = name;
		this.targeting = targeting;
	}
	
	public boolean isReady() {
		return true;
	}
	
	public abstract TurnSummary execute(Combatant user, List<Combatant> targets);
	
	public String getName() { return name; }
    public TargetType getTargeting() { return targeting; }
}
