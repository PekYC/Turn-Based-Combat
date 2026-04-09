package entity;


public class Warrior extends Combatants {

    public Warrior() {
        super("Warrior", 260, 40, 20, 30);
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

            if (this.lastTurnSummary.getActionType() == ActionType.SHIELD_BASH) {
                this.setSpecialCooldown(3);
            }

            this.selectedAction = null;
            this.selectedTargets = null;
        }
    }
}
