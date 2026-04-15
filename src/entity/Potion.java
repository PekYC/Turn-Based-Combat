package entity;

import java.util.List;

import entity.actions.ActionType;
import entity.actions.TargetType;

public class Potion extends Item {

    public Potion() {
		super("Potion", "Restores 100 HP (capped at max HP)", TargetType.SELF);
		// TODO Auto-generated constructor stub
	}

    @Override
    public TurnSummary use(Combatant user, List<Combatant> targets) {
        int before = user.getHp();
        user.receiveHealing(100);
        int healed = user.getHp() - before;
    	
    	return new TurnSummary(
    			user.getName(),
    			user.getName(),
    			ActionType.ITEM_USE,
    			0,
    			healed, false,
    			false,
    			false,
    			before,
    			user.getHp(),
    			0,
    			0);
    }
}
