package entity;

public class SmokeBomb implements Item {

    @Override
    public String getName() { return "Smoke Bomb"; }

    @Override
    public String getDescription() { return "Enemy attacks deal 0 damage for 2 turns"; }

    @Override
    public void use(Combatants user) {
        user.applySmokeBomb();
        System.out.println(user.getName() + " used Smoke Bomb! Enemy attacks deal 0 damage for 2 turns.");
    }
}
