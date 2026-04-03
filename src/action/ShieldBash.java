package action;

import entity.Combatants;
import java.util.List;

public class ShieldBash implements Action {
    @Override
    public void execute(Combatants user, List<Combatants> targets) {
        // single-target move 
        Combatants target = targets.get(0);
        
        System.out.println(user.getName() + " slams their shield into " + target.getName() + "!");
        
        target.takeDamage(user.getAttack());
        
        target.applyStun(2); 
        
        user.startSkillCooldown();
    }
}