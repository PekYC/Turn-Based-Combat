package action;

import entity.Combatants;
import entity.TurnSummary;
import entity.ActionType;
import java.util.List;

public class ShieldBash implements Action {
    @Override
    public TurnSummary execute(Combatants user, List<Combatants> targets) {
        // Shield Bash targets a single selected enemy 
        Combatants target = targets.get(0);
        
        int damageDealt = target.receiveDamage(user.getAttack());
        
                
        target.setStunned(2);
              
        user.setSpecialCooldown(3);
      
        return new TurnSummary(
    	    user.getName(), 
    	    target.getName(), 
    	    ActionType.SHIELD_BASH, 
    	    damageDealt,
    	    0,
    	    true,
    	    !target.isAlive(), 
    	    false 
    	);
    }
}
	