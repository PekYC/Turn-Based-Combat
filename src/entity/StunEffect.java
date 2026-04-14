package entity;

import entity.actions.Action;
import entity.actions.SkipAction;

public class StunEffect extends StatusEffect {
    public StunEffect() {
    	super(2, "Stun", "Stunned - cannot act (");
    }
    
    public Action onStartTurn() {
    	return new SkipAction("Stunned");
    }
}
