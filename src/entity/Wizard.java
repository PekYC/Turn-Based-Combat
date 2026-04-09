package entity;

public class Wizard extends Combatants {

    public Wizard() {
        // HP: 200, Attack: 50, Defense: 10, Speed: 20
        super("Wizard", 200, 50, 10, 20);
    }

    @Override
    public void performTurn(BattleState state) {
      
        if (isStunned()) {
            this.lastTurnSummary = new TurnSummary(
                this.name, 
                this.name, 
                ActionType.STUNNED_SKIP, 
                0, 0, false, false, 
                false 
            );
            return;
        }

    }
}
