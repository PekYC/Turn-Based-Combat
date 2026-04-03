package entity;

import java.util.List;

public class Wizard extends Combatants {

    public Wizard() {
        // (name, maxHp, attack, defense, speed) 
        super("Wizard", 200, 50, 10, 20);
    }

    // Special Skill: Arcane Blast Effect: Deal BasicAttack damage to all enemies currently in combat. 
    // Each enemy defeated by Arcane Blast adds 10 to the Wizard’s Attack, lasting until end of the level.
    public void arcaneBlast(List<Combatants> enemies) {
        System.out.println(getName() + " casts Arcane Blast on all enemies!");

        for (Combatants enemy : enemies) {
            if (enemy.getHp() > 0) { 
                enemy.takeDamage(this.getAttack());

                // Check if the enemy was defeated by this attack 
                if (enemy.getHp() <= 0) {
                    // Permanent boost
                    this.setAttack(this.getAttack() + 10);
                    System.out.println("Enemy defeated! Wizard Attack increased to: " + getAttack());
                }
            }
        }

        // Start the 3-turns cooldown 
        this.startSkillCooldown();
    }
}
