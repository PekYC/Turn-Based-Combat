package entity;

public class PowerStone implements Item {

    @Override
    public String getName() { return "Power Stone"; }

    @Override
    public String getDescription() { return "Free use of special skill (no cooldown change)"; }

    @Override
    public void use(Combatants user) {
        System.out.println(user.getName() + " used Power Stone!");
        int savedCooldown = user.getSpecialCooldown();
        user.setSpecialCooldown(savedCooldown); // restore — Power Stone does not affect cooldown
    }
}
