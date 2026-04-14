package entity;

import entity.effects.SmokeBombEffect;

public class SmokeBomb implements Item {

    @Override
    public String getName() { return "Smoke Bomb"; }

    @Override
    public String getDescription() { return "Enemy attacks deal 0 damage for 2 turns"; }

    @Override
    public void use(Player user) {
    	user.applyStatus(new SmokeBombEffect());
//        System.out.println(user.getName() + " used Smoke Bomb! Enemy attacks deal 0 damage for 2 turns.");
    }
}
