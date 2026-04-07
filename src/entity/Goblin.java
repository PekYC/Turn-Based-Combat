package entity;

public class Goblin extends Combatants {
	public Goblin(String id) {
        // HP: 55, Attack: 35, Defense: 15, Speed: 25
        super("Goblin " + id, 55, 35, 15, 25);
    }

    @Override
    public void performTurn(BattleState state) {
        if (isStunned()) {
            this.lastTurnSummary = new TurnSummary(
                this.name, 
                this.name, 
                ActionType.STUNNED_SKIP, 
                0, 0, false, false, false
            );
            return;
        }
    }
}
