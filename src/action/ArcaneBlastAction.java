package action;

import entity.Combatants;
import java.util.List;

public class ArcaneBlastAction implements Action {
    @Override
    public void execute(Combatants user, List<Combatants> enemies) {
        System.out.println(user.getName() + " unleashes an arcane blast!");

        for (Combatants enemy : enemies) {
            if (enemy.getHp() > 0) {
                // Record HP before damage to identify a kill
                int hpBefore = enemy.getHp();
                enemy.takeDamage(user.getAttack());

                // If enemy was alive and is now defeated 
                if (hpBefore > 0 && enemy.getHp() == 0) {
                    // Permanent boost: +10 ATK 
                    user.setAttack(user.getAttack() + 10);
                    System.out.println("Wizard's power grows! ATK is now " + user.getAttack());
                }
            }
        }
        user.startSkillCooldown(); 
    }
}