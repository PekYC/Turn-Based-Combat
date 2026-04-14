package entity;

import control.AutoDecider;

public class Goblin extends Combatant {

    public Goblin(String id) {
        super("Goblin " + id, 60, 30, 10, 25, new AutoDecider());
    }
}