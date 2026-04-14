package entity;

import entity.actions.TargetType;
import entity.effects.SmokeBombEffect;

public class SmokeBomb extends Item {
    public SmokeBomb() {
		super("Smoke Bomb", "Enemy attacks deal 0 damage for 2 turns", TargetType.SELF);
	}

    public void use(Player user) {
    	user.applyStatus(new SmokeBombEffect());
//        System.out.println(user.getName() + " used Smoke Bomb! Enemy attacks deal 0 damage for 2 turns.");
    }
}
