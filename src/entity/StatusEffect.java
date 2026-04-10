package entity;

import control.EndTurnHandler;

public abstract class StatusEffect implements EndTurnHandler {
	private int turnsRemaining;
	private String name;
	private String description;
	
	public StatusEffect(int turnsRemaining, String name, String desc) {
		this.turnsRemaining = turnsRemaining;
		this.name = name;
		this.description = desc;
	}
	
	public void endTurn() {
		turnsRemaining--;
	}
    
    public boolean isExpired() {
		return turnsRemaining <= 0;
	}

    public String getName() {
    	return name;
    }
    
    public String getDescription() {
    	return description + " (" + turnsRemaining + " turn(s) remaining)" ;
    }
}
