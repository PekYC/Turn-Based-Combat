package entity;

import control.EndTurnHandler;

public abstract class StatusEffect implements EndTurnHandler {
	private int turnsRemaining;
	private String name;
	private String description;
	protected Combatant self;
	
	public StatusEffect(int turnsRemaining, String name, String desc) {
		this.turnsRemaining = turnsRemaining;
		this.name = name;
		this.description = desc;
	}
	
	public void setTarget(Combatant self) {
		this.self = self;
	}
	
	public void onApply() { }
	
	public void onAttacking() {	}
	
	public void onReceivingAttack() { }
	
	public void onExpire() { }
	
	public boolean isExpired() {
		return turnsRemaining <= 0;
	}
	
	public void endTurn() {
		turnsRemaining--;
		if (isExpired()) {
			onExpire();
		}
	}

    public String getName() {
    	return name;
    }
    
    public String getDescription() {
    	return description + " (" + turnsRemaining + " turn(s) remaining)" ;
    }
}
