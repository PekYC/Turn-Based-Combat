package entity;

import entity.actions.TargetType;

public class PowerStone extends Item {

    public PowerStone() {
		super("Power Stone", "Free use of special skill (no cooldown change)", TargetType.SELF);
		// TODO Auto-generated constructor stub
	}
    @Override
    public void use(Player user) {
//        System.out.println(user.getName() + " used Power Stone!");
        int savedCooldown = user.getSpecialCooldown();
        user.setSpecialCooldown(savedCooldown); // restore — Power Stone does not affect cooldown
    }
}
