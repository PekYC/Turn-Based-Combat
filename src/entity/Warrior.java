package entity;

public class Warrior extends Combatants {

	public Warrior() {
        // HP: 260, Attack: 40, Defense: 20, Speed: 30
        super("Warrior", 260, 40, 20, 30);
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
