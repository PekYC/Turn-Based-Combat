package entity;

import java.util.List;
import entity.actions.BasicAttack;

public class Goblin extends Combatants {

    public Goblin(String id) {
        super("Goblin " + id, 60, 30, 10, 25);
    }

    @Override
    public void performTurn(BattleState state) {
        if (isStunned()) {
            this.lastTurnSummary = new TurnSummary(
                this.name,
                this.name,
                ActionType.STUNNED_SKIP,
                0,
                0,
                false,
                false,
                false,
                this.hp,
                this.hp,
                0,
                0
            );
            return;
        }

        this.selectedAction = new BasicAttack();
        this.selectedTargets = List.of(state.getPlayer());

        if (this.selectedAction != null && this.selectedTargets != null) {
            this.lastTurnSummary = this.selectedAction.execute(this, this.selectedTargets);
        }
    }
}