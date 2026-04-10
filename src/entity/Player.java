package entity;

import java.util.ArrayList;
import java.util.List;

import control.CLIDecider;
import entity.actions.BasicAttack;

public abstract class Player extends Combatant {
	private List<Item> items;
	
	public Player(String name, int hp, int attack, int defense, int speed) {
		super(name, hp, attack, defense, speed, new CLIDecider());
		
		this.items = new ArrayList<>();
		
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
	
	public void giveItems(List<Item> items) {
		this.items = items;
	}

}
