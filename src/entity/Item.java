package entity;

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
    
    public abstract void use(Player user);
}
