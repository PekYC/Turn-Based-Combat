package entity;

public class DefendEffect implements StatusEffect {

    private int turnsRemaining = 2;
    private boolean applied = false;

    @Override
    public String getName() { return "Defend"; }

    @Override
    public void apply(Combatants target) {
        if (!applied) {
            target.setDefending(true);
            applied = true;
        }
        turnsRemaining--;
    }

    @Override
    public void remove(Combatants target) {
        target.setDefending(false);
    }

    @Override
    public boolean isExpired() { return turnsRemaining <= 0; }

    @Override
    public String getDescription() {
        return "Defending (+10 DEF, " + turnsRemaining + " turn(s) remaining)";
    }
}
