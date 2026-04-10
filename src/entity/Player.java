package entity;

import java.util.ArrayList;
import java.util.List;

import control.ActionDecider;

public abstract class Player extends Combatant {
	private List<Item> items;
	private int specialCooldown;
	
	public Player(String name, int hp, int attack, int defense, int speed, ActionDecider decider) {
		super(name, hp, attack, defense, speed, decider);
		
		this.items = new ArrayList<>();
		
	}
        

//        this.selectedAction = new BasicAttack();
//        this.selectedTargets = List.of(state.getPlayer());
//
//        if (this.selectedAction != null && this.selectedTargets != null) {
//            this.lastTurnSummary = this.selectedAction.execute(this, this.selectedTargets);
//        }

	
	@Override
	public void endTurn() {
		if (specialCooldown > 0) specialCooldown--;
		super.endTurn();
	}
	
	public void giveItems(List<Item> items) { this.items = items; }
    public int getSpecialCooldown() { return specialCooldown; }
    public void setSpecialCooldown(int duration) { this.specialCooldown = duration; }

}
