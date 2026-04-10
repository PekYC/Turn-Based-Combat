package entity;

public class SmokeBombEffect implements StatusEffect {

    private int turnsRemaining = 2;

    @Override
    public String getName() { return "SmokeBomb"; }

    @Override
    public void apply(Combatant target) {
        turnsRemaining--;
    }

    @Override
    public void remove(Combatant target) {
        target.setSmokeBombDuration(0);
    }

    @Override
    public boolean isExpired() { return turnsRemaining <= 0; }

    @Override
    public String getDescription() {
        return "Smoke Bomb active - enemy attacks deal 0 damage (" + turnsRemaining + " turn(s))";
    }
}
