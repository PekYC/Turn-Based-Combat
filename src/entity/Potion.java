package entity;

public class Potion implements Item {

    @Override
    public String getName() { return "Potion"; }

    @Override
    public String getDescription() { return "Restores 100 HP (capped at max HP)"; }

    @Override
    public void use(Combatants user) {
        int before = user.getHp();
        user.receiveHealing(100);
        int healed = user.getHp() - before;
        System.out.println(user.getName() + " used Potion! HP: "
                + before + " -> " + user.getHp() + " (+" + healed + ")");
    }
}
