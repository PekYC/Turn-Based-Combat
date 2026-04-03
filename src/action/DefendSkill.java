package action;

import entity.Combatants;
import java.util.List;

public class DefendSkill implements Action {
    @Override
    public void execute(Combatants user, List<Combatants> targets) {
        System.out.println(user.getName() + " takes a defensive stance!");
        
        user.setDefending(true);
    }
}
