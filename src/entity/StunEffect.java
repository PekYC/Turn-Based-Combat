package entity;

public class StunEffect extends StatusEffect {
    public StunEffect(Combatant self) {
    	super(2, "Stun", "Stunned - cannot act (", self);
    }
}
