package entity;



public class Wizard extends Combatant {

    public Wizard() {
        super("Wizard", 200, 50, 10, 20);
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

        if (this.selectedAction != null && this.selectedTargets != null) {
            this.lastTurnSummary = this.selectedAction.execute(this, this.selectedTargets);

            if (this.lastTurnSummary.getActionType() == ActionType.ARCANE_BLAST) {
                this.setSpecialCooldown(3);
                
                if (this.lastTurnSummary.isTargetEliminated()) {
                    this.boostAttack(10);
                }
            }

            this.selectedAction = null;
            this.selectedTargets = null;
        }
    }
}
