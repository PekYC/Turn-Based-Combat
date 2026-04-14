package entity;

import control.ActionDecider;
import entity.actions.ArcaneBlastAction;

public class Wizard extends Player {

    public Wizard(ActionDecider decider) {
        super("Wizard", 200, 50, 10, 20, decider, new ArcaneBlastAction());
    }
}
