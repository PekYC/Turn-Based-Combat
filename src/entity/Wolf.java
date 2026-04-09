package entity;

import java.util.List;
import entity.actions.BasicAttack;

public class Wolf extends Combatants {

    public Wolf(String id) {
        // HP: 40, Attack: 45, Defense: 5, Speed: 35

        super("Wolf " + id, 40, 45, 5, 35);
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