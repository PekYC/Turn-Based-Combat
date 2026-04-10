package entity;

import control.ActionDecider;

public class Wizard extends Player {

    public Wizard(ActionDecider decider) {
        super("Wizard", 200, 50, 10, 20, decider);
    }
}
