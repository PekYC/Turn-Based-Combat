package entity;

import control.ActionDecider;

public abstract class Enemy extends Combatant {
	public Enemy(String name, int hp, int atk, int def, int spd, ActionDecider decider) {
		super(name, hp, atk, def, spd, decider);
	}
}
