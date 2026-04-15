package entity;

import java.util.List;

import entity.actions.TargetType;

public abstract class Item {
	private String name;
	private String description;
	private TargetType targeting;
	
	public Item(String name, String description, TargetType targeting) {
		this.name = name;
		this.description = description;
		this.targeting = targeting;
	}
	
	public String getName() { return name; }
    public String getDescription() { return description; }
    public TargetType getTargeting() { return targeting; }
    
    public abstract TurnSummary use(Combatant user, List<Combatant> targets);
    // remember to automate the removing of item
}
