package entity;

import entity.actions.TargetType;

public class Potion extends Item {

    public Potion() {
		super("Potion", "Restores 100 HP (capped at max HP)", TargetType.SELF);
		// TODO Auto-generated constructor stub
	}

    @Override
    public void use(Player user) {
        int before = user.getHp();
        user.receiveHealing(100);
        int healed = user.getHp() - before;
        System.out.println(user.getName() + " used Potion! HP: "
                + before + " -> " + user.getHp() + " (+" + healed + ")");
    }
}
