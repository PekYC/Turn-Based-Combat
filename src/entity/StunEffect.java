package entity;

public class StunEffect implements StatusEffect {

    private int turnsRemaining = 2;

    @Override
    public String getName() { return "Stun"; }

    @Override
    public void apply(Combatants target) {
        target.setStunned(turnsRemaining);
        turnsRemaining--;
    }

    @Override
    public void remove(Combatants target) {
        target.setStunned(0);
    }

    @Override
    public boolean isExpired() { return turnsRemaining <= 0; }

    @Override
    public String getDescription() {
        return "Stunned - cannot act (" + turnsRemaining + " turn(s) remaining)";
    }
}
