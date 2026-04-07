package action;

import entity.Combatants;
import entity.TurnSummary;
import entity.ActionType;
import java.util.List;

public class BasicAttack implements Action {
	@Override
    public TurnSummary execute(Combatants user, List<Combatants> targets) {
        Combatants target = targets.get(0);
        int damageDealt = target.receiveDamage(user.getAttack());
        
        return new TurnSummary(
			user.getName(), 
		    target.getName(), 
		    ActionType.BASIC_ATTACK, 
		    damageDealt, 
		    0, 
		    false, 
		    !target.isAlive(), 
		    false 
        );
    }
}