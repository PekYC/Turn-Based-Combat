package entity;

import control.ActionDecider;
import entity.actions.ShieldBash;

public class Warrior extends Player {

    public Warrior(ActionDecider decider) {
        super("Warrior", 260, 40, 20, 30, decider, new ShieldBash());
    }
}
