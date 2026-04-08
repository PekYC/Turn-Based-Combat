package entity.actions;

import entity.Combatants;
import entity.TurnSummary;
import entity.ActionType;
import java.util.List;

public class ArcaneBlastAction implements Action {
    @Override
    public TurnSummary execute(Combatants user, List<Combatants> targets) {
        int totalDamage = 0;
        boolean anyKilled = false;

        // Deal damage to all enemies currently in combat 
        for (Combatants target : targets) {
            if (target.isAlive()) {               
                int damage = target.receiveDamage(user.getAttack());
                totalDamage += damage;
                
                // Each enemy defeated adds 10 to Wizard's Attack 
                if (!target.isAlive()) {
                    user.boostAttack(10);
                    anyKilled = true;
                }
            }
        }

        user.setSpecialCooldown(3);

        return new TurnSummary(
            user.getName(), 
            "", 
            ActionType.ARCANE_BLAST, 
            totalDamage, 
            0, 
            false, 
            anyKilled, 
            true // isAreaEffect = true
        );
    }
}