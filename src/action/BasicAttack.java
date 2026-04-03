package action;

import entity.Combatants;
import java.util.List;

public class BasicAttack implements Action {
    @Override
    public void execute(Combatants user, List<Combatants> targets) {
        Combatants target = targets.get(0);
        
        System.out.println(user.getName() + " performs a Basic Attack on " + target.getName() + "!");
        
        target.takeDamage(user.getAttack());
    }
}
