package entity;

import java.util.ArrayList;
import java.util.List;

import control.ActionDecider;
import entity.actions.SpecialAbility;

public abstract class Player extends Combatant {
	private List<Item> items;
	private SpecialAbility ability;
	
	public Player(String name, int hp, int attack, int defense, int speed, ActionDecider decider, SpecialAbility ability) {
		super(name, hp, attack, defense, speed, decider);
		
		this.items = new ArrayList<>();
		this.ability = ability;
	}
	
	@Override
	public void endTurn() {
		super.endTurn();
		ability.endTurn();
	}
	
	public void giveItems(List<Item> items) { this.items = items; }
	public SpecialAbility getAbility() { return ability; }

}
