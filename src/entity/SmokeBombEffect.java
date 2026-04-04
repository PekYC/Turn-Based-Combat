package entity;

public class SmokeBombEffect implements StatusEffect {

    private int turnsRemaining = 2;

    @Override
    public String getName() { return "SmokeBomb"; }

    @Override
    public void apply(Combatants target) {
        turnsRemaining--;
    }

    @Override
    public void remove(Combatants target) {
        target.setSmokeBombActive(false);
    }

    @Override
    public boolean isExpired() { return turnsRemaining <= 0; }

    @Override
    public String getDescription() {
        return "Smoke Bomb active - enemy attacks deal 0 damage (" + turnsRemaining + " turn(s))";
    }
}
